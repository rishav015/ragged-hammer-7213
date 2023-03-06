package com.dao;

import com.bean.CustomerBean;
import com.exception.CustomerException;

public interface CustomerDao {
	
	public String registerCustomer(String Username, String Password,String Mobile,int Balance);
	
	public String registerCustomer2(CustomerBean customer);
	
	public CustomerBean getAccountDetailsByAccount(int AccountNumber) throws CustomerException;
	
	public CustomerBean loginCustomer(int AccountNumber, String Password) throws CustomerException;
	
	public String depositAmount(int Amount ,int AccountNumber) throws CustomerException;
	
	public String withdrawammount(int Amount ,int AccountNumber)throws CustomerException;
	
	public String transferMoney(int Amount ,int SAccountNumber ,int RAccountNumber)throws CustomerException;
	
	public void checkTransactionHistory(int accno);
	
	

}
