package com.stock.temporal.activity;

import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

@ActivityInterface
public interface UpdateStockCodeActivity {

    @ActivityMethod
    void updateStockCode();
}
