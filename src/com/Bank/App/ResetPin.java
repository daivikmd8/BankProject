package com.Bank.App;

import java.util.Scanner;

import com.Bank.DAO.CustomerDAO;
import com.Bank.DAO.CustomerDAOImpl;
import com.Bank.DTO.Customer;

public class ResetPin {
	
	public static void resetPin(Customer c) {
		Scanner sc = new Scanner(System.in);
		CustomerDAO cdao = new CustomerDAOImpl();
		
		System.out.println("Enter your Phone number:");
		long phoneUser = sc.nextLong();
		System.out.println("Enter your EmailID:");
		String mailUser = sc.next();
		
		if(phoneUser == c.getPhone() && mailUser.equals(c.getMail())) {
			System.out.println("Set the pin:");
			int pin = sc.nextInt();
			System.out.println("Confirm the pin");
			int confirmInt = sc.nextInt();
			if(pin == confirmInt) {
				c.setPin(pin);
				boolean res = cdao.updateCustomer(c);
				if(res) {
					System.out.println("Pin updated successfully");
				}
				else {
					System.out.println("Failed to update the pin");
				}
			}
			else {
				System.out.println("Pin Mismatch, enter the correct pin");
			}
			
		}
		else {
			System.out.println("Invalid phone number or MailID!!");
		}
		
		sc.close();
	}

}
