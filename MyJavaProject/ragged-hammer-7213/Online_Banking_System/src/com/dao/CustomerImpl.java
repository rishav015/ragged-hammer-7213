package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.CustomerBean;
import com.exception.CustomerException;
import com.bean.TransactionHistory;
import com.utility.DBUtil;

public class CustomerImpl implements CustomerDao{

	@Override
	public String registerCustomer(String Username, String Password, String Mobile ,int Balance) {
		
		
		String message ="Not Inserted";
		
		;
		
		try(Connection connect= DBUtil.provideConnection()){
			
			PreparedStatement ps =connect.prepareStatement("insert into customer (Username , Password , Mobile,Balance) values (?,?,?,?)");
			
			ps.setString(1,Username);
			ps.setString(2, Password);
			ps.setString(3, Mobile);
			ps.setInt(4, Balance);
			
			int res =ps.executeUpdate();
			
			if(res>0) {
				message = "Customer registered sucessfully";
			}
			
		}catch(SQLException e) {
			message = e.getMessage();
		}
		return message;
	}

	@Override
	public String registerCustomer2(CustomerBean customer) {
		
		String message ="Not Inserted";
		
		;
		
		try(Connection connect= DBUtil.provideConnection()){
			
			PreparedStatement ps =connect.prepareStatement("insert into customer (Username , Password , Mobile,balance) values (?,?,?,?)");
			
			ps.setString(1,customer.getUsername());
			ps.setString(2,customer.getPassword());
			ps.setString(3,customer.getMobile());
			ps.setInt(4,customer.getBalance());
			
			int res =ps.executeUpdate();
			
			if(res>0) {
				message = "Customer registered sucessfully";
			}
			
		}catch(SQLException e) {
			message = e.getMessage();
		}
		return message;
	}

	@Override
	public CustomerBean getAccountDetailsByAccount(int AccountNumber)throws CustomerException {
		
		CustomerBean customer=null;
		
		try(Connection connect= DBUtil.provideConnection()){
			
			PreparedStatement ps =connect.prepareStatement("select * from customer where AccountNumber=?");
			
		ps.setInt(1,AccountNumber);
			
		ResultSet rs =ps.executeQuery();
		
		if(rs.next()) {
			int r =rs.getInt("AccountNumber");
			
			
			
			String username =rs.getString("username");
			
			String password =rs.getString("password");
			
			String mobile =rs.getString("mobile");
			
			int balance = rs.getInt("Balance");
			
			customer = new CustomerBean(r,username,password,mobile,balance) ;
			
			
			
			
		}else {
			throw new CustomerException("Customer does not exist" + AccountNumber);
		}
			
		}catch(SQLException E) {
			
			throw new CustomerException(E.getMessage());
			
		}
		
		
		return customer;
	}

	@Override
	public CustomerBean loginCustomer(int AccountNumber, String Password) throws CustomerException {
		
		CustomerBean customer= null;
		
		try(Connection connect = DBUtil.provideConnection()){
			PreparedStatement ps =connect.prepareStatement("select * from Customer where AccountNumber=? and password= ?");
			
			ps.setInt(1,AccountNumber);
			ps.setString(2,Password);
			
			ResultSet rs =ps.executeQuery();
			
			if(rs.next()) {
				
				int r =rs.getInt("AccountNumber");
				

				String username =rs.getString("username");
				
				String password =rs.getString("password");
				
				String mobile =rs.getString("mobile");
				
				int balance = rs.getInt("Balance");
				customer = new CustomerBean(r,username,password,mobile,balance) ;
			}else {
				throw new CustomerException("Invalid Username or password");
			}
			
			
			
		}catch(SQLException e) {
			throw new CustomerException(e.getMessage());
		}
		return customer;
	}

	@Override
	public String depositAmount(int Amount, int AccountNumber) throws CustomerException {
		
		String messag = "Amount Deposit unsucessful";
		
		
		
		try(Connection connect = DBUtil.provideConnection()){
			
			PreparedStatement ps = connect.prepareStatement("update customer set balance=balance + ? where AccountNumber = ? ");
			ps.setInt(1, Amount);
			ps.setInt(2, AccountNumber);
			
			
			int res = ps.executeUpdate();
			
			if(res>0) {
				messag ="Amount "+Amount+" Added Sucessfully Updated Amount:";
				
			}else {
				messag ="Failed deposit " + Amount;
			}
//			
//			AccountantDao dao = new AccountantImpl();
////			
//		CustomerBean customer = dao.showCustomer(AccountNumber);
//			
//			
//			messag="Available balance " + customer.getBalance();
			
//			int balance = customer.getBalance();
			
			PreparedStatement ps1 = connect.prepareStatement("insert into transaction_history (Accountnumber,Credited) values (?,?)");
			
			ps1.setInt(1,AccountNumber);
			
			ps1.setInt(2, Amount);
			
			int res1 =ps1.executeUpdate();
			
			
			
		}catch(SQLException e) {
			messag =e.getMessage();
		}
		
		return messag ;
		
	}

	@Override
	public String withdrawammount(int Amount, int AccountNumber) throws CustomerException {
		
		String message="Amount exceeded Withdraw not possible" ;
		
		try(Connection connect = DBUtil.provideConnection()){
			
			AccountantDao dao = new AccountantImpl();
			
			CustomerBean customer = dao.showCustomer(AccountNumber);
			
			if(customer.getBalance()>=Amount) {
			
				PreparedStatement ps = connect.prepareStatement("update customer set balance = balance - ? where AccountNumber= ? ");
			
				ps.setInt(1, Amount);
				
				ps.setInt(2, AccountNumber);
				
				int res = ps.executeUpdate();
				
				if(res>0) {
					message ="Amount deducted Sucessfully";
				}else {
					message ="Failed withdraw";
				}
				
				
				PreparedStatement ps1 =connect.prepareStatement("insert into transaction_history ( AccountNumber,withdrawn) values (?,?)");
				
				ps1.setInt(1,AccountNumber);
				
				ps1.setInt(2,Amount);
				
				ps1.executeUpdate();
			}
			
			
			
		}catch(SQLException e) {
			
			message = e.getMessage();
			
		}
		
		
		return message;
	}

	@Override
	public String transferMoney(int Amount, int SAccountNumber, int RAccountNumber) throws CustomerException {
		String message = "Amount Transfered Failed";
		
	
				
		
		try(Connection connect = DBUtil.provideConnection()){
			
			AccountantDao dao = new AccountantImpl();
			
			CustomerBean c1 = dao.showCustomer(SAccountNumber);
			
			CustomerBean c2 = dao.showCustomer(RAccountNumber);
					
			int sbalance = c1.getBalance();
			int rbalance =c2.getBalance();
			
			if(sbalance >= Amount) {
				
				sbalance = sbalance-Amount;
				
				rbalance = rbalance + Amount;
				
				PreparedStatement pss =connect.prepareStatement("update customer set balance=? where AccountNumber = ? ");
				
				PreparedStatement psr =connect.prepareStatement("update customer set balance =? where accountNumber = ? ");
				
				pss.setInt(1, sbalance);
				pss.setInt(2, SAccountNumber);
				
				psr.setInt(1, rbalance);
				psr.setInt(2, RAccountNumber);
				
				int s = pss.executeUpdate();
				
				int r =psr.executeUpdate();
				
				
				if(s>0 && r>0) {
					message ="Account debited from account "+ c1.getUsername() +" " + "Available Balance " + sbalance ;
					message ="Amount Credited to " +c2.getUsername() ;
					
					
				
				}else {
					message ="Withdrawal failed";
				}
				
				PreparedStatement pssu =connect.prepareStatement("insert into transaction_history (AccountNumber,Recievers_AccountNumber,Amount_transfered) values (?,?,?)");
				
				pssu.setInt(1,SAccountNumber);
				pssu.setInt(2,RAccountNumber);
				pssu.setInt(3,Amount);
				
				
				pssu.executeUpdate();
				
				PreparedStatement psru =connect.prepareStatement("insert into transaction_history (AccountNumber,Recievers_AccountNumber, Amount_recieved ) values (?,?,?) ");
				
				psru.setInt(1,RAccountNumber );
				psru.setInt(2,SAccountNumber);
				psru.setInt(3, Amount);
				
				psru.executeUpdate();
			}else {
				message="Insufficent balance " + "Balance Available " + sbalance;
			}
			
		
			
			
		}catch(SQLException e) {
			message = e.getMessage();
		}
		return message;
	}

	@Override
	public void checkTransactionHistory(int AccountNumber) {
		List<TransactionHistory> transaction_history = new ArrayList<>();

		try (Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from transaction_history where AccountNumber=?");
			ps.setInt(1, AccountNumber);
			ResultSet res = ps.executeQuery();

			while (res.next()) {

				int an =res.getInt("Accountnumber");
				
				int arn=res.getInt("Recievers_AccountNumber");
				
				int at =res.getInt("Amount_transfered");
				
				int cre =res.getInt("Credited");
				
				int wd =res.getInt("Withdrawn");
				
				int ar =res.getInt("Amount_recieved");

				TransactionHistory th = new TransactionHistory(an,arn,at,cre,wd,ar);

				transaction_history.add(th);
			}

			if (transaction_history.size() == 0) {
				System.out.println("No Transactions");
			} else {
				transaction_history.forEach(t -> System.out.println(t));
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}


	
	
	
	

}
