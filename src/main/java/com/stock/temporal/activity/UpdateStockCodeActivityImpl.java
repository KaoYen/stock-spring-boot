package com.stock.temporal.activity;

import com.stock.dto.tpex.MainboardQuotesDto;
import com.stock.dto.twse.StockDayAllDto;
import com.stock.entity.TwAllStockCode;
import com.stock.repository.ITwAllStockCode;
import com.stock.service.StockService;
import io.temporal.activity.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class UpdateStockCodeActivityImpl implements UpdateStockCodeActivity {

    @Autowired
    private StockService stockService;

    @Autowired
    private ITwAllStockCode iTWAllStockCode;


    @Override
    public void updateStockCode() {
        try {
            // 上市股票代號資訊
            List<StockDayAllDto> twseStockRawData = stockService.twseStockDayAllFetcher();
            List<TwAllStockCode> insertList = new ArrayList<TwAllStockCode>();
            for (StockDayAllDto stock : twseStockRawData) {
                TwAllStockCode theTwAllStockCode = new TwAllStockCode();
                theTwAllStockCode.setStockCode(stock.getCode());
                theTwAllStockCode.setStockName(stock.getName());
                theTwAllStockCode.setStockType("TWSE");
                insertList.add(theTwAllStockCode);
            }

            // 上櫃股票代號資訊
            List<MainboardQuotesDto> tpexStockRawData = stockService.tpexMainBoardQuotesFetcher();
            for (MainboardQuotesDto stock : tpexStockRawData) {
                TwAllStockCode theTwAllStockCode = new TwAllStockCode();
                theTwAllStockCode.setStockCode(stock.getSecuritiesCompanyCode());
                theTwAllStockCode.setStockName(stock.getCompanyName());
                theTwAllStockCode.setStockType("TPEX");
                insertList.add(theTwAllStockCode);
            }

            iTWAllStockCode.saveAll(insertList);
        } catch (Exception e) {
            throw Activity.wrap(e);
        }
    }


}
