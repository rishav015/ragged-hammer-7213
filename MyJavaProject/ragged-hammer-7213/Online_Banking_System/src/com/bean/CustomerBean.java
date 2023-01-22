package com.onlinebanking.bean;

public class CustomerBean {
	
	private int accountNumber;
	
	private String Username;
	
	private String Password;
	
	private String Mobile;
	
	private int balance = 0;

	
	public CustomerBean() {
	}
	
	public CustomerBean(int accountNumber, String username, String password, String mobile,int balance) {
		super();
		this.accountNumber = accountNumber;
		this.Username = username;
		this.Password = password;
		this.Mobile = mobile;
		this.balance=balance;
		
	}

	public CustomerBean(String username, String password, String mobile,int balance) {
		super();
		Username = username;
		Password = password;
		Mobile = mobile;
		balance=balance;
	}


	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getMobile() {
		return Mobile;
	}

	public void setMobile(String mobile) {
		Mobile = mobile;
	}

	@Override
	public String toString() {
		return "CustomerDetails [accountNumber=" + accountNumber + ", Username=" + Username + ", Password=" + Password
				+ ", Mobile=" + Mobile + ", balance=" + balance + "]";
	}
	
	

}
