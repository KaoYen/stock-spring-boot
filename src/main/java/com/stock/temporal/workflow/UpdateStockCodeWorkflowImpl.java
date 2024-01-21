package com.stock.temporal.workflow;

import com.stock.temporal.activity.UpdateStockCodeActivity;
import com.stock.temporal.utils.WorkerHelper;
import io.temporal.workflow.Workflow;

public class UpdateStockCodeWorkflowImpl implements UpdateStockCodeWorkflow {

    @Override
    public void updateStockCode() {
        UpdateStockCodeActivity updateStockCodeActivity = Workflow.newActivityStub(UpdateStockCodeActivity.class,
                WorkerHelper.defaultActivityOptions());

        updateStockCodeActivity.updateStockCode();

    }
}
