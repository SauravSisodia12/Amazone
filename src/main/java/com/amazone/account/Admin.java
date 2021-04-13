package com.amazone.account;

import java.util.Scanner;

import com.amazone.exception.IdNotFoundException;
import com.amazone.exception.UserNotFoundException;
import com.amazone.model.ProductDetails;
import com.amazone.services.ProductServices;
import com.amazone.services.ProductServicesImple;

public class Admin {
	
	Scanner sc = new Scanner(System.in);	

	ProductServices ps = new ProductServicesImple();
	public void adminFunctions() {
	try {
		System.out.println("Admin Login");
		System.out.print("Enter Username = ");
		String userId = sc.next();
		System.out.print("Enter Password = ");
		String password = sc.next();
		int result = ps.login(userId, password);
		if(result == 1)
		{
			System.out.println();
			System.out.println("Successfully Logged in as Admin......");
			System.out.println();
			System.out.println("Enter your choice (1 to 3) to proceed = ");
			System.out.println("1. View All Products");
			System.out.println("2. Add Product");
			System.out.println("3. Update Product");
			System.out.println("4. Delete Product");
			System.out.print("Your Choice = ");
			int uchoice = sc.nextInt();
			System.out.println();
			
			if(uchoice == 1) {
				System.out.println("All Products");
				ps.viewAllProduct().stream().forEach(System.out::println);
			}
			else if(uchoice ==2) {
				System.out.println("Enter Product details : ");
				System.out.print("Enter Product Name = ");
				String name= sc.next();
				System.out.print("Enter ProductId = ");
				int productId = sc.nextInt();
				System.out.print("Enter BrandName = ");
				String brand = sc.next();
				System.out.print("Enter Category Name = ");
				String category = sc.next();
				System.out.print("Enter Price = ");
				double price = sc.nextDouble();
				
				ProductDetails productDetails = new ProductDetails(productId,name,brand,category,price);
				ps.addProduct(productDetails);
				System.out.println();
				System.out.println("Product Added");
				System.out.println();
				System.out.print("Do you want to continue :");
				String option = sc.next();
				if(option.equalsIgnoreCase("yes"))
					{	System.out.println();
						adminFunctions();
					}
				else
					System.out.println("Thanks for Visiting");
			}
			else if(uchoice == 3) {
				System.out.println("Updating Product");
				System.out.print("Enter ProductId = ");
				int productId = sc.nextInt();
				System.out.print("Enter Price to be updated = ");
				double price = sc.nextDouble();
				System.out.println();
				ps.updateProduct(productId,price);
				System.out.println();
				System.out.print("Do you want to continue :");
				String option = sc.next();
				if(option.equalsIgnoreCase("yes"))
					{	System.out.println();
						adminFunctions();
					}
				else
					System.out.println("Thanks for Visiting");
			}
			else if(uchoice == 4) {
				System.out.println("Deleting Product");
				System.out.print("Enter ProductId = ");
				int productId = sc.nextInt();
				System.out.println();
				ps.deleteProduct(productId);
				System.out.println();
				System.out.print("Do you want to continue :");
				String option = sc.next();
				if(option.equalsIgnoreCase("yes"))
					{	System.out.println();
						adminFunctions();
					}
				else
					System.out.println("Thanks for Visiting");
				}
	
					}
				} catch(UserNotFoundException | IdNotFoundException e) {
				System.err.println(e.getMessage());
			}
		}
	}