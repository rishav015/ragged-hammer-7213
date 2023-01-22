package com.onlinebanking.bean;

public class Accountant {
	
	private String AccountantName;
	
	private String AccountantUsername;
	
	private String Password;
	
	private int Accountant_id;

	
	public Accountant() {
		
	}
	public Accountant(String accountantName, String accountantUsername, String password) {
		super();
		AccountantName = accountantName;
		AccountantUsername = accountantUsername;
		Password = password;
	}
	
	public Accountant(String accountantName, String accountantUsername, String password,int accountant_id) {
		super();
		AccountantName = accountantName;
		AccountantUsername = accountantUsername;
		Password = password;
		Accountant_id=accountant_id;
	}

	public String getAccountantName() {
		return AccountantName;
	}

	public void setAccountantName(String accountantName) {
		AccountantName = accountantName;
	}

	public String getAccountantUsername() {
		return AccountantUsername;
	}

	public void setAccountantUsername(String accountantUsername) {
		AccountantUsername = accountantUsername;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	@Override
	public String toString() {
		return "Accountant [AccountantName=" + AccountantName + ", AccountantUsername=" + AccountantUsername
				+ ", Password=" + Password + "]";
	}
	
	
	
	
	
	
	
	
	

}
