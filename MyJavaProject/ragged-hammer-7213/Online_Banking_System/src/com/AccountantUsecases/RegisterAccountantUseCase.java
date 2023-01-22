package com.onlinebanking.AccountantUsecases;

import java.util.Scanner;

import com.dao.AccountantDao;
import com.dao.AccountantImpl;
import com.onlinebanking.bean.Accountant;
import com.onlinebanking.exception.AccountantException;

public class RegisterAccountantUseCase {

	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		
		System.out.println("enter your Name");
		
		String Accountantname =sc.nextLine();
		
		System.out.println("enter your Username");
		
		String AccountantUsername =sc.nextLine();
		
		System.out.println("enter your Password");
		
		String Password = sc.nextLine();
		
		AccountantDao dao =new AccountantImpl();
		
		Accountant accountant =new Accountant();
		
		accountant.setAccountantName(Accountantname);
		
		accountant.setAccountantUsername(AccountantUsername);
		
		accountant.setPassword(Password);
		
		String result;
		try {
			result = dao.registerAccountant(accountant);
			
			System.out.println(result);
		} catch (AccountantException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
