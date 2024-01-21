package com.stock.dto.tpex;

import com.google.gson.annotations.SerializedName;

public class MainboardQuotesDto {
    @SerializedName("Date")
    private String date;

    @SerializedName("SecuritiesCompanyCode")
    private String securitiesCompanyCode;

    @SerializedName("CompanyName")
    private String companyName;

    @SerializedName("Close")
    private String close;

    @SerializedName("Change")
    private String change;

    @SerializedName("Open")
    private String open;

    @SerializedName("High")
    private String high;

    @SerializedName("Low")
    private String low;

    @SerializedName("TradingShares")
    private String tradingShares;

    @SerializedName("TransactionAmount")
    private String transactionAmount;

    @SerializedName("TransactionNumber")
    private String transactionNumber;

    @SerializedName("LatestBidPrice")
    private String latestBidPrice;

    @SerializedName("LatesAskPrice")
    private String latestAskPrice;

    @SerializedName("Capitals")
    private String capitals;

    @SerializedName("NextLimitUp")
    private String nextLimitUp;

    @SerializedName("NextLimitDown")
    private String nextLimitDown;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSecuritiesCompanyCode() {
        return securitiesCompanyCode;
    }

    public void setSecuritiesCompanyCode(String securitiesCompanyCode) {
        this.securitiesCompanyCode = securitiesCompanyCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getTradingShares() {
        return tradingShares;
    }

    public void setTradingShares(String tradingShares) {
        this.tradingShares = tradingShares;
    }

    public String getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(String transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(String transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public String getLatestBidPrice() {
        return latestBidPrice;
    }

    public void setLatestBidPrice(String latestBidPrice) {
        this.latestBidPrice = latestBidPrice;
    }

    public String getLatestAskPrice() {
        return latestAskPrice;
    }

    public void setLatestAskPrice(String latestAskPrice) {
        this.latestAskPrice = latestAskPrice;
    }

    public String getCapitals() {
        return capitals;
    }

    public void setCapitals(String capitals) {
        this.capitals = capitals;
    }

    public String getNextLimitUp() {
        return nextLimitUp;
    }

    public void setNextLimitUp(String nextLimitUp) {
        this.nextLimitUp = nextLimitUp;
    }

    public String getNextLimitDown() {
        return nextLimitDown;
    }

    public void setNextLimitDown(String nextLimitDown) {
        this.nextLimitDown = nextLimitDown;
    }

    @Override
    public String toString() {
        return "StockDataDTO{" +
                "date='" + date + '\'' +
                ", securitiesCompanyCode='" + securitiesCompanyCode + '\'' +
                ", companyName='" + companyName + '\'' +
                ", close='" + close + '\'' +
                ", change='" + change + '\'' +
                ", open='" + open + '\'' +
                ", high='" + high + '\'' +
                ", low='" + low + '\'' +
                ", tradingShares='" + tradingShares + '\'' +
                ", transactionAmount='" + transactionAmount + '\'' +
                ", transactionNumber='" + transactionNumber + '\'' +
                ", latestBidPrice='" + latestBidPrice + '\'' +
                ", latestAskPrice='" + latestAskPrice + '\'' +
                ", capitals='" + capitals + '\'' +
                ", nextLimitUp='" + nextLimitUp + '\'' +
                ", nextLimitDown='" + nextLimitDown + '\'' +
                '}';
    }
}
