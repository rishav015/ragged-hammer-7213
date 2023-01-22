package com.onlinebanking.AccountantUsecases;

import java.util.Scanner;

import com.dao.AccountantDao;
import com.dao.AccountantImpl;
import com.onlinebanking.bean.Accountant;
import com.onlinebanking.exception.CustomerException;

public class DeleteCustomerUseCase {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the account no to delete");
		
		int AccountNumber = sc.nextInt();
		
		AccountantDao dao = new AccountantImpl();
		
		try {
			dao.deletaacustomer(AccountNumber);
			
			System.out.println("Account deleteed sucessfully");
		} catch (CustomerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
