package com.example.libraryautomation.core.utilities.results.DataResult;


import com.example.libraryautomation.core.utilities.results.Result;

import java.util.List;

public class DataResult<T> extends Result {

	private T data;


	public DataResult(T data, boolean success, String message) {
		super(success, message);
		this.data = data;
	}
	
	public DataResult(T data, boolean success) {
		super(success);
		this.data = data;
	}

	public DataResult(boolean success, String message) {
		super(success, message);
	}

	public T getData(){
		return this.data;
	}
}
