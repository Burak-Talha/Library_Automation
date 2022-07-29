package com.example.libraryautomation.core.utilities.results.DataResult;

import java.util.List;

public class SuccessDataResult<T> extends DataResult {

	public SuccessDataResult(List<T> dataList) {
		super(dataList,true);
	}

	public SuccessDataResult(List<T> dataList, String message) {
		super(dataList,true, message);
	}

	public SuccessDataResult(T dataList) {
		super(dataList,true);
	}

	public SuccessDataResult(T dataList, String message) {
		super(dataList,true, message);
	}

}
