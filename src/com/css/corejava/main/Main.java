package com.css.corejava.main;

import com.css.corejava.dto.Bank;
import com.css.corejava.dto.BankAccount;
import com.css.corejava.exception.InsufficientBalanceException;
import com.css.corejava.exception.InvalidAccountNoException;

public class Main {

	public static void main(String[] args) {
		BankAccount[] accounts = new BankAccount[3];
		accounts[0] = new BankAccount("praveen");
		accounts[1] = new BankAccount("Shanthi");
		accounts[2] = new BankAccount("Nemi");

		Bank axisBank = new Bank(accounts, "gunidy", "AXIS123");
		BankAccount foundAccount = null;
		double balance = 0.0;
		try {
			// foundAccount=axisBank.CheckAccount("1002");
			balance = axisBank.getBalance("1002");
			axisBank.depositMoney("1000", 2000.00);
			axisBank.withdrawMoney("1000", 99);
			axisBank.transferMoney("1000", "1002", 2000.00);
		} catch (InvalidAccountNoException | InsufficientBalanceException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		System.out.println(balance);
		try {
			System.out.println(axisBank.getBalance("1000"));
//			System.out.println(axisBank.getBalance("1001"));
//			System.out.println(axisBank.getBalance("1000"));
//			System.out.println(axisBank.getBalance("1002"));
		} catch (InvalidAccountNoException e) {
			e.printStackTrace();
		}
	}

}
