package com.stock.dto.twse;

import com.google.gson.annotations.SerializedName;

public class StockDayAllDto {
    @SerializedName("Code")
    private String code;

    @SerializedName("Name")
    private String name;

    @SerializedName("TradeVolume")
    private String tradeVolume;

    @SerializedName("TradeValue")
    private String tradeValue;

    @SerializedName("OpeningPrice")
    private String openingPrice;

    @SerializedName("HighestPrice")
    private String highestPrice;

    @SerializedName("LowestPrice")
    private String lowestPrice;

    @SerializedName("ClosingPrice")
    private String closingPrice;

    @SerializedName("Change")
    private String change;

    @SerializedName("Transaction")
    private String transaction;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTradeVolume() {
        return tradeVolume;
    }

    public void setTradeVolume(String tradeVolume) {
        this.tradeVolume = tradeVolume;
    }

    public String getTradeValue() {
        return tradeValue;
    }

    public void setTradeValue(String tradeValue) {
        this.tradeValue = tradeValue;
    }

    public String getOpeningPrice() {
        return openingPrice;
    }

    public void setOpeningPrice(String openingPrice) {
        this.openingPrice = openingPrice;
    }

    public String getHighestPrice() {
        return highestPrice;
    }

    public void setHighestPrice(String highestPrice) {
        this.highestPrice = highestPrice;
    }

    public String getLowestPrice() {
        return lowestPrice;
    }

    public void setLowestPrice(String lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    public String getClosingPrice() {
        return closingPrice;
    }

    public void setClosingPrice(String closingPrice) {
        this.closingPrice = closingPrice;
    }

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
    }

    public String getTransaction() {
        return transaction;
    }

    public void setTransaction(String transaction) {
        this.transaction = transaction;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", tradeVolume='" + tradeVolume + '\'' +
                ", tradeValue='" + tradeValue + '\'' +
                ", openingPrice='" + openingPrice + '\'' +
                ", highestPrice='" + highestPrice + '\'' +
                ", lowestPrice='" + lowestPrice + '\'' +
                ", closingPrice='" + closingPrice + '\'' +
                ", change='" + change + '\'' +
                ", transaction='" + transaction + '\'' +
                '}';
    }
}
