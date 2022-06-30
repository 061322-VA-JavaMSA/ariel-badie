package com.revature.display;

import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.Driver;
import com.revature.models.Item;
import com.revature.services.AuthService;
import com.revature.services.ItemService;
import com.revature.services.UserService;

public class CustomerDash {
	
	static Scanner scan;
	static AuthService as;
	static UserService us;
	static ItemService is;
	private static Logger log = LogManager.getLogger(Driver.class);

	
	public static void shop() {
		
		scan = new Scanner(System.in);
		as = new AuthService();
		us = new UserService();
		is = new ItemService();
		int itemID;
		
		System.out.println("Here are the available items:");
		List<Item> item= is.getItem();
		for(Item i : item) {
		System.out.println(i);
		}	
		System.out.println("Please enter the Item's ID you would like to make an offer on: ");
		System.out.print(".:");
		itemID = scan.nextInt();
	}
	
	public static void custView() {
		
		int opt;
		
		System.out.println("Hello Customer!");
		System.out.println("Select what you would like to do:");
		System.out.println("1: Shop");
		System.out.println("2: View Items Owned");
		System.out.println("3: View Account Balance");
		System.out.println("4: Logout");
		System.out.print(".:");
		opt = scan.nextInt();
		if (opt == 1) {
			
			custView();
		}else if (opt ==2) {
			List<Item> item= is.getItem();
			for(Item i : item) {
			System.out.println(i);
			}	
			custView();
		}else if (opt == 3) {
			System.out.println("Account Balance");
		}else if (opt == 4) {
			System.out.println("Goodbye");
			LoginScreen.welcome();
		}
		
	}

}
