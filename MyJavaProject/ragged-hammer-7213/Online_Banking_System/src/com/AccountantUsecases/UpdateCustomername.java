package com.onlinebanking.AccountantUsecases;

import java.util.Scanner;

import com.dao.AccountantDao;
import com.dao.AccountantImpl;
import com.onlinebanking.bean.Accountant;
import com.onlinebanking.bean.CustomerBean;
import com.onlinebanking.exception.CustomerException;

public class UpdateCustomername {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the account number where you have to update the name " );
		
		int Accountnumber =sc.nextInt();
		
		
		AccountantDao dao =new AccountantImpl();
		
		try {
			dao.updateCustomerDetails(Accountnumber);
			
			
		} catch (CustomerException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		
}
	}


