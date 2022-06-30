package com.revature;

//import java.util.List;
//import java.util.Random;
import java.util.Scanner;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

//import com.revature.exceptions.LoginException;
//import com.revature.models.User;
import com.revature.services.AuthService;
import com.revature.services.UserService;
import com.revature.display.*;

public class Driver {
	
	static Scanner scan;
	static AuthService as;
	static UserService us;
	//private static Logger log = LogManager.getLogger(Driver.class);
	
	//static String username = null;
	//static String password = null;
	/**public static void customerdash() {
		System.out.println("Hello Customer, Welcome to ShopName");
		System.out.println("Please select option:" +"\n"+"1: Shop" +"2: View Purchases" + "\n" + "3: Logout");
		
	}**/
	

	
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		as = new AuthService();
		us = new UserService();
		
		//	String username = null;
		//	String password = null;
		//	int opt;
		//	int status;
			
			//LoginScreen.welcome();
			EmployeeDash.empView();
			//ManagerDash.managView();
			
		
		//System.out.println("Retrieve tasks for which user id?");
		//int custId = Integer.parseInt(scan.nextLine());
		//List<Task> tasksForUser = ts.getTasksByUserId(userId);
		//for(Task t : tasksForUser) {
		//	System.out.println(t);
	//	}
		
		scan.close();
	}

}