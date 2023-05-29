package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;
import exception.BusinessException;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);		
		
		try {
			System.out.println("Enter account data:");
			System.out.print("Number: ");
			Integer number = sc.nextInt();
			System.out.print("Holder: ");
			String name = sc.next();
			sc.nextLine();
			System.out.print("Initial Balance: ");
			Double initialBalance = sc.nextDouble();
			System.out.print("Withdraw Limit: ");
			Double withdrawLimit = sc.nextDouble();
			
			Account client = new Account(number, name, initialBalance, withdrawLimit);
			
			System.out.println();		
			System.out.print("Enter amount for withdraw: ");
			Double amount = sc.nextDouble();
			client.withdraw(amount);
					
			System.out.println(client);
		} catch(BusinessException error) {
			System.out.println("Withdraw error: " + error.getMessage());
		}
		
		sc.close();
	}

}
