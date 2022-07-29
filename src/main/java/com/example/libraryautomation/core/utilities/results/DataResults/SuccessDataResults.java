package com.example.libraryautomation.core.utilities.results.DataResults;

import java.util.List;

public class SuccessDataResults<T> extends DataResults<T>{

    public SuccessDataResults(List<T> dataList) {
        super(dataList, true);
    }

    public SuccessDataResults(List<T> dataList, String message) {
        super(dataList, true, message);
    }

}
