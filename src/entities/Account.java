package entities;

import exception.BusinessException;

public class Account {

	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	public Account() {
		
	}
	
	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {		
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public String getHolder() {
		return holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}
	
	public void withdraw(double amount) {
		if(amount > this.withdrawLimit) {
			throw new BusinessException("The amount exceeds withdraw limit");
		}
		if(amount < this.withdrawLimit) {
			if(amount > this.balance) {
				throw new BusinessException("Not enough balance");
			}
		}
		this.balance -= amount;
	}

	@Override
	public String toString() {
		return "New balance: " +  String.format("%.2f", balance);
	}
	
	
	
	
}
