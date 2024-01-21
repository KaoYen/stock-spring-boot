package com.stock.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.stock.dto.tpex.MainboardQuotesDto;
import com.stock.dto.twse.StockDayAllDto;
import com.stock.dto.twse.StockDayDto;
import com.stock.exception.DataNotFoundException;
import com.stock.exception.ServiceException;
import com.stock.utils.HttpUtil;
import org.apache.commons.collections4.MapUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class StockService {
    private static final String TWSE_OPENAPI_URL = "https://openapi.twse.com.tw/v1"; // api doc: https://openapi.twse.com.tw

    private static final String TPEX_BASE_URL = "https://www.tpex.org.tw/openapi/v1"; // api doc: https://www.tpex.org.tw/openapi

    private static final String TESE_BASE_URL = "https://www.twse.com.tw";

    private static final Gson gson = new Gson();

    /**
     * 上市個股日成交資訊
     *
     * @return
     * @throws Exception
     */
    public List<StockDayAllDto> twseStockDayAllFetcher() throws Exception {
        System.out.println("取得上市個股日成交資訊");
        String apiUrl = TWSE_OPENAPI_URL + "/exchangeReport/STOCK_DAY_ALL";
        String response = HttpUtil.get(apiUrl);


        Type twseStockList = new TypeToken<List<StockDayAllDto>>() {
        }.getType();
        return gson.fromJson(response, twseStockList);
    }

    /**
     * 個股日成交資訊
     *
     * @param date
     * @param stockNo
     * @return
     * @throws Exception
     */
    public StockDayDto fetchExchangeReport(String date, String stockNo) throws Exception {
        String apiUrl = TESE_BASE_URL + "/pcversion/zh/exchangeReport/STOCK_DAY";

        Map params = new HashMap();
        params.put("response", "json");
        params.put("date", date);
        params.put("stockNo", stockNo);
        String response = HttpUtil.post(apiUrl, params);
        StockDayDto stockDayDto = gson.fromJson(response, StockDayDto.class);

        return stockDayDto;
    }

    /**
     * 上櫃股票收盤行情
     *
     * @return
     * @throws Exception
     */
    public List<MainboardQuotesDto> tpexMainBoardQuotesFetcher() throws Exception {
        System.out.println("取得上櫃股票收盤行情");
        String apiUrl = TPEX_BASE_URL + "/tpex_mainboard_quotes";
        String response = HttpUtil.get(apiUrl);

        Type tpexStockList = new TypeToken<List<MainboardQuotesDto>>() {
        }.getType();
        return gson.fromJson(response, tpexStockList);
    }

    private static String formatDateToYYYYMMDD(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        Date date = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        return dateFormat.format(date);
    }


}

