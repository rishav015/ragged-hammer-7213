package com.onlinebanking.usecases;

import java.util.Scanner;

import com.dao.AccountantDao;
import com.dao.AccountantImpl;
import com.dao.CustomerDao;
import com.dao.CustomerImpl;
import com.onlinebanking.bean.CustomerBean;
import com.onlinebanking.exception.CustomerException;

public class CustomerDepositUseCase {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Amount to deposit");
		
		int Amount =sc.nextInt();
		
		System.out.println("Enter your Account Number");
		
		int accountNumber =sc.nextInt();
		
		CustomerDao cdao = new CustomerImpl();
		
		AccountantDao adao =new AccountantImpl();
		
		
		
		try {
			
			
			String message =cdao.depositAmount(Amount, accountNumber);
			
			CustomerBean customer =adao.showCustomer(accountNumber);
			
			System.out.println(message+customer.getBalance() );
			
			
			
			
			
//			System.out.println(message);
		} catch (CustomerException e) {
			
			System.out.println(e.getMessage());
		}
		
	
		
		
		
		

	}

}
