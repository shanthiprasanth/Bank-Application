package com.css.corejava.dto;

import java.util.Arrays;

import com.css.corejava.dao.IBankServiceProvider;
import com.css.corejava.exception.InsufficientBalanceException;
import com.css.corejava.exception.InvalidAccountNoException;

public class Bank implements IBankServiceProvider {
	private BankAccount[] bankAccount;
	private String IFSCCode;
	private String bankName;

	// constructor
	public Bank(BankAccount[] bankAccount, String iFSCCode, String bankName) {
		super();
		this.bankAccount = bankAccount;
		IFSCCode = iFSCCode;
		this.bankName = bankName;
	}

	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public BankAccount CheckAccount(String accountNo) throws InvalidAccountNoException {
		BankAccount foundAccount = null;
		for (BankAccount account : bankAccount) {
			if (account.getAccountNo().equals(accountNo)) {
				foundAccount = account;
				break;
			}
		}
		if (foundAccount == null) {
			throw new InvalidAccountNoException();
		}
		return foundAccount;
	}

	@Override
	public double getBalance(String accountNo) throws InvalidAccountNoException {
		double balance = 0.0;
		BankAccount foundAccount = CheckAccount(accountNo);
		balance = foundAccount.getBalance();
		return balance;
	}

	@Override
	public boolean depositMoney(String accountNo, double amount) throws InvalidAccountNoException {
		boolean flagDeposit = false;
		BankAccount foundAccount = CheckAccount(accountNo);
		if (foundAccount != null) {
			foundAccount.setBalance(foundAccount.getBalance() + amount);
			flagDeposit = true;
		}
		return true;
	}

	@Override
	public boolean withdrawMoney(String accountNo, double amount)
			throws InvalidAccountNoException, InsufficientBalanceException {
		boolean flagWithdraw = false;
		BankAccount foundAccount = CheckAccount(accountNo);
		if (foundAccount != null) {
			if (foundAccount.getBalance() > amount) {
				foundAccount.setBalance(foundAccount.getBalance() - amount);
				flagWithdraw = true;
			} else {
				throw new InvalidAccountNoException();
			}
		}
		return flagWithdraw;
	}

	@Override
	public boolean transferMoney(String fromAccountNo, String toAccountNo, double amount)
			throws InvalidAccountNoException, InsufficientBalanceException {
		boolean transferflag = false;
		boolean flagWithdraw = withdrawMoney(fromAccountNo, amount);
		boolean flagDeposit = depositMoney(toAccountNo, amount);
		if (flagWithdraw) {
			flagDeposit = depositMoney(toAccountNo, amount);
		}
		if (flagDeposit)
			transferflag = true;
		else
			depositMoney(fromAccountNo, amount);
		return transferflag;
	}

	// getters and setters
	public BankAccount[] getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(BankAccount[] bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getIFSCCode() {
		return IFSCCode;
	}

	public void setIFSCCode(String iFSCCode) {
		IFSCCode = iFSCCode;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	@Override
	public String toString() {
		return "Bank [bankAccount=" + Arrays.toString(bankAccount) + ", IFSCCode=" + IFSCCode + ", bankName=" + bankName
				+ "]";
	}

	@Override
	public BankAccount checkAccount(String accountNo) throws InvalidAccountNoException {
		// TODO Auto-generated method stub
		return null;
	}

}
