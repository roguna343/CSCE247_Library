package Library247;

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
			
		}
		
	}
}