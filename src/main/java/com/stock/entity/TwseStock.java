package com.stock.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@IdClass(TwStockRawDataPK.class)
@Table(name = "tw_stock")
public class TwseStock implements Serializable {

    @Id
    @Column(name = "stock_no", length = 10)
    private String stockNo;

    @Id
    @Column(name = "stock_date", length = 10)
    private String stockDate;

    @Column(name = "stock_trading_volume", length = 15)
    private String stockTradingVolume;

    @Column(name = "stock_trading_value", length = 15)
    private String stockTradingValue;

    @Column(name = "stock_opening_price", length = 10)
    private String stockOpeningPrice;

    @Column(name = "stock_highest_price", length = 10)
    private String stockHighestPrice;

    @Column(name = "stock_lowest_price", length = 10)
    private String stockLowestPrice;

    @Column(name = "stock_closing_price", length = 10)
    private String stockClosingPrice;

    @Column(name = "stock_price_difference", length = 10)
    private String stockPriceDifference;

    @Column(name = "stock_transaction_volume", length = 10)
    private String stockTransactionVolume;


    public String getStockNo() {
        return stockNo;
    }

    public void setStockNo(String stockNo) {
        this.stockNo = stockNo;
    }

    public String getStockDate() {
        return stockDate;
    }

    public void setStockDate(String stockDate) {
        this.stockDate = stockDate;
    }

    public String getStockTradingVolume() {
        return stockTradingVolume;
    }

    public void setStockTradingVolume(String stockTradingVolume) {
        this.stockTradingVolume = stockTradingVolume;
    }

    public String getStockTradingValue() {
        return stockTradingValue;
    }

    public void setStockTradingValue(String stockTradingValue) {
        this.stockTradingValue = stockTradingValue;
    }

    public String getStockOpeningPrice() {
        return stockOpeningPrice;
    }

    public void setStockOpeningPrice(String stockOpeningPrice) {
        this.stockOpeningPrice = stockOpeningPrice;
    }

    public String getStockHighestPrice() {
        return stockHighestPrice;
    }

    public void setStockHighestPrice(String stockHighestPrice) {
        this.stockHighestPrice = stockHighestPrice;
    }

    public String getStockLowestPrice() {
        return stockLowestPrice;
    }

    public void setStockLowestPrice(String stockLowestPrice) {
        this.stockLowestPrice = stockLowestPrice;
    }

    public String getStockClosingPrice() {
        return stockClosingPrice;
    }

    public void setStockClosingPrice(String stockClosingPrice) {
        this.stockClosingPrice = stockClosingPrice;
    }

    public String getStockPriceDifference() {
        return stockPriceDifference;
    }

    public void setStockPriceDifference(String stockPriceDifference) {
        this.stockPriceDifference = stockPriceDifference;
    }

    public String getStockTransactionVolume() {
        return stockTransactionVolume;
    }

    public void setStockTransactionVolume(String stockTransactionVolume) {
        this.stockTransactionVolume = stockTransactionVolume;
    }
}

