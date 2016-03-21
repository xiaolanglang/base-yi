package com.yilv.base.common.web;

public class Result {
	private int code;
	private String message;
	public static final int FAILED = 500;
	public static final int SUCCESS = 200;

	public static final String FAILED_MSG = "failed";
	public static final String SUCCESS_MSG = "success";

	public Result() {

	}

	public Result(int code) {
		this.code = code;
	}

	public Result(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
