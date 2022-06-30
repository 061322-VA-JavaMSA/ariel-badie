package com.revature.display;

import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.Driver;
import com.revature.daos.ItemDAO;
import com.revature.daos.ItemPostgres;
import com.revature.daos.UserDAO;
import com.revature.daos.UserPostgres;
import com.revature.models.Item;
import com.revature.models.Offer;
import com.revature.models.User;
import com.revature.services.AuthService;
import com.revature.services.ItemService;
import com.revature.services.OfferService;
import com.revature.services.UserService;

public class CustomerDash {
	
	static Scanner scan;
	static AuthService as;
	static UserService us;
	static ItemService is;
	static OfferService os;
	private static Logger log = LogManager.getLogger(Driver.class);

	
	public static void shop() {
		
		scan = new Scanner(System.in);
		as = new AuthService();
		us = new UserService();
		is = new ItemService();
		int itemID;
		
		//Item item = new Item();
		ItemDAO itd = new ItemPostgres();
		User use = new User();
		UserDAO udao = new UserPostgres();
		
		System.out.println("Here are the available items:");
		List<Item> item= is.getItem();
		for(Item i : item) {
			if(i.getStatus() == 1) {
				System.out.println(i);
			}
		}	
	}
	
	public static void viewItemOwned() {
		
		scan = new Scanner(System.in);
		as = new AuthService();
		us = new UserService();
		is = new ItemService();
		//int custID;

		//Item item = new Item();
		ItemDAO itd = new ItemPostgres();
		User use = new User();
		UserDAO udao = new UserPostgres();
		
		System.out.println("Confirm Account With ID #: ");
		System.out.print(".:");
		int custID = scan.nextInt();
		//itd.retrieveItemByOwnedId(custID);
		
		List<Item> item= is.getItem();
		for(Item i : item) {
			if(i.getOwnedBy() == custID) {
				System.out.println(i);
			}
				
		}	
		
	}
	
	public static void createOffer() {
		scan = new Scanner(System.in);
		as = new AuthService();
		us = new UserService();
		is = new ItemService();
		os = new OfferService();
		
		int cust;
		int item;
		float off;
		int status;
		
		System.out.println("Please enter the Item's ID you would like to make an offer on: ");
		System.out.print(".:");
		item = scan.nextInt();
		System.out.println("Please enter the amount you would like to offer: ");
		System.out.print(".:");
		off = scan.nextFloat();
		System.out.println("Please confirm your ID #: ");
		System.out.print(".:");
		cust = scan.nextInt();
		
		Offer offObj = new Offer();
		offObj.setItemID(item);
		offObj.setAmount(off);
		offObj.setCustID(cust);
		offObj.setStatus(0);
		log.info(os.makeOffer(offObj));
	}
	
	public static void viewOffers() {
		
	}
	
	public static void custView() {
		
		scan = new Scanner(System.in);
		as = new AuthService();
		us = new UserService();
		is = new ItemService();
		
		Item item = new Item();
		ItemDAO itd = new ItemPostgres();
		User use = new User();
		UserDAO udao = new UserPostgres();
		int opt;
		int custID;
		
		System.out.println("Hello Customer!");
		System.out.println("Select what you would like to do:");
		System.out.println("1: Shop");
		System.out.println("2: View Items Owned");
		System.out.println("3: Logout");
		System.out.print(".:");
		opt = scan.nextInt();
		if (opt == 1) {
			shop();
			createOffer();
			custView();
		}else if (opt ==2) {
			viewItemOwned();
			custView();
		}else if (opt == 3) {
			System.out.println("Goodbye");
			LoginScreen.welcome();
		}
		
	}

}
