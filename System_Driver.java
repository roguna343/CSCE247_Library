package Library247;

import java.util.LinkedList;
import java.util.Scanner;

public class System_Driver {

	public static void main(String[] args) {
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
			//Login prompt for upon login or continue of initial while loop
			System.out.println("Welcome to Library 247! Select the index of cmd:"
					+ "\n1. Login"
					+ "\n2. Sign up"
					+ "\n3. Advance \"X\" days"
					+ "\n4. Quit");
			
			/**
			 * Keyboard is always going to be nextLine to avoid bug where nextInt() -> nextLine() causes a bug
			 * Issue is easy to fix with simple blank fire, but if a while loop commits "continue", a blank fire
			 * not be necessarily appropriate.
			 */
			
			choice = Integer.parseInt(keyboard.nextLine());
			switch (choice) {
				case 1:
					//Parameters to login
					System.out.println("Please enter the following parameters");
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
				case 3: //Advances the days by 1 and removes a day for how long the users can hold onto books
					
					/**
					 * JSON is a pain with reading from a file. Its picks up " characters somehow, causing
					 * strings when checked if equal to give the wrong results. This is why there are .replace(..., ...)
					 * from place to place
					 */
					System.out.println("Enter the number of days to advance the system by:");
					int days = Integer.parseInt(keyboard.nextLine());
					for (int a = 0; a < days; a++)
					{
						lib.setDate(lib.getDate() + 1);
						for (int b = 0; b < lib.getInv().size(); b++) {
							Item ioi = lib.getInv().get(b);
							LinkedList<String[]> borrower = ioi.getBorrower();
							for (int c = 0; c < borrower.size(); c++) {
								String[] temp = borrower.get(c);
								if (!temp[0].replace("\"", "").equals("")) {
									int temp2 = Integer.parseInt(temp[1].replace("\"", ""));
									temp2--;
									temp[1] = Integer.toString(temp2);
									if (temp2 < 0) //Logic here addresses fines when necessary
									{
										for (int d = 0; d < lib.getUsr().size(); d++)
										{
											User uoi = lib.getUsr().get(d);
											String name = uoi.getName();
											if (temp[0].contains(name)) {
												uoi.setFines(uoi.getFines() + .25);
											}
										}
									}
									String temp3[] = new String[2];
									temp3[0] = temp[0];
									temp3[1] = temp[1];
									borrower.set(c, temp3);
								}
								ioi.setBorrower(borrower);
								lib.updateItem(ioi);
							}
						}
						lib.save();
						continue;
					}
					System.out.println("Date is: " + lib.getDate());
					break;
				default:
					System.out.println("Exiting the program.");
					keyboard.close();
					System.exit(1);
			}
			//Librarian Commands
			if (username.equals(lu) && password.equals(lp)) {
				System.out.println("Logged in as Librarian.");
				while(true) {
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
						lib.save();
					}
					else if (choice == 4) { //Adds a copy of item
						System.out.println("Enter the index of the Item you would like to add a copy of: ");
						getTitles(lib);
						int index = Integer.parseInt(keyboard.nextLine());
						lib.addCopyOfItem(lib.getInv().get(index).getTitle());
						System.out.println("Item quantity has been increased.");
						lib.save();
					}
					else if (choice == 5) { //Removes copies of items, but removes completely if there only exists one copy overall
						System.out.println("Enter the index of the Item you would like to remove:"
								+ "\n(Note: This will only decrease the quantity of it by 1 each time)"
								+ "\n(Note: If the Item has all copies checked out, it cannot be removed)");
						getTitles(lib);
						int index = Integer.parseInt(keyboard.nextLine());
						lib.removeItem(lib.getInv().get(index).getTitle());
						System.out.println("Item has been removed");
						lib.save();
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
					else { //Goes back to primary prompt
						System.out.println("Logging out.");
						break;
					}
				}
			}
			//User commands
			else {
				User logged = lib.login(username, password);
				if (logged.getName().equals("No name")) {
					System.out.println("Incorrect login credentials.");
					continue;
				}
				else if (!logged.isEnabled()) {
					System.out.println("The user account is disabled.");
					continue;
				}
				if (logged.getCheckedItem().size() == 1 && logged.getCheckedItem().get(0).length() == 0) {
					LinkedList<String> checkedItem = new LinkedList<>();
					logged.setCheckedItem(checkedItem);
				}
				if (logged.getLookForItem().size() == 1 && logged.getLookForItem().get(0).length() == 0) {
					LinkedList<String> lookFor = new LinkedList<>();
					logged.setLookForItem(lookFor);
				}
				lib.updateUser(logged);
				//Notifications
				if (logged.getLookForItem().size() != 0) {
					LinkedList<String> booksNotFound = new LinkedList<>();
					for (int a = 0; a < logged.getLookForItem().size(); a++) {
						if (lib.isAvailable(logged.getLookForItem().get(a))) {
							System.out.println(logged.getLookForItem().get(a) + " is available.");
						}
						else
						{
							System.out.println(logged.getLookForItem().get(a) + " is not yet available.");
							booksNotFound.add(logged.getLookForItem().get(a));
						}
					}
					logged.setLookForItem(booksNotFound);
					lib.updateUser(logged);
				}
				while (true) {
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
								System.out.println("-- -- --");
								System.out.println(lib.getInv().get(a).getInfo());
								System.out.println("-- -- --");
							}
						}
					}
					else if (choice == 2) {
						if (logged.getFines() != 0) { //User cannot check out if fines are due
							System.out.println("User must pay fines first.");
						}
						else {
							System.out.println("Select the index of desired Item to check out:"
									+ "\n(Note: If the Item has not copies remaining, User will be notified of availability upon next login of availability)");
							getTitlesUser(lib);
							choice = Integer.parseInt(keyboard.nextLine());
							Item ioi = lib.getInv().get(choice);
							String title = ioi.getTitle();
							String days = "0";
							try {
								
								/**
								 * Different types of medium have different days for how long they can be checked out
								 */
								
								if (ioi.getJSON().toString().contains("pages")) {
									days = "21";
								}
								else if (ioi.getJSON().toString().contains("length")) {
									days = "14";
								}
								else {
									days = "7";
								}
							}
							catch (Exception e) {
								System.out.println("Error checking out.");
								e.printStackTrace();
							}
							if (lib.isAvailable(title)) {
								LinkedList<String[]> borrowers = ioi.getBorrower();
								for (int a = 0; a < borrowers.size(); a++) {
									String[] temp = borrowers.get(a);
									if (temp[0].replace("\"", "") != "") {
										System.out.println("Item is checked out.");
										temp[0] = logged.getName();
										temp[1] = days;
										borrowers.set(a, temp);
										ioi.setBorrower(borrowers);
										lib.updateItem(ioi);
										LinkedList<String> checkOut = logged.getCheckedItem();
										checkOut.add(ioi.getTitle());
										logged.setCheckedItem(checkOut);
										lib.updateUser(logged);
										break;
									}
								}
							}
							else {
								System.out.println("Item is not available for check out.  User will be notified of availability upon next login of availability.");
								LinkedList<String> lookFor = logged.getLookForItem();
								lookFor.add(title);
								logged.setLookForItem(lookFor);
								lib.updateUser(logged);
							}
						}
					}
					else if (choice == 3) { //Return items
						System.out.println("Select the index of item to return");
						for (int a = 0; a < logged.getCheckedItem().size(); a++) {
							System.out.println(a + ". " + logged.getCheckedItem().get(a).replace("\"", ""));
						}
						choice = Integer.parseInt(keyboard.nextLine());
						String toRm = logged.getCheckedItem().get(choice).replace("\"", "");
						LinkedList<String> temp = logged.getCheckedItem();
						temp.remove(choice);
						logged.setCheckedItem(temp);
						lib.updateUser(logged);
						for (int a = 0; a < lib.getInv().size(); a++) {
							if (lib.getInv().get(a).getTitle().equalsIgnoreCase(toRm)) {
								LinkedList<String[]> borrower = lib.getInv().get(a).getBorrower();
								for (int b = 0; b < borrower.size(); b++) {
									if (borrower.get(b)[0].contains(logged.getName())) {
										String[] temp2 = {"\"\"", "\"\""};
										borrower.set(b, temp2);
										System.out.println("Item has been returned.");
										Item ioi = lib.getInv().get(a);
										ioi.setBorrower(borrower);
										lib.updateItem(ioi);
										break;
									}
								}
								break;
							}
						}
					}
					else if (choice == 4) { //Displays the information that belongs to the user
						System.out.println(logged.getInfo());
						System.out.println("-- -- --");
						LinkedList<String> checkouts = logged.getCheckedItem();
						for (int a = 0; a < checkouts.size(); a++) {
							String title = checkouts.get(a);
							for (int b = 0; b < lib.getInv().size(); b++) {
								Item ioi = lib.getInv().get(b);
								for (int c = 0; c < ioi.getBorrower().size(); c++) {
									if (ioi.getTitle().equals(title.replace("\"", ""))) {
										System.out.println(title.replace("\"", "") + " || " + ioi.getBorrower().get(c)[1].replace("\"", "") + " days left");
										break;
									}
								}
							}
						}
					}
					else if (choice == 5) {
						
						/**
						 * Kids and adults have different behaviors when it comes to treating the fines. Adults will
						 * pay off the fine, kids push the fine to their parent
						 */
						
						if (logged.getClass().equals(compareWith.getClass())) {
							System.out.println("User has paid off fines of $" + logged.getFines());
							logged.setFines(0);
							lib.updateUser(logged);
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
						}
						else {
							System.out.println("User is kid, therefore, user is not allowed to create kid accounts.");
						}
					}
					else if (choice == 7) { //Comment feature, shows the comments of the book being commented on
						System.out.println("Please select the index of the Item to rate/comment:");
						getTitles(lib);
						choice = Integer.parseInt(keyboard.nextLine());
						System.out.println("Other patron ratings/comments:");
						Item ioi = lib.getInv().get(choice);
						LinkedList<String> comments = ioi.getComments();
						getRatingsComments(lib, choice);
						System.out.println("Ratings: (0-5)");
						double ratings = Double.parseDouble(keyboard.nextLine());
						System.out.println("Comment:");
						String comment = keyboard.nextLine();
						ioi.updateRatings(ratings);
						if (!comments.getFirst().equals("\"\"")) {
							comments.add(comment);
						}
						else {
							comments.set(0, comment);
						}
						ioi.setComments(comments);
						lib.updateItem(ioi);
					}
					else {
						System.out.println("Logging out.");
						break;
					}
				}
			}
			lib.save(); //When the user logs out, the .json files will be written with the data updated
		}	
	}
	
	/**
	 * These are all methods made to make the console interface easier since the code was very repetitive. First half are for console display,
	 * others half work with the console to create objects. These help shorted the code alot.
	 */
	
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
				if (borrowers.get(b)[0].equals("\"\"")) {
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
	
	public static void getRatingsComments(Library lib, int index)
	{
		Item ioi = lib.getInv().get(index);
		System.out.println("Ratings: " + ioi.getRatings()[0] + " average out of " + ioi.getRatings()[1]);
		for (int a = 0; a < ioi.getComments().size(); a++) {
			System.out.println("-" +  ioi.getComments().get(a).replace("\"", ""));
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
		System.out.println("Has Kids: (true/false)");
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
		String[] temp = {"", ""};
		borrower.add(temp);
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
		String[] temp = {"", ""};
		borrower.add(temp);
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
		String[] temp = {"", ""};
		borrower.add(temp);
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

