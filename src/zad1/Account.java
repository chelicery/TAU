package zad1;

import java.math.BigDecimal;


public class Account {

	private int accountId;
	private User user;
	private String currency;
	private int balance;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int withdraw(int value) {
		if (value > this.balance) {
			throw new ArithmeticException();
		} else {
			this.balance = balance - value;
		}
		return this.balance;

	}

	public String deposit(int value) {
		return "Your balance is: " + this.balance;
	}

}
