package Library247;

import java.util.LinkedList;
import java.util.Scanner;

public class System_Driver {

	public static void main(String[] args) throws Exception {
		//final String mod = "java2easy";
		//final String lbrP = "c++2hard";
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
					break;
				case 2:
					System.out.println("Please enter the following parameters to create an account:");
					System.out.println("Name");
					String name = keyboard.nextLine();
					System.out.println("Age:");
					int age = Integer.parseInt(keyboard.nextLine());
					System.out.println("Username:");
					username = keyboard.nextLine();
					System.out.println("Password:");
					password = keyboard.nextLine();
					LinkedList<String> checkedItem = new LinkedList<>();
					LinkedList<String> lookForItem = new LinkedList<>();
					System.out.println("Birthday:");
					int birthday = Integer.parseInt(keyboard.nextLine());
					System.out.println("Has Kids:");
					boolean hasKids = Boolean.parseBoolean(keyboard.nextLine());
					Adult toAdd = new Adult(name, age, username, password, checkedItem, lookForItem, birthday, 0, true, "", hasKids);
					lib.addUser(toAdd);
					lib.save();
					continue;
				default:
					System.out.println("Exiting the program.");
					System.exit(1);
					break;
			}
		}
		
	}
}