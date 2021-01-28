package com.css.corejava.dto;

public class BankAccount {
	private static int lastAssignedNo;
	static {
		lastAssignedNo = 1000;
	}
	private String accountNo;
	private String accountName;
	private double balance;

	// constructor
	public BankAccount(String accountNo, String accountName, double balance) {
		super();
		this.accountNo = "" + lastAssignedNo++;
		this.accountName = accountName;
		this.balance = 1000.00;
	}

	public BankAccount(String accountName) {
		super();
		this.accountNo = "" + lastAssignedNo++;;
		this.accountName = accountName;
		this.balance = 1000.00;
	}

	public BankAccount() {
		super();
	}

	// getters and setters
	public static int getLastAssignedNo() {
		return lastAssignedNo;
	}

	public static void setLastAssignedNo(int lastAssignedNo) {
		BankAccount.lastAssignedNo = lastAssignedNo;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "BankAccount [accountNo=" + accountNo + ", accountName=" + accountName + ", balance=" + balance + "]";
	}

}
