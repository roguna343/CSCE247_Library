package Library247;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class testD {
	
	public static void main(String[] args) { 
		// TODO Auto-generated method stub
		try {
			/*
			Item mag = new Magazine();
			Item video = new Video();
			Item book = new Book();
			FileWriter file = new FileWriter("src/Library247/videos.json");
			file.write("{\"video\":[\n");
			file.write(prettify(video.getJSON().toString()));
			file.write("\n]}");
			file.close();
			System.out.println(prettify(video.getJSON().toString()));
			
			/*
			FileReader reader = new FileReader("src/Library247/books.json");
			JSONParser parser = new JSONParser();
			JSONObject jsonData = (JSONObject)new JSONParser().parse(reader);
			JSONArray books = (JSONArray)jsonData.get("book");
			System.out.println(books.size());
			
			JSONObject bookTemp = (JSONObject)books.get(0);
			//String firstName = (String)personJSON.get("firstName");
			String title = (String)bookTemp.get("title");
			//String desc, LinkedList<String[]> borrower, String series, double[] ratings, int pages, LinkedList<String> awards, LinkedList<String> publisher, String edition, String type) {
			String author = (String)bookTemp.get("author");
			int year = Integer.parseInt((String) bookTemp.get("year").toString());
			String[] genre = splitify((String)bookTemp.get("genre").toString());
			//String desc =/*
			*/
			Scanner key = new Scanner(System.in);
			Library test = new Library();
			
			//test.closeLibrary();
			/*
			User test2 = new User();
			test2.setName("billy");
			test2.checkout(test.inv.get(0), 2);
			System.out.println(test2.getCheckedItem());
			test2.checkIn(test.inv.get(0));
			System.out.println(test2.getCheckedItem());
			System.out.println(test.inv.get(0).getQuantity());
			test.saveData();*/
			
			/*User a = new Adult();
			a.setAge(28);
			a.setName("JJ");
			LinkedList<String> temp = new LinkedList<>();
			temp.add("e rated");
			temp.add("king deedeedee");
			a.setCheckedItem(temp);
			FileWriter file = new FileWriter("src/Library247/adults.json");
			file.write("{\"adult\":[\n");
			file.write(prettify(a.getJSON().toString()));
			file.write("\n]}");
			file.close();*/
			/*Kid k = new Kid();
			User a = new Adult();
			a.setName("kkk");
			k.setParent("kkk");
			User k2 = (User) k;
			k = (Kid) k2;
			System.out.println(k.getParent());			
			*/
			
			
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
	/*
	public static String prettify(String toEdit) {
		return toEdit.replace(",\"", ",\n\"").replace("{", "{\n").replace("}", "\n}");
	}
	
	public static String[] splitify1(String toEdit) {
		return toEdit.replace("[", "").replace("]", "").split(",");
	}
	
	public static double[] splitify2(String toEdit) {
		String[] temp = toEdit.replace("[", "").replace("]", "").split(",");
		double a = Double.parseDouble(temp[0]);
		double b = Double.parseDouble(temp[1]);
		double[] toRet = {a, b};
		return toRet;
	}
	
	public static LinkedList<String> splitify3(String toEdit) {
		String[] temp = toEdit.replace("[", "").replace("]", "").split(",");
		LinkedList<String> toRet = new LinkedList<>();
		for (int a = 0; a < temp.length; a++)
		{
			toRet.add(temp[a]);
		}
		return toRet;
	}
	
	public static LinkedList<String[]> splitify4(String toEdit) {
		String[] temp = toEdit.replace("[[", "[").replace("]]", "]").replace("],[", "] [").split(" ");
		LinkedList<String[]> toRet = new LinkedList<>();
		for (int a = 0; a < temp.length; a++)
		{
			toRet.add(splitify1(temp[a]));
		}
		return toRet;
	}*/
	
	public static Book createBook(Scanner keyboard) {
		Book ret = new Book();
		System.out.println("Please enter the following parameters to create a Book.");
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
}

