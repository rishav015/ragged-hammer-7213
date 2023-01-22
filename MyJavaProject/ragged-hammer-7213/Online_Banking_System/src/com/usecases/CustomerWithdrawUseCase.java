package com.onlinebanking.usecases;

import java.util.Scanner;

import com.dao.CustomerDao;
import com.dao.CustomerImpl;
import com.onlinebanking.exception.CustomerException;

public class CustomerWithdrawUseCase {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Enter the Amount");
		int Amount = sc.nextInt();
		
		
		System.out.println("Enter the Account NUmber");
		int AccountNumber = sc.nextInt();
		
		CustomerDao dao = new CustomerImpl();
		
		try {
			String message =dao.withdrawammount(Amount, AccountNumber);
			
			System.out.println(message);
		} catch (CustomerException e) {
		System.out.println(e.getMessage());
		}
		
		
	}

}
