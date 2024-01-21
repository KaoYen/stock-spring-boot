package com.stock.temporal.activity;

import com.stock.dto.twse.StockDayDto;
import com.stock.entity.TwseStock;
import com.stock.exception.DataNotFoundException;
import com.stock.exception.ServiceException;
import com.stock.repository.TwStockRawDataRepository;
import com.stock.service.StockService;
import io.temporal.activity.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FetchStockActivityImpl implements FetchStockActivity {

    @Autowired
    StockService stockService;

    @Autowired
    TwStockRawDataRepository twStockRawDataRepository;

    @Override
    public void fetchTwseStockData2DB(String date, String stockNo) {
        try {
            StockDayDto stockDayDto = stockService.fetchExchangeReport(date, stockNo);

            try {
                this.validExchangeReportRes(stockDayDto);

            } catch (DataNotFoundException e) {
                // 查無資料視為正常
                return;
            }

            List<TwseStock> insertList = new ArrayList<TwseStock>();
            List<List<String>> dataList = stockDayDto.getData();
            for (List<String> data : dataList) {
                String stockDate = data.get(0);
                String stockTradingVolume = data.get(1);
                String stockTradingValue = data.get(2);
                String stockOpeningPrice = data.get(3);
                String stockHighestPrice = data.get(4);
                String stockLowestPrice = data.get(5);
                String stockClosingPrice = data.get(6);
                String stockPriceDifference = data.get(7);
                String stockTransactionVolume = data.get(8);

                TwseStock twseStock = new TwseStock();
                twseStock.setStockNo(stockNo);
                twseStock.setStockDate(stockDate);
                twseStock.setStockTradingVolume(stockTradingVolume);
                twseStock.setStockTradingValue(stockTradingValue);
                twseStock.setStockOpeningPrice(stockOpeningPrice);
                twseStock.setStockHighestPrice(stockHighestPrice);
                twseStock.setStockLowestPrice(stockLowestPrice);
                twseStock.setStockClosingPrice(stockClosingPrice);
                twseStock.setStockPriceDifference(stockPriceDifference);
                twseStock.setStockTransactionVolume(stockTransactionVolume);
                insertList.add(twseStock);
            }
            twStockRawDataRepository.saveAll(insertList);
        } catch (Exception e) {
            throw Activity.wrap(e);
        }

    }

    /**
     * API回傳欄位檢查
     *
     * @param stockDayDto
     * @throws Exception
     */
    private void validExchangeReportRes(StockDayDto stockDayDto) throws ServiceException, DataNotFoundException {
        String stat = stockDayDto.getStat();
        if ("很抱歉，沒有符合條件的資料!".equals(stat)) {
            throw new DataNotFoundException("查無資料!");

        } else if (!"OK".equalsIgnoreCase(stat)) {
            throw new ServiceException("個股日成交資訊API回傳狀態有誤: " + stat);
        }

        List fields = stockDayDto.getFields();
        String[] fieldArray = new String[]{"日期", "成交股數", "成交金額", "開盤價", "最高價", "最低價", "收盤價", "漲跌價差", "成交筆數"};
        for (String field : fieldArray) {
            if (!fields.contains(field)) {
                throw new ServiceException("個股日成交資訊API field 欄位有誤!");
            }
        }

    }
}
