package com.stock.controller;

import com.stock.temporal.activity.UpdateStockCodeActivityImpl;
import com.stock.temporal.utils.WorkerHelper;
import com.stock.temporal.workflow.FetchStockWorkflow;
import com.stock.temporal.workflow.UpdateStockCodeWorkflow;
import io.temporal.client.WorkflowClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StockController {

    @Autowired
    private UpdateStockCodeActivityImpl updateStockCodeActivityImpl;

    @GetMapping("/fetchStock")
    public void fetchStock(@RequestParam(value = "date") String date, @RequestParam(value = "stockNo") String stockNo) {
        var workflowClient = WorkerHelper.getWorkflowClient();
        FetchStockWorkflow workflow = workflowClient.newWorkflowStub(FetchStockWorkflow.class,
                WorkerHelper.defaultWorkflowOptions(WorkerHelper.FETCH_STOCK_TASK_QUEUE));

        // Asynchronously start the workflow execution
        WorkflowClient.start(workflow::fetchStockData2DB, date, stockNo);
    }

    @GetMapping("/updateStockCode")
    public void updateStockCode() {

        var workflowClient = WorkerHelper.getWorkflowClient();
        UpdateStockCodeWorkflow workflow = workflowClient.newWorkflowStub(UpdateStockCodeWorkflow.class,
                WorkerHelper.defaultWorkflowOptions(WorkerHelper.UPDATE_STOCK_CODE_QUEUE));

        // Asynchronously start the workflow execution
        WorkflowClient.start(workflow::updateStockCode);


    }
}