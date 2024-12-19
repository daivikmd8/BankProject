package com.Bank.App;

import java.util.Scanner;

import com.Bank.DAO.CustomerDAO;
import com.Bank.DAO.CustomerDAOImpl;
import com.Bank.DTO.Customer;

public class Signup {
	
	public static void signup() {
		
		Scanner sc = new Scanner(System.in);
		CustomerDAO cdao = new CustomerDAOImpl();
		Customer c = new Customer();
		
		System.out.println("====== APPLICATION FORM ======");
		
		System.out.println("Enter your Name:");
		c.setName(sc.next());
		
		System.out.println("Enter the Phone Number:");
		c.setPhone(sc.nextLong());
		
		System.out.println("Enter your mail ID:");
		c.setMail(sc.next());
		
		System.out.println("Set the Pin");
		int pin = sc.nextInt();
		
		System.out.println("Confirm Pin:");
		int confirmPin = sc.nextInt();
		
		if(pin == confirmPin) {
			c.setPin(pin);
			boolean res = cdao.insertCustomer(c);
			if(res) {
				System.out.println("Data added Successfully");
				c = cdao.getCustomer(c.getPhone(), c.getMail());
				System.out.println("Your account number is " + c.getAccno());
			}
			else {
				System.out.println("Failed to create the account");
			}
		}
	}

}
