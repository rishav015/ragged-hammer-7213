package com.onlinebanking.usecases;

import java.util.Scanner;

import com.dao.CustomerImpl;
import com.dao.CustomerDao;
import com.onlinebanking.bean.CustomerBean;
import com.onlinebanking.exception.CustomerException;

public class GetCustomerUseCase {

	public static void main(String[] args) {
		

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Customer Accountnum");
		
		int Acc=sc.nextInt();
		
		CustomerDao dao = new CustomerImpl();
		
		CustomerBean customer;
		try {
			customer = dao.getAccountDetailsByAccount(Acc);
			System.out.println(customer);
		} catch (CustomerException ce) {
//			// TODO Auto-generated catch block
//			ce.printStackTrace();
			System.out.println(ce.getMessage());
		}
		
	
		
		

	}

}
