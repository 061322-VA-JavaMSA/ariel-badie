package com.revature.display;

import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.Driver;
import com.revature.daos.UserDAO;
import com.revature.daos.UserPostgres;
import com.revature.models.User;
import com.revature.services.AuthService;
import com.revature.services.UserService;

public class ManagerDash {

	static Scanner scan;
	static AuthService as;
	static UserService us;
	private static Logger log = LogManager.getLogger(Driver.class);
	
	
	public static void managView() {
		
		scan = new Scanner(System.in);
		as = new AuthService();
		us = new UserService();
		int opt;
		int emID;
	//	User use = new User();
		UserDAO udao = new UserPostgres();
		
		System.out.println("Hello Manager!");
		System.out.println("Select what you would like to do:");
		System.out.println("1: Register Employees");
		System.out.println("2: Fire Employees");
		System.out.println("3: View all activity");
		System.out.println("4: Logout");
		System.out.print(".:");
		opt = scan.nextInt();
		
		if (opt == 1) {
			CreateAccount.createEmpAccount();
			managView();
		}else if (opt == 2) {
			List<User> user= us.getUsers();
				for(User u : user) {
				System.out.println(u);
				}	
				System.out.println("Please enter the User's ID you would like to delete: ");
				System.out.print(".:");
				emID = scan.nextInt();
				log.info(udao.deleteUserById(emID));
			managView();
		}else if (opt == 3) {
			System.out.println("Working on it");
		}else if (opt == 4) {
			System.out.println("Goodbye");
			LoginScreen.welcome();
		}else {
			System.out.println("Option not recognized, try again");
			managView();
		}


	}
}
