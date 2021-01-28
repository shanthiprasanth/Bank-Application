package com.css.corejava.dao;

import com.css.corejava.dto.BankAccount;
import com.css.corejava.exception.InsufficientBalanceException;
import com.css.corejava.exception.InvalidAccountNoException;

public interface IBankServiceProvider {
	BankAccount checkAccount(String accountNo) throws InvalidAccountNoException;

	double getBalance(String accountNo) throws InvalidAccountNoException;

	boolean depositMoney(String accountNo, double amount) throws InvalidAccountNoException;

	boolean withdrawMoney(String accountNo, double amount)
			throws InvalidAccountNoException, InsufficientBalanceException;

	boolean transferMoney(String fromAccountNo, String toAccountNo, double amount)
			throws InvalidAccountNoException, InsufficientBalanceException;

	BankAccount CheckAccount(String accountNo) throws InvalidAccountNoException;
}
