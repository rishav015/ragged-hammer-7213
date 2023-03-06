package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.exception.AccountantException;
import com.exception.CustomerException;
import com.bean.TransactionHistory;
import com.utility.DBUtil;
import com.bean.Accountant;
import com.bean.CustomerBean;

public class AccountantImpl implements AccountantDao {

	@Override
	public List<CustomerBean> getllCustomerDetails() throws AccountantException, CustomerException {
	List<CustomerBean> customers = new ArrayList();
		
		try(Connection connect = DBUtil.provideConnection()){
			
			PreparedStatement ps =connect.prepareStatement("Select * from customer");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int r =rs.getInt("AccountNumber");
				
				String username =rs.getString("username");
				
				String password =rs.getString("password");
				
				String mobile =rs.getString("mobile");
				
				int balance = rs.getInt("Balance");
				
				CustomerBean customer = new CustomerBean(r,username,password,mobile,balance) ;
				
				customers.add(customer);
			}
			
			
			
		}catch(SQLException e) {
			
			throw new AccountantException(e.getMessage());
			
		}
		
		if(customers.size()==0) {
			throw new CustomerException("No Customers Available");
		}
		return customers;
	
	}

	@Override
	public String registerCustomerByAccountant(CustomerBean customer) {
		
		String message = "Customer Not Inserted";
		
		try(Connection connect = DBUtil.provideConnection()){
			
			PreparedStatement ps =connect.prepareStatement("Insert into customer (Username,password,mobile,balance) values (?,?,?,?)");
			
			ps.setString(1,customer.getUsername());
			ps.setString(2,customer.getPassword());
			ps.setString(3,customer.getMobile());
			ps.setInt(4,customer.getBalance());
			
			int res = ps.executeUpdate();
			
			if(res>0) {
				message="Account added sucessufully by Accountant";
			}
			
		}catch(SQLException e) {
			message =e.getMessage();
		}
		
		return message;
	}

	@Override
	public String registerAccountant(Accountant accountant)throws AccountantException {
		
		String message ="Accountant inserted";
		
		try(Connection connect = DBUtil.provideConnection()){
			
			PreparedStatement ps = connect.prepareStatement("insert into Accountant (AccountantName,AccountantUsername,AccountantPassword) values (?,?,?)");
			
			ps.setString(1, accountant.getAccountantName());
			ps.setString(2, accountant.getAccountantUsername());
			ps.setString(3, accountant.getPassword());
			
			int res = ps.executeUpdate();
			
			if(res>0) {
				message ="Accountant account added sucesfully";
			}
		}catch(SQLException e) {
			message =e.getMessage();
		}
		
		return message;
	}

	@Override
	public Accountant loginAccountant(String AccountantUsername, String AccountantPassword) throws AccountantException{
		
		Accountant accountant =null ;
		
		try(Connection connect =DBUtil.provideConnection()){
			
			PreparedStatement ps = connect.prepareStatement("select * from Accountant where AccountantUsername = ? and Accountantpassword = ? ");
			
			ps.setString(1,AccountantUsername);
			ps.setString(2, AccountantPassword);
			
		ResultSet result = 	ps.executeQuery();
		
		if(result.next()) {
			
			String Accountantname = result.getString("AccountantName");
			
			String Accountantusername =result.getString("AccountantUsername");
			
			String password =result.getString("AccountantPassword");
			
//			int account_id =result.getInt("Accountant_id");
//			
//			accountant =new Accountant (Accountantname,Accountantusername,password, account_id);
			
			accountant = new Accountant(Accountantname, Accountantusername, password);
			
		}else {
			throw new AccountantException("Accountant Username/Password mismatch");
		}
		}catch(SQLException e) {
			throw new AccountantException(e.getMessage());
		}
		return accountant;
	}

	@Override
	public String deletaacustomer(int AccountNumber) throws CustomerException {
		
		String message ="Delete operation not performed";
		
		try(Connection connect =DBUtil.provideConnection()){
			
			PreparedStatement ps =connect.prepareStatement("delete from customer where AccountNumber = ? ");
			
			ps.setInt(1, AccountNumber);
			
			ps.executeUpdate();
			
		}catch(SQLException e) {
			
			message =e.getMessage();
			
		}
		return message;
	}

	@Override
	public CustomerBean showCustomer(int AccountNumber) throws CustomerException {
		String message = "Customer failed to extract";
		
		CustomerBean customer =null;
		
		try(Connection connect =DBUtil.provideConnection()){
			
			PreparedStatement ps = connect.prepareStatement("select * from customer where AccountNumber = ?");
			
			ps.setInt(1, AccountNumber);
			
		ResultSet rs =ps.executeQuery();
			
			if(rs.next()) {
				int r =rs.getInt("AccountNumber");
				
				
				
				String username =rs.getString("username");
				
				String password =rs.getString("password");
				
				String mobile =rs.getString("mobile");
				
				int balance = rs.getInt("Balance");
				
				customer = new CustomerBean(r,username,password,mobile,balance) ;
				
				
				
//				
			}else {
				throw new CustomerException("Customer not available");
			}
			
			
			
		}catch(SQLException e) {
			throw new CustomerException (e.getMessage()) ;
		}
		return customer;
	}

	@Override
	public void updateCustomerDetails( int AccountNumber) throws CustomerException {
		
		Scanner sc = new Scanner(System.in);
		
		try(Connection connect = DBUtil.provideConnection()){
			
		 PreparedStatement ps = connect.prepareStatement("Select * from customer where AccountNumber= ? " );
		 
		 ps.setInt(1, AccountNumber);
		 
		 ResultSet res =ps.executeQuery();
		 
		 if(res.next()) {
			 
			 int Acn =res.getInt("AccountNumber");
			 
			 String Username =res.getString("username");
			 
			 String Password = res.getString("Password");
			 
			 String Mobile  = res.getString("mobile");
			 
			 int Balance = res.getInt("balance");
			 
			 System.out.println("The available details of customer are");
			 
			 System.out.println("Account number : " + Acn + "\nUsername : " + Username + "\nPassword : " + Password + "\nMobile Number : " + Mobile + "\nAvailable Balance : " );
			 
			 System.out.println( " ===================================== ");
			  
			 System.out.println("Update Username : ");
			 
			String uname =  sc.nextLine();
			
			System.out.println("Update Mobile Number : ");
			
			String mobile = sc.nextLine();
			
			System.out.println("Update balance : ");
			
			int balance =sc.nextInt();
			
			sc.nextLine();
			
			System.out.println("Update password : ");
			
			String password = sc.nextLine();
			
			System.out.println("Assign New Account Number : ");
			
			int newAccountnumber =sc.nextInt();
			
			PreparedStatement ps1 =connect.prepareStatement("update customer set AccountNumber= ? ,username = ? ,mobile = ? ,password= ? ,balance = ? where AccountNumber = ? ");
			
			ps1.setInt(1, newAccountnumber);
			
			ps1.setString(2, uname);
			
			ps1.setString(3, mobile);
			
			ps1.setString(4, password);
			
			ps1.setInt(5, balance);
			
			ps1.setInt(6, AccountNumber);
			
			int res1 = ps1.executeUpdate();
			
			if(res1>0) {
				System.out.println("Account Updated Sucessfully");
			}else {
				System.out.println("Unsucessful updation ");
			}
			
			
			 
		 }else {
			 throw new CustomerException("Information updation unsucessful");
		 }
		 
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
		
	}

	@Override
	public void showAllTransactions() throws CustomerException {
		
		List<TransactionHistory> transaction_history = new ArrayList();
		
		
		
		try(Connection connect= DBUtil.provideConnection()){
			
			PreparedStatement ps =connect.prepareStatement("select * from transaction_history");
			
			ResultSet res =ps.executeQuery();
			
			while(res.next()) {
				int an =res.getInt("Accountnumber");
				
				int arn=res.getInt("Recievers_AccountNumber");
				
				int at =res.getInt("Amount_transfered");
				
				int cre =res.getInt("Credited");
				
				int wd =res.getInt("Withdrawn");
				
				int ar =res.getInt("Amount_recieved");
				
				TransactionHistory th = new TransactionHistory(an,arn,at,cre,wd,ar);
				
				transaction_history.add(th);
			}
			if(transaction_history.size()==0) {
				System.out.println("No transactions available");
			}else {
				transaction_history.forEach(t ->System.out.println(t));
			}
			
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
