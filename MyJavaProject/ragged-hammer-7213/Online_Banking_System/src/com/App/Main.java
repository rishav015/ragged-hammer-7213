package com.App;

import java.util.List;
import java.util.Scanner;

import com.bean.Accountant;
import com.bean.CustomerBean;
import com.dao.AccountantDao;
import com.dao.AccountantImpl;
import com.dao.CustomerDao;
import com.dao.CustomerImpl;
import com.exception.AccountantException;
import com.exception.CustomerException;

public class Main {

	public static void main(String[] args) throws CustomerException {
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Welcome to Online Banking Application");
		
		System.out.println("Select an option");
		
		System.out.println("\n1:Login as Customer \n2:Login as Accountant ");
		
		int choice =sc.nextInt();
		
		switch(choice) {
		    case 1:
		        System.out.println("Enter your Information to CUSTOMER LOGIN");
		        boolean flag=false;
		        System.out.println("Enter Account number");
		        
		        int AccountNumber =sc.nextInt();
		        
		        sc.nextLine();
		        
		        System.out.println("Enter your password");
		        String Password =sc.next();
		        
		        CustomerDao dao = new CustomerImpl();
		        
		        try {
		            CustomerBean customer = dao.loginCustomer(AccountNumber, Password);
	                  flag=true;
		            System.out.println("Welcome to online banking Application" + customer.getUsername());
		            
		            
		        } catch (CustomerException e) {
		            
		           System.out.println(e.getMessage());
		        }
		        
		        while(flag==true) {
		            System.out.println("Select your option");
		            
		            System.out.println("\n1:Get account information \n2:Deposit money \n3:Withdraw amount \n4:Transfer money \n5:Check your transaction history \n6:Exit");
		            
		            System.out.println("Please select an option : ");
		            
		            int customerchoice=sc.nextInt();
		            
		            switch(customerchoice) {
		                case 1:
		                    Scanner sc1 = new Scanner(System.in);
		                    
		                    System.out.println("Enter your Information to fetch details");
		                    
		                    System.out.println("Enter Customer Account number");
		                    
		                    int Acc=sc1.nextInt();
		                    
		                    CustomerDao daoc = new CustomerImpl();
		                    
		                    CustomerBean customer;
		                    try {
		                        customer = daoc.getAccountDetailsByAccount(Acc);
		                        System.out.println(customer);
		                    } catch (CustomerException ce) {
//		                      // TODO Auto-generated catch block
//		                      ce.printStackTrace();
		                        System.out.println(ce.getMessage());
		                    }
		                    break;
		                case 2:
		                    System.out.println("Enter your Information to proceed");
		                    Scanner sc2 = new Scanner(System.in);
		                    
		                    System.out.println("Enter Amount to deposit");
		                    
		                    int Amount =sc2.nextInt();
		                    
		                    System.out.println("Enter your Account Number");
		                    
		                    int accountNumber =sc2.nextInt();
		                    
		                    CustomerDao cdao = new CustomerImpl();
		                    
		                    AccountantDao adao =new AccountantImpl();
		                    
		                    
		                    
		                    try {
		                        
		                        
		                        String message =cdao.depositAmount(Amount, accountNumber);
		                        
		                        CustomerBean customer1 =adao.showCustomer(accountNumber);
		                        
		                        System.out.println(message+customer1.getBalance() );
		                        
		                        
		                        
		                        
		                        
//		                      System.out.println(message);
		                    } catch (CustomerException e) {
		                        
		                        System.out.println(e.getMessage());
		                    }
		                    break;
		                case 3:
		                    System.out.println("Enter your Information to withdraw amount");

		                    Scanner sc3 = new Scanner (System.in);
		                    
		                    System.out.println("Enter the Amount");
		                    int Amountw = sc3.nextInt();
		                    
		                    
		                    System.out.println("Enter the Account NUmber");
		                    int AccountNumber1 = sc3.nextInt();
		                    
		                    CustomerDao daoc1 = new CustomerImpl();
		                    
		                    try {
		                        String message =daoc1.withdrawammount(Amountw, AccountNumber1);
		                        
		                        System.out.println(message);
		                    } catch (CustomerException e) {
		                    System.out.println(e.getMessage());
		                    }
		                    break;
		                    
		                case 4:
		                    System.out.println("Enter your Information to transfer amount");
		                    
		                    Scanner sc4 =new Scanner(System.in);
		                    
		                    System.out.println("Enter Amount");
		                    
		                    int amount =sc4.nextInt();
		                    
		                    System.out.println("Enter Your Account Number");
		                    
		                    int sendersaccount =sc4.nextInt();
		                    
		                    System.out.println("Enter Reciever's Account number ");
		                    
		                    int recieversaccount = sc.nextInt();
		                    
		                    CustomerDao daot =new CustomerImpl();
		                    
		                    try {
		                        String message =daot.transferMoney(amount, sendersaccount, recieversaccount);
		                        System.out.println(message);
		                    } catch (CustomerException e) {
		                        // TODO Auto-generated catch block
		                        System.out.println(e.getMessage());
		                    }
		                    
		                    break;
		                    
		                case 5:
		                    System.out.println("Enter your Information to check history");
		                    
		                    Scanner sc5 = new Scanner (System.in);
		                    
		                    System.out.println("Enter your Account Number");
		                    
		                    int AccountNumber5 =sc5.nextInt();
		                    
		                    CustomerDao cdaoh=new CustomerImpl();
		                    
		                    cdaoh.checkTransactionHistory(AccountNumber5);
		                    break;
		                case 6:
		                    Scanner sc6 = new Scanner (System.in);
		                    
		                    System.out.println("Are you sure you want to exit if yes press 1 else press 2");
		                    
		                    int check=sc6.nextInt();
		                    
		                    if(check==1) {
		                        System.out.println("Thank you for banking with us see you again");
		                        flag=false;
		                        
		                    }else {
		                        continue;
		                    }
		                    break;
		                    default:System.out.println("Invalid input");
		                    break;
		            }
		        }
		        break;
		        
		    case 2: 
		        
		        
		        
		        System.out.println("Enter your Information to ACCOUNTANT LOGIN");
		        
		        boolean flaga=false;
		        
		        System.out.println("Enter Accountant username");
		        sc.nextLine();
		        String Username =sc.nextLine();
		        
		        System.out.println("Enter Accountant Password");
		        String password = sc.nextLine();
		        
		        AccountantDao daoa = new AccountantImpl();
		        
		        
		        try {
		            Accountant accountant =daoa.loginAccountant(Username, password);
		            flaga=true;
		            System.out.println("Login successful as Accountant "+accountant.getAccountantName());
//		          System.out.println(accountant);
//		          
		            while(flaga==true) {
		                System.out.println("Select your option");
	                    
	                    System.out.println("\n1:Get customer account information of customer \n2:get all customer details \n3:Get transaction history of all customers \n4:Delete a customer account \n5:Register a customer \n6:Update customer detail \n7:Register a accountant  \n8:Exit");
	                    
	                    System.out.println("Enter the option number :");
	                    
	                    int accountantchoice=sc.nextInt();
	                    
	                    switch(accountantchoice) {
	                        case 1:
	                            
	                            System.out.println("Get customer account information of customer");
	                            
	                            System.out.println("Enter Account number to show Customer");
	                            
	                            Scanner sc1 = new Scanner (System.in);
	                            
	                            int AccountNumbera1 = sc1.nextInt();
	                            
	                            AccountantDao daoa1 = new AccountantImpl();
	                            
	                            try {
	                                CustomerBean result = daoa1.showCustomer(AccountNumbera1);
	                                
	                                System.out.println("Account details extracted successfully " + result.getUsername());
	                                
	                                System.out.println(result);
	                            } catch (CustomerException e) {
	                                // TODO Auto-generated catch block
	                            System.out.println(e.getMessage());
	                            }
	                            
	                            break;
	                            
	                        case 2: 
	                            System.out.println("get all customer details");
	                            AccountantDao daoa2 = new AccountantImpl ();
	                            
	                            try {
	                                List<CustomerBean> customers =daoa2.getllCustomerDetails();
	                                
//	                              customers.forEach(s -> System.out.println(s));
	                                int count =0;
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
	                            
	                            break;
	                            
	                        case 3:
	                            System.out.println("Get transaction history of all customers");
	                            AccountantDao daoa3 = new AccountantImpl();
	                            
	                            try {
	                                daoa3.showAllTransactions();
	                            } catch (CustomerException e) {
	                                // TODO Auto-generated catch block
	                                System.out.println(e.getMessage());
	                            }
	                            
	                            break;
	                            
	                        case 4:
	                            
	                            System.out.println("Delete a customer account");
	                            Scanner sca4 = new Scanner(System.in);
	                            
	                            System.out.println("Enter the account no to delete");
	                            
	                            int AccountNumbera4 = sca4.nextInt();
	                            
	                            AccountantDao daoa4 = new AccountantImpl();
	                            
	                            try {
	                                daoa4.deletaacustomer(AccountNumbera4);
	                                
	                                System.out.println("Account deleteed sucessfully");
	                            } catch (CustomerException e) {
	                                // TODO Auto-generated catch block
	                                e.printStackTrace();
	                            }
	                            
	                            break;
	                        case 5:
	                            System.out.println("Register a customer ");
	                            Scanner sca5 = new Scanner (System.in);
	                            
	                            System.out.println("Enter Username");
	                            
	                            String Usernamea5 = sca5.nextLine();
	                            
	                            System.out.println("Enter Password");
	                            
	                            

	                            String Passworda5 = sca5.nextLine();
	                            
	                            System.out.println("Enter Mobile");
	                            

	                            String Mobilea5=sca5.nextLine();
	                            
	                            System.out.println("Enter Balance");
	                            
	                            int balancea5 =sca5.nextInt();
	                            
	                            AccountantDao daoa5 = new AccountantImpl();
	                            
	                            CustomerBean customer = new CustomerBean();
	                            
	                            customer.setUsername(Usernamea5);
	                            customer.setPassword(Passworda5);
	                            customer.setMobile(Mobilea5);
	                            customer.setBalance(balancea5);
	                            
	                            String result =daoa5.registerCustomerByAccountant(customer);
	                            
	                            System.out.println(result);
	                            
	                            
	                           break;
	                           
	                        case 6:
	                            
	                            System.out.println("Update customer details ");
	                            Scanner sca6 = new Scanner(System.in);
	                            
	                            System.out.println("Enter the account number where you have to update the name " );
	                            
	                            int Accountnumber =sca6.nextInt();
	                            
	                            
	                            AccountantDao daoa6 =new AccountantImpl();
	                            
	                            try {
	                                daoa6.updateCustomerDetails(Accountnumber);
	                                
	                                
	                            } catch (CustomerException e) {
	                                // TODO Auto-generated catch block
	                                System.out.println(e.getMessage());
	                            }
	                            
	                            break;
	                            
	                        case 7:
	                            
	                            System.out.println("Register a accountant");
	                            
	                            System.out.println("enter your Name");
	                            
	                            String Accountantnamea7 =sc.nextLine();
	                            
	                            System.out.println("enter your Username");
	                            
	                            String AccountantUsernamea7 =sc.nextLine();
	                            
	                            System.out.println("enter your Password");
	                            
	                            String Passworda7 = sc.nextLine();
	                            
	                            AccountantDao daoa7 =new AccountantImpl();
	                            
	                            Accountant accountanta7 =new Accountant();
	                            
	                            accountant.setAccountantName(Accountantnamea7);
	                            
	                            accountant.setAccountantUsername(AccountantUsernamea7);
	                            
	                            accountant.setPassword(Passworda7);
	                            
	                            String resulta7;
	                            try {
	                                resulta7 = daoa7.registerAccountant(accountanta7);
	                                
	                                System.out.println(resulta7);
	                            } catch (AccountantException e) {
	                                // TODO Auto-generated catch block
	                                e.printStackTrace();
	                            }
	                            
	                           
	                            break;
	                            
	                        case 8:
	                           System.out.println("Do you want to exit");
	                            Scanner sc6 = new Scanner (System.in);
	                            
	                            System.out.println("Are you sure you want to exit if yes press 1 else press 3");
	                            
	                            int checka=sc6.nextInt();
	                            
	                            if(checka==1) {
	                                System.out.println("Thank you for banking with us see you again accountant");
	                                flaga=false;
	                                
	                                
	                            }else {
	                                continue;
	                            }
	                            break;
	                            
	                        
	                        default:System.out.println("Invalid input");
	                            break;
	                            
	                            
	                            
	                            
	                    }
		            }
		        } catch (AccountantException e) {
		            
		            System.out.println(e.getMessage());
		        }
		        
		        
		}

	

}
		
	}

