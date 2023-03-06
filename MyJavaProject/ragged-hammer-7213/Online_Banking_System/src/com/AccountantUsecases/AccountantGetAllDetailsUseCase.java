package com.AccountantUsecases;

import java.util.List;

import com.bean.CustomerBean;
import com.dao.AccountantDao;
import com.dao.AccountantImpl;
import com.exception.AccountantException;
import com.exception.CustomerException;

public class AccountantGetAllDetailsUseCase {

	public static void main(String[] args) {
		
		AccountantDao dao = new AccountantImpl ();
		
		try {
			List<CustomerBean> customers =dao.getllCustomerDetails();
			
//			customers.forEach(s -> System.out.println(s));
			int count = 0;
			customers.forEach(s -> {
				
				
				
				System.out.println("Customer Username " + s.getUsername());
				System.out.println("Customer Account Number " + s.getAccountNumber());
				System.out.println("Customer Mobile Number " + s.getMobile());
				System.out.println("Customer password " + s.getPassword());
				System.out.println("Customer balance " + s.getBalance());
				
				System.out.println("===================================================");
			});
		} catch (AccountantException e) {
				System.out.println(e.getMessage());
						
		} catch (CustomerException e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
