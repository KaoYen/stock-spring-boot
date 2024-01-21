package com.stock.temporal;

import com.stock.temporal.activity.FetchStockActivityImpl;
import com.stock.temporal.activity.UpdateStockCodeActivityImpl;
import com.stock.temporal.utils.WorkerHelper;
import com.stock.temporal.workflow.FetchStockWorkflowImpl;
import com.stock.temporal.workflow.UpdateStockCodeWorkflowImpl;
import io.temporal.client.WorkflowClient;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.serviceclient.WorkflowServiceStubsOptions;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;
import io.temporal.worker.WorkerOptions;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TemporalConfig {

    private WorkflowClient client;

    private WorkerFactory factory;

    @Autowired
    private FetchStockActivityImpl fetchStockActivityImpl;

    @Autowired
    private UpdateStockCodeActivityImpl updateStockCodeActivityImpl;

    @PostConstruct
    public void startWorkers() {
        var stub = WorkflowServiceStubs.newServiceStubs(WorkflowServiceStubsOptions.newBuilder()
                .setEnableHttps(false)
                .setTarget("127.0.0.1:7233")
                .build());
        var client = WorkflowClient.newInstance(stub);

        var factory = WorkerFactory.newInstance(client);

        Worker worker = factory.newWorker(WorkerHelper.FETCH_STOCK_TASK_QUEUE);
        worker.registerWorkflowImplementationTypes(FetchStockWorkflowImpl.class);
        worker.registerActivitiesImplementations(fetchStockActivityImpl);


        // set concurrent to 5, default is 200
        // WorkerOptions workerOptions = WorkerOptions.newBuilder().setMaxConcurrentWorkflowTaskExecutionSize(5).build();
        Worker updateStockNoWorker = factory.newWorker(WorkerHelper.UPDATE_STOCK_CODE_QUEUE);
        updateStockNoWorker.registerWorkflowImplementationTypes(UpdateStockCodeWorkflowImpl.class);
        updateStockNoWorker.registerActivitiesImplementations(updateStockCodeActivityImpl);

        factory.start();
    }
}
