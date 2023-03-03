package com.onlinebanking.AccountantUsecases;

import java.util.Scanner;

import com.dao.AccountantDao;
import com.dao.AccountantImpl;
import com.onlinebanking.bean.Accountant;
import com.onlinebanking.exception.AccountantException;

public class AccountantLoginUseCase {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Accountant username");
		String Username =sc.nextLine();

		System.out.println("Enter Accountant Password");
		String Password = sc.nextLine();
		
		AccountantDao dao = new AccountantImpl();
		
		
		try {
			Accountant accountant =dao.loginAccountant(Username, Password);
			
			System.out.println("Login sucessful as Accountant "+accountant.getAccountantName() );
//			System.out.println(accountant);
//			
		} catch (AccountantException e) {
			
			System.out.println(e.getMessage());
		}
	}

}
