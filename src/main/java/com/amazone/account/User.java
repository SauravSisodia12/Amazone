package com.amazone.account;

import java.util.Scanner;

import com.amazone.exception.BrandNotFoundException;
import com.amazone.exception.CategoryNotFoundException;
import com.amazone.exception.UserAlreadyExistException;
import com.amazone.exception.UserNotFoundException;
import com.amazone.model.UserDetails;
import com.amazone.services.UserServices;
import com.amazone.services.UserServicesImple;

public class User {
	
	Scanner sc = new Scanner(System.in);
	UserServices us = new UserServicesImple();
	String username;
	
	public void userLogin() {
	
	try {
		System.out.println("Enter your choice (1 or 2) = ");
		System.out.println("1 = Register");
		System.out.println("2 = login");
		System.out.print("Choice = ");
		int choice = sc.nextInt();
		System.out.println();
		
		if(choice == 1) {
		System.out.println("Enter userId, name, password, mailId, MobileNo, Address :");
		String userId = sc.next();
		String name = sc.next();
		String password = sc.next();
		String mailId = sc.next();
		int mobileno = sc.nextInt();
		String address = sc.next();
		
			UserDetails userdetails = new UserDetails(userId,name,password,mailId,mobileno,address,5000.0);
			us.register(userdetails);
			System.out.println();
			System.out.print("Do you want to continue :");
			String option = sc.next();
			if(option.equalsIgnoreCase("yes"))
				{	System.out.println();
					userLogin();
				}
		}
			
		else if(choice == 2) {
			System.out.print("Enter UserName = ");
			String lName = sc.next();
			username = lName;
			System.out.print("Enter Password = ");
			String lPass = sc.next();
			
			int result = us.login(lName, lPass);
			if(result == 1)
			{
				System.out.println();
				System.out.println("Successfully Logged in....");
				userFunctions();
			
						}
					}
				}	catch (UserAlreadyExistException | UserNotFoundException e) {
						System.err.println(e.getMessage());
						}
				}
	
	
	public int[] listOfProducts(int size) {

		int[] list = new int[size];
		System.out.print("Enter the id's of "+size+" products : ");
		for(int i = 0; i<size; i++) {
			int no = sc.nextInt();
			list[i]=no;
		}
		return list;
	}
	
	public void buy(int totalBill) {
		
		int totalAmount = totalBill;
		System.out.println();
		int balance = us.checkBalance(username);
		System.out.println("Total Generated Bill : "+totalAmount);
		System.out.println();
		System.out.print("Do you want to make the purchase : ");
		String decision = sc.next();
		if(decision.equalsIgnoreCase("yes")) {
				if(balance>=totalAmount) {
						System.out.println();
						System.out.println("Successfully Purchased...");
						System.out.println();
						us.updateWalletBalance(username,totalAmount);
					}
				else {
					System.out.println();
					System.out.println("Wallet Balance : "+balance);
					System.out.println("Low Wallet Balance...");
					System.out.println();
					System.out.print("Do you want to add money in your wallet : ");
					String addBal = sc.next();
					if(addBal.equalsIgnoreCase("yes")) {
						System.out.print("Amount you want to add : ");
						int amount = sc.nextInt();
						us.addMoney(amount, username);
						buy(totalAmount);
						}
					}
		}
	}
	
	public void userFunctions() {
			
		try {
				System.out.println();
				System.out.println("Enter your choice (1 to 4) to proceed = ");
				System.out.println("1. View All Products");
				System.out.println("2. View Products By Category");
				System.out.println("3. View Products By Brand Name");
				System.out.println("4. View Products By Price");
				System.out.println("5. Check Wallet Balance");
				System.out.print("Your Choice : ");
				int uchoice = sc.nextInt();
				
				if(uchoice == 1) {
					System.out.println();
					System.out.println("All Products");
					us.viewAllProducts().stream().forEach(System.out::println);
					System.out.println();
					System.out.print("Enter no of products you want to buy : ");
					int noOfItems = sc.nextInt();
					buy(us.generateBill(listOfProducts(noOfItems)));
					System.out.println();
					System.out.print("Do you want to continue :");
					String option = sc.next();
					if(option.equalsIgnoreCase("yes"))
						{	System.out.println();
							userFunctions();
						}
					else
						System.out.println("Thanks for Visiting");
				}
				else if(uchoice == 2) {
					System.out.println();
					System.out.println("Products By Category");
					System.out.print("Enter Category = ");
					String category = sc.next();
					us.viewProductByCategory(category).stream().forEach(System.out::println);
					System.out.println();
					System.out.print("Enter no of products you want to buy : ");
					System.out.println();
					int noOfItems = sc.nextInt();
					buy(us.generateBill(listOfProducts(noOfItems)));
					System.out.println();
					System.out.print("Do you want to continue :");
					String option = sc.next();
					if(option.equalsIgnoreCase("yes"))
						{	System.out.println();
							userFunctions();
						}
					else
						System.out.println("Thanks for Visiting");
				}
				else if(uchoice == 3) {
					System.out.println();
					System.out.println("Products By BrandName");
					System.out.print("Enter Brand = ");
					String brand = sc.next();
					us.ViewProductByBrand(brand).stream().forEach(System.out::println);
					System.out.println();
					System.out.print("Enter no of products you want to buy : ");
					System.out.println();
					int noOfItems = sc.nextInt();
					buy(us.generateBill(listOfProducts(noOfItems)));
					System.out.println();
					System.out.print("Do you want to continue :");
					String option = sc.next();
					if(option.equalsIgnoreCase("yes"))
						{	System.out.println();
							userFunctions();
						}
					else
						System.out.println("Thanks for Visiting");
				}
				else if(uchoice == 4) {
					System.out.println();
					System.out.println("Products By Price");
					System.out.println("Enter your choice (1 or 2) to proceed = ");
					System.out.println("1. Low To High");
					System.out.println("2. High To Low");
					int priceChoice = sc.nextInt(); 
					if(priceChoice == 1) {
						System.out.println();
						System.out.println("Products By Low To High Price");
						us.ViewProductByPrice(priceChoice).stream().forEach(System.out::println);
						System.out.println();
						System.out.print("Enter no of products you want to buy : ");
						System.out.println();
						int noOfItems = sc.nextInt();
						buy(us.generateBill(listOfProducts(noOfItems)));
						System.out.println();
						System.out.print("Do you want to continue :");
						String option = sc.next();
						if(option.equalsIgnoreCase("yes"))
							{	System.out.println();
								userFunctions();
							}
						else
							System.out.println("Thanks for Visiting");
					}
					else if(priceChoice == 2) {
						System.out.println();
						System.out.println("Products By High To Low Price");
						us.ViewProductByPrice(priceChoice).stream().forEach(System.out::println);
						System.out.println();
						System.out.print("Enter no of products you want to buy : ");
						System.out.println();
						int noOfItems = sc.nextInt();
						buy(us.generateBill(listOfProducts(noOfItems)));
						System.out.println();
						System.out.print("Do you want to continue :");
						String option = sc.next();
						if(option.equalsIgnoreCase("yes"))
							{	System.out.println();
								userFunctions();
							}
						else
							System.out.println("Thanks for Visiting");
						}
					}
				else if(uchoice == 5) {
					System.out.println();
					System.out.print(username+"'s Wallet Balance : ");
					System.out.println(us.checkBalance(username));
					System.out.println();
					System.out.print("Do you want to continue :");
					String option = sc.next();
					if(option.equalsIgnoreCase("yes"))
						{	System.out.println();
							userFunctions();
						}
					else
						System.out.println("Thanks for Visiting");
					}
				} catch (CategoryNotFoundException | BrandNotFoundException   e) {
					System.out.println(e.getMessage());
				}
		}
}
