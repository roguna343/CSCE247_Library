package Library247;

import java.util.LinkedList;
import java.util.Scanner;

public class System_Driver {

	public static void main(String[] args) throws Exception {
		final String lu = "lib";
		final String lp = "lib";
		Adult compareWith = new Adult();
		Library lib = new Library();
		System.out.println("Date is: " + lib.getDate());
		String username = "";
		String password = "";
		Scanner keyboard = new Scanner(System.in);
		int choice = 0;
		while (true) {
			System.out.println("Welcome to Library 247! Select the index of cmd:"
					+ "\n1. Login"
					+ "\n2. Sign up"
					+ "\n3. Advance \"X\" days"
					+ "\n4. Quit");
			choice = Integer.parseInt(keyboard.nextLine());
			switch (choice) {
				case 1:
					System.out.println("Please enter the following paremeters");
					System.out.println("Username:");
					username = keyboard.nextLine();
					System.out.println("Password:");
					password = keyboard.nextLine();
					break;
				case 2:
					Adult toAdd = createAdultAccount(keyboard);
					lib.addUser(toAdd);
					lib.save();
					continue;
				case 3: //Check for future reference if correct logic
					System.out.println("Enter the number of days to advance the system by:");
					int days = Integer.parseInt(keyboard.nextLine());
					for (int a = 0; a < days; a++)
					{
						lib.setDate(lib.getDate() + 1);
						for (int b = 0; b < lib.getInv().size(); b++) {
							LinkedList<String[]> borrowers = lib.getInv().get(b).getBorrower();
							for (int c = 0; c < borrowers.size(); c++) {
								String [] temp = borrowers.get(c);
								if (temp[0].length() != 2) {
									int daysLeft = Integer.parseInt(temp[1]);
									daysLeft--;
									temp[1] = Integer.toString(daysLeft);
									if (daysLeft < 0)
									{
										for (int d = 0; d < lib.getUsr().size(); d++) {
											if (lib.getUsr().get(d).getCheckedItem().contains(lib.getInv().get(b).getTitle())) {
												double total = lib.getUsr().get(d).getFines();
												lib.getUsr().get(d).setFines(total + .25);
												break;
											}
										}
									}
								}
							}
						}
					}
					break;
				default:
					System.out.println("Exiting the program.");
					keyboard.close();
					System.exit(1);
			}
			//Librarian Commands
			if (username.equals(lu) && password.equals(lp)) {
				System.out.println("Logged in as Librarian.");
				while (true) {
					System.out.println("Select the index of cmd:"
							+ "\n1. View Patron summary"
							+ "\n2. View Inventory summary"
							+ "\n3. Add new Item"
							+ "\n4. Add copy of pre-existing Item"
							+ "\n5. Remove a book"
							+ "\n6. Enable user"
							+ "\n7. Disable user"
							+ "\n8. Log out");
					choice = Integer.parseInt(keyboard.nextLine());
					if (choice == 1) {
						lib.getPatronInfo();
					}
					else if (choice == 2) {
						lib.getInventoryInfo();
					}
					else if (choice == 3) {
						System.out.println("Select the index of the type of Item to add:"
								+ "\n1. Book"
								+ "\n2. Video"
								+ "\n3. Magazine");
						choice = Integer.parseInt(keyboard.nextLine());
						if (choice == 1) {
							Book toMake = createBook(keyboard);
							lib.addNewItem(toMake);
						}
						else if (choice == 2) {
							Video toMake = createVideo(keyboard);
							lib.addNewItem(toMake);
						}
						else if (choice == 3) {
							Magazine toMake = createMagazine(keyboard);
							lib.addNewItem(toMake);
						}
						System.out.println("Succesfully added an Item to the inventory.");
					}
					else if (choice == 4) {
						System.out.println("Enter the index of the Item you would like to add a copy of: ");
						getTitles(lib);
						int index = Integer.parseInt(keyboard.nextLine());
						lib.addCopyOfItem(lib.getInv().get(index).getTitle());
						System.out.println("Item quantity has been increased.");
					}
					else if (choice == 5) {
						System.out.println("Enter the index of the Item you would like to remove:"
								+ "\n(Note: This will only decrease the quantity of it by 1)"
								+ "\n(Note: If the Item has all copies checked out, it cannot be removed)");
						getTitles(lib);
						int index = Integer.parseInt(keyboard.nextLine());
						lib.removeItem(lib.getInv().get(index).getTitle());
						System.out.println("Item has been removed");
					}
					else if (choice == 6) {
						System.out.println("Enter the index of the patron to enable:");
						getNames(lib);
						int index = Integer.parseInt(keyboard.nextLine());
						lib.getUsr().get(index).setEnabled(true); 
						System.out.println("User is now enabled.");
					}
					else if (choice == 7) {
						System.out.println("Enter the index of the patron to disable:");
						getNames(lib);
						int index = Integer.parseInt(keyboard.nextLine());
						lib.getUsr().get(index).setEnabled(false); 
						System.out.println("User is now disabled.");
					}
					else {
						System.out.println("Logging out.");
						break;
					}
				}
			}
			//User commands
			else {
				User logged = lib.login(username, password);
				if (logged.getName().equals("No Name"))
				{
					System.out.println("Incorrect Username/Password.");
					continue;
				}
				else if (!logged.isEnabled()) {
					System.out.println("The account of those login credentials is disabled.");
					continue;
				}
				LinkedList<String> update = new LinkedList<>();
				for (int a = 0; a < logged.getLookForItem().size(); a++) {
					if (lib.isAvailable(logged.getLookForItem().get(a))) {
						System.out.println("The Item, " + logged.getLookForItem().get(a) + ", is available for check out.");
					}
					else
					{
						update.add(logged.getLookForItem().get(a));
					}
				}
				logged.setCheckedItem(update);
				lib.updateUser(logged);
				logged = lib.login(logged.getUsername(), logged.getPassword());
				while(true) {
					System.out.println("Select the index of cmd:"
							+ "\n1. Browse"
							+ "\n2. Check out"
							+ "\n3. Return"
							+ "\n4. View Profile Info"
							+ "\n5. Pay fines"
							+ "\n6. Create a child account"
							+ "\n7. Rate and comment on a Item"
							+ "\n8. Log out");
					choice = Integer.parseInt(keyboard.nextLine());
					if (choice == 1) {
						System.out.println("Enter a title or author string to do a substring search for: ");
						String key = keyboard.nextLine();
						for (int a = 0; a < lib.getInv().size(); a++) {
							if (lib.getInv().get(a).getAuthor().toLowerCase().contains(key.toLowerCase()) || lib.getInv().get(a).getTitle().toLowerCase().contains(key.toLowerCase())) {
								System.out.println(lib.getInv().get(a).getInfo());
								System.out.println("---");
							}
						}
					}
					else if (choice == 2) {
						System.out.println("Enter the index of the item you would like to check out:");
						getTitlesUser(lib);
						choice = Integer.parseInt(keyboard.nextLine());
						boolean success = false;
						LinkedList<String[]> borrowers = lib.getInv().get(choice).getBorrower();
						Book comp1 = new Book();
						Video comp2 = new Video();
						for (int a = 0; a < borrowers.size(); a++) {
							if (borrowers.get(a)[0].length() == 2) {
								success = true;
								borrowers.get(a)[0] = logged.getName();
								if (lib.getInv().get(choice).getClass() == comp1.getClass()) {
									borrowers.get(a)[1] = "21";
								}
								else if (lib.getInv().get(choice).getClass() == comp2.getClass()) {
									borrowers.get(a)[1] = "14";
								}
								else {
									borrowers.get(a)[1] = "7";
								}
								break;
							}
						}				
						if (success) {
							System.out.println("Item has been checked out");
							lib.getInv().get(choice).setBorrower(borrowers);
							LinkedList<String> checkouts = logged.getCheckedItem();
							checkouts.add(lib.getInv().get(choice).getTitle());
							logged.setCheckedItem(checkouts);
							lib.updateUser(logged);
							logged = lib.login(logged.getUsername(), logged.getPassword());
						}
						else {
							System.out.println("The Item the user tried to check out had all copies checked out."
									+ "\nUser will be notified when your book is ready.");
							LinkedList<String> lookFor = logged.getLookForItem();
							lookFor.add(lib.getInv().get(choice).getTitle());
							logged.setLookForItem(lookFor);
							lib.updateUser(logged);
							logged = lib.login(logged.getUsername(), logged.getPassword());
						}
					}
					else if (choice == 3) {
						System.out.println("Enter the index of the item you would like to return:");
						for (int a = 0; a < logged.getCheckedItem().size(); a++) {
							System.out.println(a + ". " + logged.getCheckedItem().get(a));
						}
						choice = Integer.parseInt(keyboard.nextLine());
						String toRm = logged.getCheckedItem().get(choice);
						LinkedList<String> temp = logged.getCheckedItem();
						temp.remove(choice);
						logged.setCheckedItem(temp);
						lib.updateUser(logged);
						logged = lib.login(logged.getUsername(), logged.getPassword());
						for (int a = 0; a < lib.getInv().size(); a++) {
							if (lib.getInv().get(a).getTitle().equalsIgnoreCase(toRm)) {
								LinkedList<String[]> borrower = lib.getInv().get(a).getBorrower();
								for (int b = 0; b < borrower.size(); b++) {
									if (borrower.get(b)[0].contains(logged.getName())) {
										borrower.get(b)[0] = "";
										borrower.get(b)[1] = "";
										System.out.println("Item has been returned.");
										lib.getInv().get(a).setBorrower(borrower);
										break;
									}
								}
								break;
							}
						}
					}
					else if (choice == 4) {
						System.out.println(logged.getInfo());
						System.out.println("-- -- --");
						LinkedList<String> checkouts = logged.getCheckedItem();
						for (int a = 0; a < checkouts.size(); a++) {
							for (int b = 0; b < lib.getInv().size(); b++) {
								if (checkouts.get(a).equalsIgnoreCase(lib.getInv().get(b).getTitle())) {
									LinkedList<String[]> borrowers = lib.getInv().get(b).getBorrower();
									for (int c =  0; c < borrowers.size(); c++) {
										if (borrowers.get(c)[0].equals(logged.getName())) {
											System.out.println(lib.getInv().get(c).getTitle() + " Due: " + borrowers.get(c)[0] + " days");
											break;
										}
									}
									break;
								}
							}
						}
					}
					else if (choice == 5) {
						if (logged.getClass().equals(compareWith.getClass())) {
							logged.setFines(0);
							lib.updateUser(logged);
							logged = lib.login(logged.getUsername(), logged.getPassword());
							System.out.println("User has paid off fines of " + logged.getFines());
						}
						else {
							Kid pushFrom = (Kid) logged;
							int index = 0;
							for (int a = 0; a < lib.getUsr().size(); a++)
							{
								if (pushFrom.getParent().equals(lib.getUsr().get(a).getName())) {
									index = a;
									break;
								}
							}
							lib.getUsr().get(index).setFines(lib.getUsr().get(index).getFines() + pushFrom.getFines());
							pushFrom.setFines(0);
							lib.updateUser(pushFrom);
							lib.updateUser(logged);
							logged = lib.login(logged.getUsername(), logged.getPassword());
							System.out.println("User has pushed the fines to their parent.");
						}
					}
					else if (choice == 6) {
						if (logged.getClass().equals(compareWith.getClass())) {
							Adult logA = (Adult) logged;
							logA.setHasKids(true);
							Kid toAdd = createKidAccount(keyboard, logA);
							System.out.println("Succesfully created kid account.");
							lib.addUser(toAdd);
							logged = logA;
							lib.updateUser(logged);
							logged = lib.login(logged.getUsername(), logged.getPassword());
						}
						else {
							System.out.println("Kid users are not allowed to create kid accounts.");
						}
					}
					else if (choice == 7) {
						System.out.println("Enter the index of the item you would like to rate and comment on:");
						getTitlesUser(lib);
						choice = Integer.parseInt(keyboard.nextLine());
						System.out.println("Enter the rating (0-5):");
						double rating = Double.parseDouble(keyboard.nextLine());
						System.out.println("Enter the comment: ");
						String comment = keyboard.nextLine();
						Item toRate = lib.getInv().get(choice);
						toRate.getComments().add(comment);
						toRate.updateRatings(rating);
						lib.updateItem(toRate);
						System.out.println("Succesfully updated ratings and comments of the item.");
					}
					else {
						System.out.println("Logging out.");
						break;
					}
				}
			}
			lib.save();
		}	
	}
	
	public static void getTitles(Library lib)
	{
		for (int a = 0; a < lib.getInv().size(); a++) {
			System.out.println(a + ". " + lib.getInv().get(a).getTitle());
		}
	}
	
	public static void getTitlesUser(Library lib)
	{
		for (int a = 0; a < lib.getInv().size(); a++) {
			LinkedList<String[]> borrowers = lib.getInv().get(a).getBorrower();
			int notCO = 0;
			for (int b = 0; b < borrowers.size(); b++) {
				if (borrowers.get(b)[0].length() == 2) {
					notCO++;
				}
			}
			System.out.println(a + ". " + lib.getInv().get(a).getTitle() + " || Quantity: " + notCO + "/" + lib.getInv().get(a).getQuantity());			
		}
	}
	
	
	public static void getNames(Library lib)
	{
		for (int a = 0; a < lib.getUsr().size(); a++) {
			System.out.println(a + ". " + lib.getUsr().get(a).getName());
		}
	}
	
	public static Adult createAdultAccount(Scanner keyboard) {
		System.out.println("Please enter the following parameters to create an adult account.");
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
		Adult toAdd = new Adult(name, age, username, password, checkedItem, lookForItem, birthday, 0, true, hasKids);
		return toAdd;
	}
	
	public static Kid createKidAccount(Scanner keyboard, Adult parent) {
		System.out.println("Please enter the following parameters to create a kid account.");
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
		Kid toAdd = new Kid(name, age, username, password, checkedItem, lookForItem, birthday, 0, true, parent.getName());
		return toAdd;
	}
	
	public static Book createBook(Scanner keyboard) {
		Book ret = new Book();
		System.out.println("Please enter the following parameters to of the Book.");
		System.out.println("Title:");
		ret.setTitle(keyboard.nextLine());
		System.out.println("Author:");
		ret.setAuthor(keyboard.nextLine());
		System.out.println("Year:");
		ret.setYear(Integer.parseInt(keyboard.nextLine()));
		System.out.println("Genre 1:");
		ret.setGenre(keyboard.nextLine(), 0);
		System.out.println("Genre 2:");
		ret.setGenre(keyboard.nextLine(), 1);
		System.out.println("Description:");
		ret.setDesc(keyboard.nextLine());
		LinkedList<String[]> borrower = new LinkedList<>();
		ret.setBorrower(borrower);
		System.out.println("Series:");
		ret.setSeries(keyboard.nextLine());
		double[] ratings = {0, 0};
		ret.setRatings(ratings);
		LinkedList<String> comments = new LinkedList<>();
		ret.setComments(comments);
		System.out.println("Pages:");
		ret.setPages(Integer.parseInt(keyboard.nextLine()));
		System.out.println("Enter all of the awards of the book:"
				+ "\n(Note enter \"done\" to move to the next parameter)");
		LinkedList<String> awards = new LinkedList<>();
		while(true) {
			String toAdd = keyboard.nextLine();
			if(toAdd.equalsIgnoreCase("done")) {
				break;
			}
			awards.add(toAdd);
		}
		System.out.println("Enter all of the publishers of the book:"
				+ "\n(Note enter \"done\" to move to the next parameter)");
		LinkedList<String> publisher = new LinkedList<>();
		while(true) {
			String toAdd = keyboard.nextLine();
			if(toAdd.equalsIgnoreCase("done")) {
				break;
			}
			publisher.add(toAdd);
		}
		System.out.println("Edition of the Book");
		ret.setEdition(keyboard.nextLine());
		System.out.println("Type of Book: (Hardback, Paperback, ebook, audio)");
		ret.setType(keyboard.nextLine());
		return ret;
	}
	
	public static Video createVideo(Scanner keyboard) {
		Video ret = new Video();
		System.out.println("Please enter the following parameters of the Video.");
		System.out.println("Title:");
		ret.setTitle(keyboard.nextLine());
		System.out.println("Author:");
		ret.setAuthor(keyboard.nextLine());
		System.out.println("Year:");
		ret.setYear(Integer.parseInt(keyboard.nextLine()));
		System.out.println("Genre 1:");
		ret.setGenre(keyboard.nextLine(), 0);
		System.out.println("Genre 2:");
		ret.setGenre(keyboard.nextLine(), 1);
		System.out.println("Description:");
		ret.setDesc(keyboard.nextLine());
		LinkedList<String[]> borrower = new LinkedList<>();
		ret.setBorrower(borrower);
		System.out.println("Series:");
		ret.setSeries(keyboard.nextLine());
		double[] ratings = {0, 0};
		ret.setRatings(ratings);
		LinkedList<String> comments = new LinkedList<>();
		ret.setComments(comments);
		System.out.println("Time:");
		ret.setTime(Integer.parseInt(keyboard.nextLine()));
		System.out.println("Enter all of the awards of the Video:"
				+ "\n(Note enter \"done\" to move to the next parameter)");
		LinkedList<String> awards = new LinkedList<>();
		while(true) {
			String award = keyboard.nextLine();
			if(award.equalsIgnoreCase("done")) {
				break;
			}
			awards.add(award);
		}
		System.out.println("Enter any Studios for the Video:"
				+ "\n(Note enter\"done\" to move on to the next parameter)");
		LinkedList<String> studios = new LinkedList<>();
		while(true) {
			String studio = keyboard.nextLine();
			if(studio.equalsIgnoreCase("done")) {
				break;
			}
			studios.add(studio);
		}
		System.out.println("SisterMovies: (true/false)");
		ret.setHasSisterMovies(Boolean.parseBoolean(keyboard.nextLine()));
		return ret;
	}
	
	public static Magazine createMagazine(Scanner keyboard) {
		Magazine ret = new Magazine();
		System.out.println("Please enter the following parameters to create a Magazine.");
		System.out.println("Title:");
		ret.setTitle(keyboard.nextLine());
		System.out.println("Author:");
		ret.setAuthor(keyboard.nextLine());
		System.out.println("Year:");
		ret.setYear(Integer.parseInt(keyboard.nextLine()));
		System.out.println("Genre 1:");
		ret.setGenre(keyboard.nextLine(), 0);
		System.out.println("Genre 2:");
		ret.setGenre(keyboard.nextLine(), 1);
		System.out.println("Description:");
		ret.setDesc(keyboard.nextLine());
		LinkedList<String[]> borrower = new LinkedList<>();
		ret.setBorrower(borrower);
		System.out.println("Series:");
		ret.setSeries(keyboard.nextLine());
		double[] ratings = {0, 0};
		ret.setRatings(ratings);
		LinkedList<String> comments = new LinkedList<>();
		ret.setComments(comments);
		System.out.println("Articles:");
		ret.setArticles(Integer.parseInt(keyboard.nextLine()));
		System.out.println("Issue month:");
		String month = keyboard.nextLine();
		System.out.println("Issue year:");
		String year = keyboard.nextLine();
		String [] issue = {month, year};
		ret.setIssue(issue);
		System.out.println("Mature: (true/false)");
		ret.setMature(Boolean.parseBoolean(keyboard.nextLine()));
		return ret;
	}
}

