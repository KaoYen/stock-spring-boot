package com.stock.temporal.activity;

import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

@ActivityInterface
public interface FetchStockActivity {

    @ActivityMethod
    void fetchTwseStockData2DB(String date, String stockNo);
}
