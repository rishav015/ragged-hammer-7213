package com.onlinebanking.usecases;

import java.util.Scanner;

import com.dao.CustomerImpl;
import com.dao.CustomerDao;
import com.onlinebanking.bean.CustomerBean;
import com.onlinebanking.exception.CustomerException;

public class CustomerLoginUseCase {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Enter Account no.");
		
		int AccountNumber =sc.nextInt();
		
		sc.nextLine();
		
		System.out.println("Enter Account password");
		String Password =sc.next();
		
		CustomerDao dao = new CustomerImpl();
		
		try {
			CustomerBean customer = dao.loginCustomer(AccountNumber, Password);
			
			System.out.println("Welcome to online banking " + customer.getUsername());
		} catch (CustomerException e) {
			
		   System.out.println(e.getMessage());
		}
	}

}
