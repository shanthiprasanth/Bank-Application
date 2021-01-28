package com.css.corejava.exception;

public class InvalidAccountNoException extends Exception {

	private String errormsg = "Invalid account number...!";

	public InvalidAccountNoException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvalidAccountNoException(String errormsg) {
		super();
		this.errormsg = errormsg;
	}

	@Override
	public String getMessage() {
		return this.errormsg;
	}
}
