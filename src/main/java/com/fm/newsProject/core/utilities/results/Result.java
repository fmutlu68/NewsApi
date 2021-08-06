package com.fm.newsProject.core.utilities.results;

public class Result {
	private String message;

	private boolean success;

	public Result(String message, boolean success) {
		super();
		this.message = message;
		this.success = success;
	}

	public Result(boolean success) {
		super();
		this.success = success;
	}
	
	public String getMessage() {
		return message;
	}

	public boolean isSuccess() {
		return success;
	}
}
