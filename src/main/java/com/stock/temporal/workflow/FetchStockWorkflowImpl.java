package com.stock.temporal.workflow;

import com.stock.temporal.activity.FetchStockActivity;
import com.stock.temporal.utils.WorkerHelper;
import io.temporal.workflow.Workflow;

public class FetchStockWorkflowImpl implements FetchStockWorkflow {


    @Override
    public void fetchStockData2DB(String date, String stockNo) {
        FetchStockActivity fetchStockActivity = Workflow.newActivityStub(FetchStockActivity.class,
                WorkerHelper.defaultActivityOptions());

        fetchStockActivity.fetchTwseStockData2DB(date, stockNo);

    }
}
