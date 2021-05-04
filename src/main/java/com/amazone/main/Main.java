package com.amazone.main;

import java.util.Scanner;

import com.amazone.account.Admin;
import com.amazone.account.User;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Admin admin = new Admin();
		User user = new User();
		
		System.out.println("User OR Admin : ");
		System.out.println();
		System.out.print("Enter your choice = ");
		String choice = sc.next();
		System.out.println();
		if(choice.equalsIgnoreCase("user"))
			user.userLogin();
		else if(choice.equalsIgnoreCase("admin"))
			admin.adminLogin();
		else
			System.out.println("Wrong input");
			
		sc.close();
	}

}
