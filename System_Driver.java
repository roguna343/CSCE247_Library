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
		
	public static Book createBook(Scanner keyboard) {
		Book ret = new Book();
		System.out.println("Please enter the following parameters to create a Book.");
		System.out.println("Title:");
		ret.setTitle(keyboard.nextLine());
		System.out.println("Author:");
		ret.setAuthor(keyboard.nextLine());
		System.out.println("Year:");
		ret.setYear(Integer.parseInt(keyboard.nextLine()));
		System.out.println("Genre:");
		ret.setGenre(keyboard.nextLine(), Integer.parseInt(keyboard.nextLine()));
		System.out.println("Description:");
		ret.setDesc(keyboard.nextLine());
		LinkedList<String> borrower = new LinkedList<>();
		System.out.println("Series:");
		ret.setSeries(keyboard.nextLine());
		double[] ratings = {0, 0};
		LinkedList<String> comments = new LinkedList<>();
		System.out.println("Pages:");
		ret.setPages(Integer.parseInt(keyboard.nextLine()));
		System.out.println("Enter all of the awards of the book:"
				+ "\n(Note enter \"done\" to move to the next parameter)");
		LinkedList<String> awards = new LinkedList<>();
		while(true) {
			if(keyboard.nextLine().equalsIgnoreCase("done")) {
				break;
			}
			awards.add(keyboard.nextLine());
		}
		System.out.println("Enter any publishers for the Book: \n(Note enter\"done\" to move on)");
		LinkedList<String> publisher = new LinkedList<>();
		while(true) {
			if(keyboard.nextLine().equalsIgnoreCase("done")) {
				break;
			}
			publisher.add(keyboard.nextLine());
		}
		System.out.println("Edition of the Book");
		ret.setEdition(keyboard.nextLine());
		System.out.println("Type of Book, Please select Hardback, Paperback, ebook, audio: ");
		ret.setType(keyboard.nextLine());
		LinkedList<String> checkedItem = new LinkedList<>();
		LinkedList<String> lookForItem = new LinkedList<>();
		System.out.println("Birthday:");
		int birthday = Integer.parseInt(keyboard.nextLine());
		System.out.println("Has Kids:");
		boolean hasKids = Boolean.parseBoolean(keyboard.nextLine());
		return ret;
	}
	public static Video createVideo(Scanner keyboard) {
		Video ret = new Video();
		System.out.println("Please enter the following parameters to create a Book.");
		System.out.println("Title:");
		ret.setTitle(keyboard.nextLine());
		System.out.println("Author:");
		ret.setAuthor(keyboard.nextLine());
		System.out.println("Year:");
		ret.setYear(Integer.parseInt(keyboard.nextLine()));
		System.out.println("Genre:");
		ret.setGenre(keyboard.nextLine(), Integer.parseInt(keyboard.nextLine()));
		System.out.println("Description:");
		ret.setDesc(keyboard.nextLine());
		LinkedList<String> borrower = new LinkedList<>();
		System.out.println("Series:");
		ret.setSeries(keyboard.nextLine());
		double[] ratings = {0, 0};
		LinkedList<String> comments = new LinkedList<>();
		System.out.println("Time:");
		ret.setTime(Integer.parseInt(keyboard.nextLine()));
		System.out.println("Enter all of the awards of the Video:"
				+ "\n(Note enter \"done\" to move to the next parameter)");
		LinkedList<String> awards = new LinkedList<>();
		while(true) {
			if(keyboard.nextLine().equalsIgnoreCase("done")) {
				break;
			}
			awards.add(keyboard.nextLine());
		}
		System.out.println("Enter any Studeios for the Video: \n(Note enter\"done\" to move on)");
		LinkedList<String> studios = new LinkedList<>();
		while(true) {
			if(keyboard.nextLine().equalsIgnoreCase("done")) {
				break;
			}
			studios.add(keyboard.nextLine());
		}
		System.out.println("Does the video have any Sister Movies?");
		ret.setHasSisterMovies(Boolean.parseBoolean(keyboard.nextLine()));
		return ret;
	}
	
	public static Magazine createMagazine(Scanner keyboard) {
		Magazine ret = new Magazine();
		System.out.println("Please enter the following parameters to create a Book.");
		System.out.println("Title:");
		ret.setTitle(keyboard.nextLine());
		System.out.println("Author:");
		ret.setAuthor(keyboard.nextLine());
		System.out.println("Year:");
		ret.setYear(Integer.parseInt(keyboard.nextLine()));
		System.out.println("Genre:");
		ret.setGenre(keyboard.nextLine(), Integer.parseInt(keyboard.nextLine()));
		System.out.println("Description:");
		ret.setDesc(keyboard.nextLine());
		LinkedList<String> borrower = new LinkedList<>();
		System.out.println("Series:");
		ret.setSeries(keyboard.nextLine());
		double[] ratings = {0, 0};
		LinkedList<String> comments = new LinkedList<>();
		System.out.println("Articles:");
		ret.setArticles(Integer.parseInt(keyboard.nextLine()));
		System.out.println("Issue month:");
		String month = keyboard.nextLine();
		System.out.println("Issue year:");
		String year = keyboard.nextLine();
		String [] issue = {month, year};
		ret.setIssue(issue);
		System.out.println("Is this magazine mature: ");
		ret.setMature(Boolean.parseBoolean(keyboard.nextLine()));
		return ret;
	}
}
