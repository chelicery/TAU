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

	public void withdraw(int value) {
		if (value > this.balance) {
			
		} else if(value%10 != 0) {
			throw new ArithmeticException();
		}
		
		else {
			this.balance = balance - value;
		}
		

	}

	public String deposit(int value) {
		return "Your balance is: " + this.balance;
	}

}
