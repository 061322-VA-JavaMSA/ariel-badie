package com.revature.display;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.Driver;
//import com.revature.daos.UserDAO;
//import com.revature.daos.UserPostgres;
import com.revature.exceptions.LoginException;
//import com.revature.models.User;
import com.revature.services.AuthService;
import com.revature.services.UserService;

public class LoginScreen {

	static Scanner scan;
	static AuthService as;
	static UserService us;
	private static Logger log = LogManager.getLogger(Driver.class);
	
	public static void welcome() {
		scan = new Scanner(System.in);
		as = new AuthService();
		us = new UserService();
			int opt;
			int status;
			
			System.out.println("\nHello!");
			System.out.println("Welcome to the BikeShop!");
			System.out.println("Select an option: \n 1: Login \n 2: Create an account");
			System.out.print(".:");
			opt = scan.nextInt();
			
			if(opt == 1) {
				LoginScreen.userLogin();
				
			}else if (opt == 2) {
				System.out.println("Are you... \n 1: A Customer \n 2: An Employee");
				System.out.print(".:");
				status = scan.nextInt();
				if(status == 1) {
					CreateAccount.createAccount();
					welcome();
				}
				else
					System.out.println("Please talk to manager for credentials");
				welcome();
			}else {
				System.out.println("Unrecognized Option Selected, Try Again");
				welcome();
		}
	}
	
	
	public static void userLogin() {
		scan = new Scanner(System.in);
		as = new AuthService();
		us = new UserService();
		
	//	User use = new User();
	//	UserDAO udao = new UserPostgres();
		String username = null;
		String password = null;
		
		System.out.println("Login to BikeShop");
		System.out.println("Please enter username:");
		username = scan.nextLine();
		System.out.println("Please enter password:");
		password = scan.nextLine();
		
		try {
			log.info(as.login(username, password));
				System.out.println("Here.");
		} catch (LoginException e) {
			System.out.println("Invalid credentials.");
			log.error("Login exception was thrown: " + e.fillInStackTrace());
		}
		

	}
}
