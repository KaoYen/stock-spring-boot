package com.stock.temporal.workflow;

import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface UpdateStockCodeWorkflow {

    @WorkflowMethod
    void updateStockCode();
}
