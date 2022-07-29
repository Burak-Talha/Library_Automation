package com.example.libraryautomation.core.utilities.results.DataResults;

import com.example.libraryautomation.core.utilities.results.Result;

import java.util.List;

public class DataResults<T> extends Result {

    private List<T> dataList;

    public DataResults(boolean success) {
        super(success);
    }

    public DataResults(boolean success, String message) {
        super(success, message);
    }

    public DataResults(List<T> dataList, boolean success) {
        super(success);
        this.dataList = dataList;
    }

    public DataResults(List<T> dataList, boolean success, String message) {
        super(success, message);
        this.dataList = dataList;
    }

    public List<T> getDataList() {
        return dataList;
    }

}
