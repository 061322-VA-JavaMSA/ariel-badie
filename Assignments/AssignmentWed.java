import java.util.Random;
import java.util.Scanner;

public class AssignmentWed {
	static Scanner scan = new Scanner(System.in);
	
	public static void menu() {
		System.out.println("Welcome to Wednesday's Menu Options!" + "\n" + 
				"Please select an option:");
		System.out.println("1 : Random Number" + "\n" + "2 : Reverse a String" + "\n"
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
				System.out.println("Please enter a string you would like to reverse: ");
				scan.nextLine();
				String response = scan.nextLine();
				StringBuffer resp = new StringBuffer(response);	
				System.out.println(resp.reverse() + "\n");
				menu();
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

