package com.Bank.App;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.Bank.DAO.CustomerDAO;
import com.Bank.DAO.CustomerDAOImpl;
import com.Bank.DAO.TransactionDAO;
import com.Bank.DAO.TransactionDAOImpl;
import com.Bank.DTO.Customer;
import com.Bank.DTO.Transaction;
import com.Bank.DTO.TransactionID;

public class Admin {
	
	public static void admin(Customer c) {
		Scanner sc = new Scanner(System.in);
		CustomerDAO cdao = new CustomerDAOImpl();
		TransactionDAO tdao = new TransactionDAOImpl();
		int choice = 0;
		
		do {
			System.out.println("1. Account data");
			System.out.println("2. Get Transaction List");
			System.out.println("3. Delete any user");
			System.out.println("4. Access your account");
			System.out.println("5. Back to main menu");
			choice=sc.nextInt();
			
			switch(choice) {
			case 1: {
				System.out.println("=========== CUSTOMERS DATA ===========");
				List<Customer> customers = cdao.getCustomer();
				Iterator<Customer> it = customers.iterator();
				while(it.hasNext()) {
					Customer c1 = it.next();
					System.out.println(c1);
				}
				break;
				}
			
			case 2: {
				System.out.println("========= TRANSACTION LIST ========");
				List<Transaction> transactions = tdao.getTransaction();
				Iterator<Transaction> it = transactions.iterator();
				while(it.hasNext()) {
					Transaction t1 = it.next();
					System.out.println(t1);
				}
				break;
				}
			
			case 3: {
				System.out.println("Enter the user account number to delete:");
				Customer c1 = cdao.getCustomer(sc.nextLong());
				if(c.getAccno() != c1.getAccno()) {
					double amount = c1.getBal();
					c.setBal(c.getBal() + amount);
					boolean res1 = cdao.updateCustomer(c);
					if(res1) {
						Transaction t1 = new Transaction();
						t1.setTransactionId(TransactionID.generateTransactionId());
						t1.setUser(c.getAccno());
						t1.setRec_acc(c1.getAccno());
						t1.setAmount(amount);
						t1.setTransaction("CREDITED");
						t1.setBalance(c.getBal());
						boolean res = tdao.insertTransaction(t1);
						
						if(res1 && res) {
							System.out.println("Proceeding to delete");
							cdao.deleteCustomer(c1);
						}
						else {
							System.out.println("Failed to delete");
						}
					}
					else {
						System.err.println("Failed to delete, amount tranfer failed from the customer!!!");
					}
					
				}
				else {
					System.out.println("Cannot delete the Admin data");
				}
				break;
			}
			
			case 4: {
				App.options(c);
				break;
			}
			
			case 5: {
				System.out.println("Go back to main menu");
				break;
			}
			
			default: System.out.println("Invalid choice, choose valid choice.");
			
			}
		}
		while(choice != 5);
		
//		sc.close();
	}

}
