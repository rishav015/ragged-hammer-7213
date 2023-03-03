package com.onlinebanking.AccountantUsecases;

import java.util.Scanner;

import com.dao.AccountantDao;
import com.dao.AccountantImpl;
import com.onlinebanking.bean.CustomerBean;
import com.onlinebanking.exception.CustomerException;

public class ShowCustomer {

	public static void main(String[] args) {
		System.out.println("Enter Account number to show Customer");
		
		Scanner sc = new Scanner (System.in);
		
		int AccountNumber = sc.nextInt();
		
		AccountantDao dao = new AccountantImpl();
		
		try {
			CustomerBean result = dao.showCustomer(AccountNumber);
			
			System.out.println("Account details extracted successfully " + result.getUsername());
			
			System.out.println(result);
		} catch (CustomerException e) {
			// TODO Auto-generated catch block
		System.out.println(e.getMessage());
		}
		
		

	}

}
