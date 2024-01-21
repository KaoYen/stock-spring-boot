package com.stock.service;

import com.stock.StockApplication;
import com.stock.dto.tpex.MainboardQuotesDto;
import com.stock.dto.twse.StockDayAllDto;
import com.stock.entity.TwAllStockCode;
import com.stock.entity.TwseStock;
import com.stock.repository.ITwAllStockCode;
import com.stock.repository.TwStockRawDataRepository;
import com.stock.temporal.utils.WorkerHelper;
import com.stock.temporal.workflow.FetchStockWorkflow;
import io.temporal.client.WorkflowClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = StockApplication.class)
public class StockServiceTest {

    @Autowired
    private StockService stockService;

    @Autowired
    TwStockRawDataRepository iTWStockRawDataRepository;

    @Autowired
    ITwAllStockCode iTWAllStockCode;


    @Test
    public void teseStockDayAllFetcherTest() throws Exception {
        List<StockDayAllDto> stockRawData = stockService.twseStockDayAllFetcher();

        List<TwAllStockCode> insertList = new ArrayList<TwAllStockCode>();
        for (StockDayAllDto stock : stockRawData) {

            TwAllStockCode theTwAllStockCode = new TwAllStockCode();
            theTwAllStockCode.setStockCode(stock.getCode());
            theTwAllStockCode.setStockName(stock.getName());
            insertList.add(theTwAllStockCode);
        }
        iTWAllStockCode.saveAll(insertList);

    }

    @Test
    public void tpexStockDayAllFetcherTest() throws Exception {
        List<MainboardQuotesDto> stockRawData = stockService.tpexMainBoardQuotesFetcher();

        List<TwAllStockCode> insertList = new ArrayList<TwAllStockCode>();
        for (MainboardQuotesDto stock : stockRawData) {

            TwAllStockCode theTwAllStockCode = new TwAllStockCode();
            theTwAllStockCode.setStockCode(stock.getSecuritiesCompanyCode());
            theTwAllStockCode.setStockName(stock.getCompanyName());
            insertList.add(theTwAllStockCode);
        }
        TwAllStockCode theTwAllStockCode = new TwAllStockCode();
        theTwAllStockCode.setStockCode("000000");
        theTwAllStockCode.setStockName("test");
        insertList.add(theTwAllStockCode);
        iTWAllStockCode.saveAll(insertList);


    }

    @Test
    public void getStockDateList() {
        List<TwAllStockCode> stockCodeList = iTWAllStockCode.findByStockType("TWSE");

        var workflowClient = WorkerHelper.getWorkflowClient();


        for (TwAllStockCode item : stockCodeList) {

            int current = 20100101;
            int max = 20240101;
            int month = 1;

            while (current < max) {
                if (month == 12) {
                    month = 1;
                    current += 8900;
                } else {
                    month += 1;
                    current += 100;
                }

                FetchStockWorkflow workflow = workflowClient.newWorkflowStub(FetchStockWorkflow.class,
                        WorkerHelper.defaultWorkflowOptions(WorkerHelper.FETCH_STOCK_TASK_QUEUE));

                // Asynchronously start the workflow execution
                WorkflowClient.start(workflow::fetchStockData2DB, String.valueOf(current), item.getStockCode());
            }
        }
    }

    @Test
    public void insertTest() {
        List insertList = new ArrayList();
        for (int i = 0; i < 1; i++) {
            TwseStock twseStock = new TwseStock();
            twseStock.setStockNo(String.valueOf(i));
            twseStock.setStockDate("100/05/10");
            twseStock.setStockTradingVolume("0");
            twseStock.setStockTradingValue("0");
            twseStock.setStockOpeningPrice("0");
            twseStock.setStockHighestPrice("0");
            twseStock.setStockLowestPrice("0");
            twseStock.setStockClosingPrice("0");
            twseStock.setStockPriceDifference("0");
            twseStock.setStockTransactionVolume("0");
            insertList.add(twseStock);
        }
        iTWStockRawDataRepository.saveAll(insertList);
    }
}
