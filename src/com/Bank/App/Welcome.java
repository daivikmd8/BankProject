package com.Bank.App;

import java.util.Scanner;

public class Welcome {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		System.out.println("<======= WELCOME TO BANK APPLICATION =======>");
		
		do {
			System.out.println("1. Customer Login");
			System.out.println("2. Create a account");
			System.out.println("3. Exit");
			choice = sc.nextInt();
			
			switch(choice) {
			case 1 :
				Login.login();
				break;
			
			case 2:
				Signup.signup();
				break;
				
			case 3:
				System.out.println("------------ Exiting from Application, Thank You ----------------");
				break;
				
			default:
				System.out.println("Invalid Choice!!!");
			}
		}
		while(choice!=3);
//		sc.close();
		
	}

}
