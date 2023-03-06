package com.dao;

import java.util.List;

import com.bean.CustomerBean;
import com.exception.AccountantException;
import com.exception.CustomerException;
import com.bean.Accountant;

public interface AccountantDao {
	
	public List<CustomerBean> getllCustomerDetails() throws AccountantException,CustomerException;
	
	public String registerCustomerByAccountant(CustomerBean customer);
	
	public String registerAccountant(Accountant accountant) throws AccountantException;
	
	public Accountant loginAccountant(String AccountantUsername ,String AccountantPassword ) throws AccountantException;
	
	public String deletaacustomer(int AccountNumber) throws CustomerException;
	
	public CustomerBean showCustomer(int AccountNumber) throws CustomerException;
	
	public void updateCustomerDetails(int AccountNumber)throws CustomerException;
	
	public void showAllTransactions() throws CustomerException ;
	
	
	
	
	
	
	
	

}
