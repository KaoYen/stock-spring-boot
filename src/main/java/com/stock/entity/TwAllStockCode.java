package com.stock.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tw_all_stock_code")
public class TwAllStockCode {

    @Id
    @Column(name = "stock_code", length = 10)
    private String stockCode;

    @Column(name = "stock_name", length = 20)
    private String stockName;

    @Column(name = "stock_type", length = 4)
    private String stockType;

    public TwAllStockCode() {

    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getStockType() {
        return stockType;
    }

    public void setStockType(String stockType) {
        this.stockType = stockType;
    }
}
