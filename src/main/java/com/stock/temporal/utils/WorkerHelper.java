package com.stock.temporal.utils;

import io.temporal.activity.ActivityOptions;
import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import io.temporal.common.RetryOptions;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.serviceclient.WorkflowServiceStubsOptions;
import io.temporal.worker.WorkerOptions;

import java.time.Duration;

public class WorkerHelper {
    public static final String FETCH_STOCK_TASK_QUEUE = "FetchStockTaskQueue";

    public static final String UPDATE_STOCK_CODE_QUEUE = "UpdateStockCodeQueue";

    public static RetryOptions retryoptions = RetryOptions.newBuilder()
            .setInitialInterval(Duration.ofSeconds(1))
            .setMaximumInterval(Duration.ofSeconds(60))
            .setBackoffCoefficient(2)
            .setMaximumAttempts(100)
            .build();

    public static WorkflowClient getWorkflowClient() {
        WorkflowServiceStubs service = WorkflowServiceStubs.newServiceStubs(WorkflowServiceStubsOptions.newBuilder()
                .setEnableHttps(false)
                .setTarget("127.0.0.1:7233")
                .build());
        return WorkflowClient.newInstance(service);
    }

    public static WorkflowOptions defaultWorkflowOptions(String taskQueue) {
        var builder = WorkflowOptions.newBuilder();

        builder.setTaskQueue(taskQueue);
        builder.setWorkflowRunTimeout(java.time.Duration.ofMinutes(5));
        builder.setWorkflowTaskTimeout(java.time.Duration.ofMinutes(1));
        builder.setRetryOptions(retryoptions);

        return builder.build();
    }

    public static ActivityOptions defaultActivityOptions() {
        return
                ActivityOptions.newBuilder()
                        // Timeout options specify when to automatically timeout Activities if the process is taking too long.
                        .setStartToCloseTimeout(Duration.ofSeconds(60))
                        .setRetryOptions(retryoptions)
                        .build();
    }
}
