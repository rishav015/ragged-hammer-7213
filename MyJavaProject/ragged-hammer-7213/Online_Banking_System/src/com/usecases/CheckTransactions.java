package com.onlinebanking.usecases;

import java.util.Scanner;

import com.dao.CustomerDao;
import com.dao.CustomerImpl;

public class CheckTransactions {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Enter your Account Number");
		
		int AccountNumber =sc.nextInt();
		
		CustomerDao dao =new CustomerImpl();
		
		dao.checkTransactionHistory(AccountNumber);
		
		
		
		
	}

}
