package Library247;

import java.util.LinkedList;
import java.util.Scanner;

public class System_Driver {

	public static void main(String[] args) throws Exception {
		final String lu = "java2easy";
		final String lp = "c++2hard";
		//Adult sA = new Adult();
		//Kid sK = new Kid();
		Library lib = new Library();
		String username = "";
		String password = "";
		Scanner keyboard = new Scanner(System.in);
		int choice = 0;
		while (true) {
			System.out.println("Welcome to Library 247! Select the index of your desired action:"
					+ "\n1. Login"
					+ "\n2. Sign up"
					+ "\n3. Quit");
			choice = Integer.parseInt(keyboard.nextLine());
			switch (choice) {
				case 1:
					System.out.println("Please enter the following paremeters.");
					username = keyboard.nextLine();
					System.out.println("Username:");
					password = keyboard.nextLine();
					break;
				case 2:
					Adult toAdd = createAdultAccount(keyboard);
					lib.addUser(toAdd);
					lib.save();
					continue;
				default:
					System.out.println("Exiting the program.");
					System.exit(1);
			}
			//Librarian Commands
			if (username.equals(lu) && username.equals(lp)) {
				System.out.println("Logged in as Librarian.");
				while (true) {
					System.out.println("Select the index of cmd:"
							+ "\n1. View Patron summary"
							+ "\n2. View Inventory summary"
							+ "\n3. Add new Item"
							+ "\n4. Add copy of pre-existing Item"
							+ "\n5. Remove a book"
							+ "\n6. Logout");
					choice = Integer.parseInt(keyboard.nextLine());
					if (choice == 1) {
						
					}
					else if (choice == 2) {
						
					}
					else if (choice == 3) {
						
					}
					else if (choice == 4) {
						
					}
					else if (choice == 5) {
						
					}
					else {
						
					}
					
				}
			}
			//User commands
			else {
				
			}
		}	
	}
	
	public static Adult createAdultAccount(Scanner keyboard) {
		System.out.println("Please enter the following parameters to create an account.");
		System.out.println("Name:");
		String name = keyboard.nextLine();
		System.out.println("Age:");
		int age = Integer.parseInt(keyboard.nextLine());
		System.out.println("Username:");
		String username = keyboard.nextLine();
		System.out.println("Password:");
		String password = keyboard.nextLine();
		LinkedList<String> checkedItem = new LinkedList<>();
		LinkedList<String> lookForItem = new LinkedList<>();
		System.out.println("Birthday:");
		int birthday = Integer.parseInt(keyboard.nextLine());
		System.out.println("Has Kids:");
		boolean hasKids = Boolean.parseBoolean(keyboard.nextLine());
		Adult toAdd = new Adult(name, age, username, password, checkedItem, lookForItem, birthday, 0, true, "", hasKids);
		return toAdd;
	}
		
	public static Kid createKidAccount(Scanner keyboard) {
		System.out.println("Please enter the following parameters to create an account.");
		System.out.println("Name:");
		String name = keyboard.nextLine();
		System.out.println("Age:");
		int age = Integer.parseInt(keyboard.nextLine());
		System.out.println("Username:");
		String username = keyboard.nextLine();
		System.out.println("Password:");
		String password = keyboard.nextLine();
		LinkedList<String> checkedItem = new LinkedList<>();
		LinkedList<String> lookForItem = new LinkedList<>();
		System.out.println("Birthday:");
		int birthday = Integer.parseInt(keyboard.nextLine());
		System.out.println("Has Kids:");
		boolean hasKids = Boolean.parseBoolean(keyboard.nextLine());
		Kid toAdd = new Kid(name, age, username, password, checkedItem, lookForItem, birthday, 0, 
				true, "", Adult.class.getName());
		return toAdd;
	}
}
