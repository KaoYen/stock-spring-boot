package com.stock.dto.twse;

import java.util.List;

public class StockDayDto {
    private String stat;
    private String date;
    private String title;
    private List<String> fields;
    private List<List<String>> data;
    private List<String> notes;


    public StockDayDto(String stat, String date, String title, List<String> fields, List<List<String>> data, List<String> notes) {
        this.stat = stat;
        this.date = date;
        this.title = title;
        this.fields = fields;
        this.data = data;
        this.notes = notes;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getFields() {
        return fields;
    }

    public void setFields(List<String> fields) {
        this.fields = fields;
    }

    public List<List<String>> getData() {
        return data;
    }

    public void setData(List<List<String>> data) {
        this.data = data;
    }

    public List<String> getNotes() {
        return notes;
    }

    public void setNotes(List<String> notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "StockDayDto{" +
                "stat='" + stat + '\'' +
                ", date='" + date + '\'' +
                ", title='" + title + '\'' +
                ", fields=" + fields +
                ", data=" + data +
                ", notes=" + notes +
                '}';
    }
}
