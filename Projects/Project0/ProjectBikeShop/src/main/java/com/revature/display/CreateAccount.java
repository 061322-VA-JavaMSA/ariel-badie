package com.revature.display;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.Driver;
import com.revature.models.User;
import com.revature.services.AuthService;
import com.revature.services.UserService;

public class CreateAccount {
	static Scanner scan;
	static AuthService as;
	static UserService us;
	private static Logger log = LogManager.getLogger(Driver.class);
	
	public static void createAccount() {
		
		scan = new Scanner(System.in);
		as = new AuthService();
		us = new UserService();
		
		String username = null;
		String password = null;
		
		System.out.println("Create an account for BikeShop");
		System.out.println("Create, username:");
		username = scan.nextLine();
		System.out.println("Create, password:");
		password = scan.nextLine();
		User custTBC = new User();
		custTBC.setUsername(username);
		custTBC.setPassword(password);
		custTBC.setClearance(3);
		log.info(us.createUser(custTBC));
	}
	public static void createEmpAccount() {
		
		scan = new Scanner(System.in);
		as = new AuthService();
		us = new UserService();
		
		String username = null;
		String password = null;
		
		System.out.println("Create an account for BikeShop");
		System.out.println("Create, username:");
		username = scan.nextLine();
		System.out.println("Create, password:");
		password = scan.nextLine();
		System.out.println("Create, clearance: \n 1 - Manager	2 - Employee 	3 - Customer");
		int cl = scan.nextInt();
		User custTBC = new User();
		custTBC.setUsername(username);
		custTBC.setPassword(password);
		custTBC.setClearance(cl);
		log.info(us.createUser(custTBC));
	}

}
