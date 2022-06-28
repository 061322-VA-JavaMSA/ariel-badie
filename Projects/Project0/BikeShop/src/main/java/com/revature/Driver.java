package com.revature;

import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.exceptions.LoginException;
import com.revature.models.Customer;
import com.revature.services.AuthService;
import com.revature.services.CustomerService;
//import com.revature.services.TaskService;
import com.revature.services.UserService;

public class Driver {

	static Scanner scan;
	static AuthService as;
	static UserService us;
//	static TaskService ts;
	static CustomerService cs;
	private static Logger log = LogManager.getLogger(Driver.class);
	
	public static void customerdash() {
		System.out.println("Hello Customer, Welcome to ShopName");
		System.out.println("Please select option:" +"\n"+"1: Shop" +"2: View Purchases" + "\n" + "3: Logout");
		
	}
	
	/**public static void login() {
		
		System.out.println("Welcome to ShopName!");
		System.out.println("Who are you?");
		System.out.println("1 : Customer" + "\n" + "2 : Employee" + "\n");
		int choice = scan.nextInt();
		if(choice <=2) {
			switch (choice) {
				case 1: 
					System.out.println("Are you:" +"\n"+ "1: A returning customer \n"+ "2: New customer");
					choice = scan.nextInt();
						switch(choice){
						case 1:
							
						}
			        break;
			     
				case 2: 
					System.out.println("Please enter a string you would like to reverse: ");
					scan.nextLine();
					String response = scan.nextLine();
					StringBuffer resp = new StringBuffer(response);	
					System.out.println(resp.reverse() + "\n");
					menu();
					break;
					
			}
			}else 
				System.out.println("Unrecognized option");
	}**/
	
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		as = new AuthService();
		us = new UserService();
		//is = new ItemService();
		cs = new CustomerService();
		
		String username = null;
		String password = null;
		
		System.out.println("Please enter username:");
		username = scan.nextLine();
		System.out.println("Please enter password:");
		password = scan.nextLine();
		
		try {
			log.info(as.login(username, password));
		} catch (LoginException e) {
			System.out.println("Invalid credentials.");
			log.error("Login exception was thrown: " + e.fillInStackTrace());
//			e.printStackTrace();
		}

		
		List<Customer> cust= cs.getCustomer();
		for(Customer u : cust) {
			System.out.println(u);
		}	
		// "1; drop table users"
		System.out.println("Create, username:");
		String uname = scan.nextLine();
		System.out.println("Create, password:");
		String pass = scan.nextLine();
		Customer custTBC = new Customer();
		custTBC.setUsername(uname);
		custTBC.setPassword(pass);
		log.info(cs.createCustomer(custTBC));
		
		//System.out.println("Retrieve tasks for which user id?");
		//int custId = Integer.parseInt(scan.nextLine());
		//List<Task> tasksForUser = ts.getTasksByUserId(userId);
		//for(Task t : tasksForUser) {
		//	System.out.println(t);
	//	}
		
		scan.close();
	}

}
