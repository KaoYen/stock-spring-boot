package com.stock.entity;


import java.io.Serializable;

public class TwStockRawDataPK implements Serializable {

    private String stockNo;

    private String stockDate;

    public TwStockRawDataPK() {
    }

    public TwStockRawDataPK(String stockNo, String stockDate) {
        this.stockNo = stockNo;
        this.stockDate = stockDate;
    }
}
