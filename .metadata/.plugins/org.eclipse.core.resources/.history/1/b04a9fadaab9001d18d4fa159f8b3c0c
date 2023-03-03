package com.onlinebanking.AccountantUsecases;

import java.util.Scanner;

import com.dao.AccountantDao;
import com.dao.AccountantImpl;
import com.onlinebanking.bean.CustomerBean;

public class CustomerRegistationByAccountantUseCase {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Enter Username");
		
		String Username = sc.nextLine();
		
		System.out.println("Enter Password");
		
		

		String Password = sc.nextLine();
		
		System.out.println("Enter Mobile");
		

		String Mobile=sc.nextLine();
		
		System.out.println("Enter Balance");
		
		int balance =sc.nextInt();
		
		AccountantDao dao = new AccountantImpl();
		
		CustomerBean customer = new CustomerBean();
		
		customer.setUsername(Username);
		customer.setPassword(Password);
		customer.setMobile(Mobile);
		customer.setBalance(balance);
		
		String result =dao.registerCustomerByAccountant(customer);
		
		System.out.println(result);
		
		
		
		
	}

}
