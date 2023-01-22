package com.onlinebanking.bean;

public class TransactionHistory {
	
	
	int AccountNumber;
	
	int Recievers_AccountNumber ;
	
	int Amount_transfered ;
	
	int Credited;
	
	int Withdrawn;
	
	int  Amount_recieved ;

	public TransactionHistory(int accountNumber, int recievers_AccountNumber, int amount_transfered, int credited,
			int withdrawn, int amount_recieved) {
		super();
		AccountNumber = accountNumber;
		Recievers_AccountNumber = recievers_AccountNumber;
		Amount_transfered = amount_transfered;
		Credited = credited;
		Withdrawn = withdrawn;
		Amount_recieved = amount_recieved;
	}

	public int getAccountNumber() {
		return AccountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		AccountNumber = accountNumber;
	}

	public int getRecievers_AccountNumber() {
		return Recievers_AccountNumber;
	}

	public void setRecievers_AccountNumber(int recievers_AccountNumber) {
		Recievers_AccountNumber = recievers_AccountNumber;
	}

	public int getAmount_transfered() {
		return Amount_transfered;
	}

	public void setAmount_transfered(int amount_transfered) {
		Amount_transfered = amount_transfered;
	}

	public int getCredited() {
		return Credited;
	}

	public void setCredited(int credited) {
		Credited = credited;
	}

	public int getWithdrawn() {
		return Withdrawn;
	}

	public void setWithdrawn(int withdrawn) {
		Withdrawn = withdrawn;
	}

	public int getAmount_recieved() {
		return Amount_recieved;
	}

	public void setAmount_recieved(int amount_recieved) {
		Amount_recieved = amount_recieved;
	}

	@Override
	public String toString() {
		return "TransactionHistory [AccountNumber=" + AccountNumber + ", Recievers_AccountNumber="
				+ Recievers_AccountNumber + ", Amount_transfered=" + Amount_transfered + ", Credited=" + Credited
				+ ", Withdrawn=" + Withdrawn + ", Amount_recieved=" + Amount_recieved + "]";
	}
	
	
	
	

}
