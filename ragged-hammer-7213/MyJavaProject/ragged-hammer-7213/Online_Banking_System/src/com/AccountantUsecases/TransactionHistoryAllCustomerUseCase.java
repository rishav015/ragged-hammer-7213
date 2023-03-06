package com.AccountantUsecases;

import com.dao.AccountantDao;
import com.dao.AccountantImpl;
import com.exception.CustomerException;

public class TransactionHistoryAllCustomerUseCase {

	public static void main(String[] args) {
		
		
		AccountantDao dao = new AccountantImpl();
		
		try {
			dao.showAllTransactions();
		} catch (CustomerException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		

	}

}
