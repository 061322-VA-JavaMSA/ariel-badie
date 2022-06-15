
import java.util.Random;
import java.util.Scanner;

public class AssignmentWed {
	static Scanner scan = new Scanner(System.in);
	
	
	public static void menu() {
		System.out.println("Welcome to Wendesday Menu Options!" + "\n" + 
				"Please select an option:");
		System.out.println("1 : Random Number" + "\n" + "2 : Reverse a string" + "\n"
				+ "3 : Exit Menu");
		
		int opt = scan.nextInt();
		
		switch (opt) {
			case 1: 
				Random number = new Random();
		        int rand = number.nextInt(1000);
		        System.out.println(rand +"\n");
		        menu();
		        break;
		     
			case 2: 
				System.out.println("Please enter a string you would like to reverse:");
				String response = scan.nextLine();
				StringBuffer resp = new StringBuffer(response);	
				System.out.println(resp.reverse());
				break;
				
			case 3: 
				System.out.println("Goodbye!");
				break;

		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		menu();
	}

}
