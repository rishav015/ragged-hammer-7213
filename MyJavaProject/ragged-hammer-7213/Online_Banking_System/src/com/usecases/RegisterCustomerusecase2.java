package com.onlinebanking.usecases;

import java.util.Scanner;

import com.dao.CustomerImpl;
import com.dao.CustomerDao;
import com.onlinebanking.bean.CustomerBean;

public class RegisterCustomerusecase2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Customer Username");
		
		String Username =sc.nextLine();
		

		System.out.println("Enter Customer Password");
		
		String Password =sc.nextLine();
		

		System.out.println("Enter Customer Mobile Number");
		
		String Mobile =sc.nextLine();
		
		CustomerDao dao = new CustomerImpl();
		
		CustomerBean customer = new CustomerBean();
		
		customer.setUsername(Username);
		customer.setPassword(Password);
		customer.setMobile(Mobile);
		customer.setBalance(0);
	
		String result =dao.registerCustomer2(customer);
		System.out.println(result);
	}

}
