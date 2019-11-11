package Library247;

import java.io.*;
import java.util.LinkedList;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import java.util.Random;

public class Library {
	
	/**
	 * This is the meat and gravy of all classes. After thorough proof of concept testing, we went ahead and made a class that took the objects
	 * prior and actually handled them as intended. This is responsible for fileIO, and OOP regarding any item or user.
	 */
	
	//Addresses to read the OOP data from
	private static final String Ab = "src/Library247/books.json";
	private static final String Av = "src/Library247/videos.json";
	private static final String Am = "src/Library247/magazines.json";
	private static final String Aa = "src/Library247/adults.json";
	private static final String Ak = "src/Library247/kids.json";
	
	private LinkedList<Item> inv;
	private int date; //0-365
	private LinkedList<User> usr;
	
	//Default constructor has a new role where it automatically sets up the data upon call
	public Library() {
		this.inv = loadInv();
		this.usr = loadUsr();
		Random r = new Random();
		this.date = r.nextInt(365);
	}
	
	public int getDate() {
		return date;
	}
	
	public void setDate(int date) {
		this.date = date;
	}

	public LinkedList<Item> getInv()
	{
		return inv;
	}
	
	public void setInv(LinkedList<Item> inv)
	{
		this.inv = inv;
	}
	
	public LinkedList<User> getUsr()
	{
		return usr;
	}
	
	public void setUsr(LinkedList<User> usr)
	{
		this.usr = usr;
	}
	
	//Finds the user account associated with parameters; if wrong, return a null account with no access to anything
	public User login(String username, String password)
	{
		for (int a = 0; a < usr.size(); a++) {
			User check = usr.get(a);
			if (check.getUsername().toLowerCase().equals(username.toLowerCase()) && check.getPassword().toLowerCase().equals(password.toLowerCase())) {
				return check;
			}
		}
		User ret = new Adult();
		return ret;
	}
	
	//Created to only do save functions
	public void save() {
		saveInv();
		saveUsr();
	}
	
	/**
	 * These are very important methods. This ensures any changes done to a item or user will be pushed back into the library memory.
	 * Prevents any loop holes from data not being captured as intended and allows to bandage those leaks.
	 * @param toUpdate
	 */
	public void updateUser(User toUpdate) {
		String name = toUpdate.getName();
		for (int a = 0; a < usr.size(); a++) {
			if (name.equals(usr.get(a).getName())) {
				usr.set(a, toUpdate);
				return;
			}
		}
	}
	
	public void updateItem(Item toUpdate) {
		String title = toUpdate.getTitle();
		for (int a = 0; a < inv.size(); a++) {
			if (title.equals(inv.get(a).getTitle())) {
				inv.set(a, toUpdate);
			}
		}
	}
	
	//Finds if a book is available
	public boolean isAvailable(String title) {
		title = title.replace("\"", "");
		for (int a = 0; a < inv.size(); a++) {
			Item temp = inv.get(a);
			if (temp.getTitle().equalsIgnoreCase(title)) {
				LinkedList<String[]> borrowers = temp.getBorrower();
				for (int b = 0; b < borrowers.size(); b++) {
					if (borrowers.get(b)[0].replace("\"", "").equals("")) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public void getPatronInfo()
	{
		for (int a = 0; a < usr.size(); a++) {
			System.out.println("-- Index: " + a + " --");
			System.out.println(usr.get(a).getInfo());
			System.out.println("-- -- --");
		}
	}
	
	public void getInventoryInfo()
	{
		for (int a = 0; a < inv.size(); a++) {
			System.out.println("-- Index: " + a + " --");
			System.out.println(inv.get(a).getInfo());
			System.out.println("-- -- --");
		}
	}
	
	public void pushFines(Kid from) {
		String parent = from.getParent();
		for (int a = 0; a < usr.size(); a++) {
			User temp = usr.get(a);
			if (temp.getName().equalsIgnoreCase(parent)) {
				temp.setFines(temp.getFines() + from.getFines());
				this.updateUser(temp);
				from.setFines(0);
				this.updateUser(from);
				return;
			}
		}
	}
	
	/**
	 * Alright, so we are aware both load functions are long and lanky and could have been split further into methods, but
	 * due to time constraints, we could not split it. Really, it takes length in only classifying each JSON variable, so it
	 * is still good code
	 * @return
	 */
	
	private LinkedList<User> loadUsr() {
		try {
			LinkedList<User> loader = new LinkedList<>();
			FileReader reader1 = new FileReader(Aa);
			JSONObject jsonData1 = (JSONObject)new JSONParser().parse(reader1);
			JSONArray adults = (JSONArray)jsonData1.get("adult");
			reader1.close();
			for (int a = 0; a < adults.size(); a++) {
				JSONObject adultTemp = (JSONObject)adults.get(a);
				String name = (String)adultTemp.get("name");
				int age =  Integer.parseInt((String)adultTemp.get("age").toString());
				String username = (String)adultTemp.get("username");
				String password = (String)adultTemp.get("username");
				LinkedList<String> checkedItem = splitify3((String)adultTemp.get("checkedItem").toString());
				LinkedList<String> lookForItem = splitify3((String)adultTemp.get("lookForItem").toString());
				int birthday = Integer.parseInt((String)adultTemp.get("birthday").toString());
				double fines = Double.parseDouble((String)adultTemp.get("fines").toString());
				boolean enabled = Boolean.parseBoolean((String)adultTemp.get("enabled").toString());
				boolean hasKids = Boolean.parseBoolean((String)adultTemp.get("hasKids").toString());
				Adult newAdult = new Adult(name, age, username, password, checkedItem, lookForItem, birthday, fines, enabled, hasKids);
				loader.add(newAdult);
			}
			FileReader reader2 = new FileReader(Ak);
			//JSONParser parser2 = new JSONParser();
			JSONObject jsonData2 = (JSONObject)new JSONParser().parse(reader2);
			JSONArray kids = (JSONArray)jsonData2.get("kid");
			reader2.close();
			for (int b = 0; b < kids.size(); b++) {
				JSONObject kidTemp = (JSONObject)kids.get(b);
				String name = (String)kidTemp.get("name");
				int age =  Integer.parseInt((String)kidTemp.get("age").toString());
				String username = (String)kidTemp.get("username");
				String password = (String)kidTemp.get("username");
				LinkedList<String> checkedItem = splitify3((String)kidTemp.get("checkedItem").toString());
				LinkedList<String> lookForItem = splitify3((String)kidTemp.get("lookForItem").toString());
				int birthday = Integer.parseInt((String)kidTemp.get("birthday").toString());
				double fines = Double.parseDouble((String)kidTemp.get("fines").toString());
				boolean enabled = Boolean.parseBoolean((String)kidTemp.get("enabled").toString());
				String parent = (String)kidTemp.get("parent");
				Kid newKid = new Kid(name, age, username, password, checkedItem, lookForItem, birthday, fines, enabled, parent);
				loader.add(newKid);
			}
			return loader;
		}
		catch (Exception e) {
			System.out.println("Error loading from user file.");
			e.printStackTrace();
			return null;
		}
	}
	
	private void saveUsr()
	{
		try {
			String adults = "";
			String kids = "";
			for (int a = 0; a < usr.size(); a++) {
				User user = usr.get(a);
				String toWrite = user.getJSON().toString();
				if (toWrite.contains("parent")) {
					kids += prettify(toWrite.replace("\\\"",  "")) + ",\n";
				}
				else {	
					adults += prettify(toWrite.replace("\\\"",  "")) + ",\n";
				}
			}
			if (adults.length() > 2) {
				adults = adults.substring(0, adults.length()-2);
			}
			if (kids.length() > 2) {
				kids = kids.substring(0, kids.length()-2);
			}
			FileWriter wa = new FileWriter(Aa);
			wa.write("{\"adult\":[\n");
			FileWriter wk = new FileWriter(Ak);
			wk.write("{\"kid\":[\n");
			adults += "\n]}";
			kids += "\n]}";
			wa.write(adults.replace("\"\"", ""));
			wk.write(kids.replace("\"\"", ""));
			wa.close();
			wk.close();
		}
		catch (Exception e) {
			System.out.println("Error in saving the user data.");
			e.printStackTrace();
		}
	}
	
	private LinkedList<Item> loadInv() {
		try {
			LinkedList<Item> loader = new LinkedList<>();
			FileReader reader1 = new FileReader(Ab);
			//JSONParser parser1 = new JSONParser();
			JSONObject jsonData1 = (JSONObject)new JSONParser().parse(reader1);
			JSONArray books = (JSONArray)jsonData1.get("book");
			reader1.close();
			if (books.size() != 0) {
				for (int a = 0; a < books.size(); a++) {
					JSONObject bookTemp = (JSONObject)books.get(a);
					String title = (String)bookTemp.get("title");
					String author = (String)bookTemp.get("author");
					int year = Integer.parseInt((String) bookTemp.get("year").toString());
					String[] genre = splitify1((String)bookTemp.get("genre").toString());
					String desc = (String)bookTemp.get("desc");		
					LinkedList<String[]> borrower = splitify4((String)bookTemp.get("borrower").toString());
					String series = (String)bookTemp.get("series");
					double[] ratings = splitify2((String)bookTemp.get("ratings").toString());
					LinkedList<String> comments = splitify3((String)bookTemp.get("comments").toString());
					int pages = Integer.parseInt((String) bookTemp.get("pages").toString());
					LinkedList<String> awards = splitify3((String)bookTemp.get("awards").toString());
					LinkedList<String> publisher = splitify3((String)bookTemp.get("publisher").toString());
					String edition = (String)bookTemp.get("edition");
					String type = (String)bookTemp.get("type");
					Book addBook = new Book(title, author, year, genre, desc, borrower, series, ratings, comments, pages, awards, publisher, edition, type);
					loader.add(addBook);
				}
			}
			FileReader reader2 = new FileReader(Av);
			//JSONParser parser2 = new JSONParser();
			JSONObject jsonData2 = (JSONObject)new JSONParser().parse(reader2);
			JSONArray videos = (JSONArray)jsonData2.get("video");
			reader2.close();
			
			if (videos.size() != 0) {
				for (int b = 0; b < videos.size(); b++) {
					JSONObject videoTemp = (JSONObject)videos.get(b);
					String title = (String)videoTemp.get("title");
					String author = (String)videoTemp.get("author");
					int year = Integer.parseInt((String) videoTemp.get("year").toString());
					String[] genre = splitify1((String)videoTemp.get("genre").toString());
					String desc = (String)videoTemp.get("desc");		
					LinkedList<String[]> borrower = splitify4((String)videoTemp.get("borrower").toString());
					String series = (String)videoTemp.get("series");
					double[] ratings = splitify2((String)videoTemp.get("ratings").toString());
					LinkedList<String> comments = splitify3((String)videoTemp.get("comments").toString());
					int time = Integer.parseInt((String)videoTemp.get("time").toString());
					LinkedList<String> awards = splitify3((String)videoTemp.get("awards").toString());
					LinkedList<String> studios = splitify3(videoTemp.get("studios").toString());
					boolean hasSisterMovies = Boolean.parseBoolean((String)videoTemp.get("hasSisterMovies").toString());
					Video addVid = new Video(title, author, year, genre, desc, borrower, series, ratings, comments, time, studios, awards, hasSisterMovies);
					loader.add(addVid);
				}
			}
			FileReader reader3 = new FileReader(Am);
			//JSONParser parser3 = new JSONParser();
			JSONObject jsonData3 = (JSONObject)new JSONParser().parse(reader3);
			JSONArray mags = (JSONArray)jsonData3.get("magazine");
			reader3.close();
			if (mags.size() != 0)
			{
				for (int c = 0; c < mags.size(); c++) {
					JSONObject magTemp = (JSONObject)mags.get(c);
					String title = (String)magTemp.get("title");
					String author = (String)magTemp.get("author");
					int year = Integer.parseInt((String)magTemp.get("year").toString());
					String[] genre = splitify1((String)magTemp.get("genre").toString());
					String desc = (String)magTemp.get("desc");		
					LinkedList<String[]> borrower = splitify4((String)magTemp.get("borrower").toString());
					String series = (String)magTemp.get("series");
					double[] ratings = splitify2((String)magTemp.get("ratings").toString());
					LinkedList<String> comments = splitify3((String)magTemp.get("comments").toString());
					int articles = Integer.parseInt((String)magTemp.get("articles").toString());
					String[] issue = splitify1((String)magTemp.get("issue").toString());
					boolean isMature = Boolean.parseBoolean((String)magTemp.get("isMature").toString());
					Magazine addMag = new Magazine(title, author, year, genre, desc, borrower, series, ratings, comments, articles, issue, isMature);
					loader.add(addMag);
				}
			}
			return loader;
		}
		catch (Exception e) {
			System.out.println("Error loading from inventory file.");
			e.printStackTrace();
			return null;
		}
	}
	
	private void saveInv() {
		try {
			String books = "";
			String videos = "";
			String mags = "";
			for (int a = 0; a < inv.size(); a++) {
				Item item = inv.get(a);
				String toWrite = item.getJSON().toString();
				if (toWrite.contains("type")) {
					books += prettify(toWrite.replace("\\\"",  "")) + ",\n";
				}
				else if (toWrite.contains("studios")) {
					videos += prettify(toWrite.replace("\\\"",  "")) + ",\n";
				}
				else				 {	
					mags += prettify(toWrite.replace("\\\"",  "")) + ",\n";
				}
			}
			if (books.length() > 2) {
				books = books.substring(0, books.length()-2);
			}
			if (videos.length() > 2) {
				videos = videos.substring(0, videos.length()-2);
			}
			if (mags.length() > 2) {
				mags =  mags.substring(0, mags.length()-2);
			}
			FileWriter wb = new FileWriter(Ab);
			wb.write("{\"book\":[\n");
			FileWriter wv = new FileWriter(Av);
			wv.write("{\"video\":[\n");
			FileWriter wm = new FileWriter(Am);
			wm.write("{\"magazine\":[\n");
			books += "\n]}";
			videos += "\n]}";
			mags += "\n]}";
			wb.write(books);
			wv.write(videos);
			wm.write(mags);
			wb.close();
			wv.close();
			wm.close();
		}
		catch (Exception e) {
			System.out.println("Error in saving the data.");
			e.printStackTrace();
		}
	}
	
	public void addNewItem(Item toAdd) {
		inv.add(toAdd);
		System.out.println("Succesfully added a new item to the inventory.");
	}
	
	//Operates on the idea that Item quantity is borrower.size();
	public void addCopyOfItem(String title) {
		for (int a = 0; a < inv.size(); a++) {
			Item copyAdd = inv.get(a);
			if (copyAdd.getTitle().toLowerCase().equals(title.toLowerCase())) {
				LinkedList<String[]> borrowers = copyAdd.getBorrower();
				String[] temp = {"", ""};
				borrowers.add(temp);
				copyAdd.setBorrower(borrowers);
				this.updateItem(copyAdd);
				System.out.println("Succesfully added a copy of a pre-exisiting item.");
			}
		}
	}
	
	public void removeItem(String title)
	{
		try {
			int index = 0;
			boolean isFound = false;
			for (int a = 0; a < inv.size(); a++) {
				index++;
				Item temp = inv.get(a);
				if (temp.getTitle().toLowerCase().equals(title.toLowerCase())) {
					isFound = true;
					break;
				}
			}
			if (!isFound) {
				System.out.println("Cannot find the item with those parameters.");
				return;
			}
			Item ioi = inv.get(index);
			if (ioi.getQuantity() <= 1) {
				inv.remove(ioi);
				System.out.println("Succesfully removed the book completely from the inventory.");
			}
			else
			{
				LinkedList<String[]> scan = ioi.getBorrower();
				for (int a = 0; a < scan.size(); a++) {
					String[] scanTo = scan.get(a);
					if (scanTo[0].length() == 2) {
						scan.remove(a);
						ioi.getBorrower();
						this.updateItem(ioi);
						System.out.println("Succesfully removed a single non-checked out instance of the book.");
						return;
					}
				}
				System.out.println("All copies of the book you are trying to remove are checked out, thus, the book cannot be removed.");
			}
		}
		catch (Exception e) {
			System.out.println("Error in removing an item.");
			e.printStackTrace();
		}
	}
	
	public void addUser(User toAdd) {
		usr.add(toAdd);
	}
	
	
	/**
	 * All methods make JSON more readable to the human eye
	 * @param toEdit
	 * @return
	 */
	
	private static String prettify(String toEdit) {
		return toEdit.replace(",\"", ",\n\"").replace("{", "{\n").replace("}", "\n}");
	}
	
	private static String[] splitify1(String toEdit) {
		return toEdit.replace("[", "").replace("]", "").split(",");
	}
	
	private static double[] splitify2(String toEdit) {
		String[] temp = toEdit.replace("[", "").replace("]", "").split(",");
		double a = Double.parseDouble(temp[0]);
		double b = Double.parseDouble(temp[1]);
		double[] toRet = {a, b};
		return toRet;
	}
	
	private static LinkedList<String> splitify3(String toEdit) {
		String[] temp = toEdit.replace("[", "").replace("]", "").split(",");
		LinkedList<String> toRet = new LinkedList<>();
		for (int a = 0; a < temp.length; a++) {
			toRet.add(temp[a]);
		}
		return toRet;
	}
	
	private static LinkedList<String[]> splitify4(String toEdit) {
		String[] temp = toEdit.replace("[[", "[").replace("]]", "]").replace("],[", "] [").split(" ");
		LinkedList<String[]> toRet = new LinkedList<>();
		for (int a = 0; a < temp.length; a++) {
			toRet.add(splitify1(temp[a]));
		}
		return toRet;
	}
}
