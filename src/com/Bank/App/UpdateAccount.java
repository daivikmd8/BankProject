package com.Bank.App;

import java.util.Scanner;

import com.Bank.DAO.CustomerDAO;
import com.Bank.DAO.CustomerDAOImpl;
import com.Bank.DTO.Customer;

public class UpdateAccount {
	public static void updateAccount(Customer c) {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		CustomerDAO cdao = new CustomerDAOImpl();
		System.out.println("Enter the field to be updated:");
		do {
			System.out.println("1. Name");
			System.out.println("2. Phone Number");
			System.out.println("3. Email ID");
			System.out.println("4. Exit to Main menu");
			choice = sc.nextInt();
			
			switch(choice) {
			case 1: {
				System.out.println("Enter the Name to update:");
				c.setName(sc.next());
				boolean res = cdao.updateCustomer(c);
				if(res) {
					System.out.println("Name is updated to " + c.getName() + " Successfully!!");
				}
				else {
					System.out.println("Failed to update the name");
				}
				break;
			}
				
			case 2: {
				System.out.println("Enter the Phone Number to update:");
				c.setPhone(sc.nextLong());
				boolean res = cdao.updateCustomer(c);
				if(res) {
					System.out.println("Phone Number is updated to " + c.getPhone() + " successfully");
				}
				else {
					System.out.println("Failed to update the phone number");
				}
				break;
			}
			
			case 3: {
				System.out.println("Enter the EmailID to update:");
				c.setMail(sc.next());
				boolean res = cdao.updateCustomer(c);
				if(res) {
					System.out.println("EmailID is updated to " + c.getMail() + " successfully");
				}
				else {
					System.out.println("Failed to update the EmailID");
				}
				break;
			}
			
			case 4: {
				System.out.println("Exit to Main menu");
				break;
			}
			
			default: System.out.println("Invalid Choice, Enter the correct choice");
			
		}
	}
	while(choice != 4);
	}

}
