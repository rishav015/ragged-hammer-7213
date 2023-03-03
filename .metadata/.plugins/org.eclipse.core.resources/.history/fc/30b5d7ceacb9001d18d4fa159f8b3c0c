package com.onlinebanking.usecases;

import java.util.Scanner;

import com.dao.CustomerDao;
import com.dao.CustomerImpl;
import com.onlinebanking.exception.CustomerException;

public class AmountTransferUseCase {

	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		
		System.out.println("Enter Amount");
		
		int amount =sc.nextInt();
		
		System.out.println("Enter Your Account Number");
		
		int sendersaccount =sc.nextInt();
		
		System.out.println("Enter Recievers Account number ");
		
		int recieversaccount = sc.nextInt();
		
		CustomerDao dao =new CustomerImpl();
		
		try {
			String message =dao.transferMoney(amount, sendersaccount, recieversaccount);
			System.out.println(message);
		} catch (CustomerException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

}
