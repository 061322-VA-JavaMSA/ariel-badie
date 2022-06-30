package com.revature.display;

import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.Driver;
import com.revature.daos.ItemDAO;
import com.revature.daos.ItemPostgres;
import com.revature.daos.OfferDAO;
import com.revature.daos.OfferPostgres;
import com.revature.daos.UserDAO;
import com.revature.daos.UserPostgres;
import com.revature.services.AuthService;
import com.revature.services.UserService;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.Driver;
import com.revature.models.User;
import com.revature.models.Item;
import com.revature.models.Offer;
import com.revature.services.AuthService;
import com.revature.services.UserService;
import com.revature.services.ItemService;
import com.revature.services.OfferService;
//import com.revature.services.

public class EmployeeDash {
		static Scanner scan;
		static AuthService as;
		static UserService us;
		static ItemService is;
		static OfferService os;
		private static Logger log = LogManager.getLogger(Driver.class);
	
		
		public static void addItem() {
			
			scan = new Scanner(System.in);
			as = new AuthService();
			us = new UserService();
			is = new ItemService();
			User use = new User();
			UserDAO ud = new UserPostgres();
			
			int id;
			String itemName = null;
			String itemDesc = null;
			int itemOffer;
			User addedBy = null;
			User ownedBy = null;
			int status;
			int emID;
			
			System.out.println("Add new Item for BikeShop");
			System.out.println("Item name:");
			itemName = scan.nextLine();
			System.out.println("Item description:");
			itemDesc = scan.nextLine();
			System.out.println("Item Min Offer:");
			itemOffer = scan.nextInt();
					
			Item itemTBC = new Item();
			itemTBC.setItemName(itemName);
			itemTBC.setItemDesc(itemDesc);
			itemTBC.setItemOffer(itemOffer);
			itemTBC.setStatus(1);
			itemTBC.setOwnedBy(1);
			log.info(is.createItem(itemTBC));
		
	}
	
		public static void reviewOffers() {
			
			scan = new Scanner(System.in);
			as = new AuthService();
			us = new UserService();
			is = new ItemService();
			os = new OfferService();
			int opt;
			int emID;
			int itemID;
			int offerID;
			int decide;
			
			OfferDAO odao = new OfferPostgres();
			
			System.out.println("Review Offers");
			List<Offer> offer= os.getOffer();
			for(Offer o : offer) {
			System.out.println(o);
			}	
			System.out.println("Please enter the Offer's ID you would like to decide: ");
			System.out.print(".:");
			offerID = scan.nextInt();
			//log.info(odao.acceptOffer(offerID));
			System.out.println("Please enter your decision \n 1: Reject \n 2: Accept ");
			System.out.print(".:");
			decide = scan.nextInt();
			if (decide == 1 ) {
				odao.rejectOffer(offerID);
			}else if (decide == 2) {
				odao.acceptOffer(offerID);
			}else {
				System.out.println("Unrecognized input, try again");
				reviewOffers();
			}
		}
		
	public static void empView() {
		
		scan = new Scanner(System.in);
		as = new AuthService();
		us = new UserService();
		is = new ItemService();
		os = new OfferService();
		int opt;
		int emID;
		int itemID;
		int offerID;
	//	User use = new User();
		UserDAO udao = new UserPostgres();
		ItemDAO idao = new ItemPostgres();
		
		System.out.println("Hello Employee!");
		System.out.println("Select what you would like to do:");
		System.out.println("1: Add Items");
		System.out.println("2: Delete Items");
		System.out.println("3: Review Offers");
		System.out.println("4: Logout");
		System.out.print(".:");
		opt = scan.nextInt();
		if (opt == 1) {
			addItem();
			empView();
		}else if (opt ==2) {
			List<Item> item= is.getItem();
			for(Item i : item) {
			System.out.println(i);
			}	
			System.out.println("Please enter the Item's ID you would like to delete: ");
			System.out.print(".:");
			itemID = scan.nextInt();
			log.info(idao.deleteItemById(itemID));
			empView();
		}else if (opt == 3) {
			reviewOffers();
			empView();
		}else if (opt == 4) {
			System.out.println("Goodbye");
			LoginScreen.welcome();
		}
	}

}
