package com.stock.temporal.workflow;

import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface FetchStockWorkflow {

    @WorkflowMethod
    void fetchStockData2DB(String date, String stockNo);
}
