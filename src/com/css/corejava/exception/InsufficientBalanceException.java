package com.css.corejava.exception;

public class InsufficientBalanceException extends Exception {

	private String errormsg = "Insufficient fund in your account...!";

	public InsufficientBalanceException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InsufficientBalanceException(String errormsg) {
		super();
		this.errormsg = errormsg;
	}

	@Override
	public String getMessage() {
		return this.errormsg;
	}
}
