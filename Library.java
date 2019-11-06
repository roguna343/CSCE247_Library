package Library247;

import java.io.*;
import java.util.LinkedList;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import java.util.Random;

public class Library {
	
	public static final String Ab = "src/Library247/books.json";
	public static final String Av = "src/Library247/videos.json";
	public static final String Am = "src/Library247/magazines.json";
	
	private LinkedList<Item> inv;
	private int date; //0-365
	//private LinkedList<User> user;
	//private Librarian lib;
	
	public Library()
	{
		this.inv = loadData();
		Random r = new Random(365);
		this.date = r.nextInt();
	}
	
	public int getDate()
	{
		return date;
	}
	
	public void setDate(int date)
	{
		this.date = date;
	}
	
	private static LinkedList<Item> loadData()
	{
		try {
			LinkedList<Item> loader = new LinkedList<>();
			FileReader reader1 = new FileReader(Ab);
			//JSONParser parser1 = new JSONParser();
			JSONObject jsonData1 = (JSONObject)new JSONParser().parse(reader1);
			JSONArray books = (JSONArray)jsonData1.get("book");
			reader1.close();
			for (int a = 0; a < books.size(); a++)
			{
				JSONObject bookTemp = (JSONObject)books.get(a);
				String title = (String)bookTemp.get("title");
				String author = (String)bookTemp.get("author");
				int year = Integer.parseInt((String) bookTemp.get("year").toString());
				String[] genre = splitify1((String)bookTemp.get("genre").toString());
				String desc = (String)bookTemp.get("desc");		
				LinkedList<String[]> borrower = splitify4((String)bookTemp.get("borrower").toString());
				String series = (String)bookTemp.get("series");
				double[] ratings = splitify2((String)bookTemp.get("ratings").toString());
				int pages = Integer.parseInt((String) bookTemp.get("pages").toString());
				LinkedList<String> awards = splitify3((String)bookTemp.get("awards").toString());
				LinkedList<String> publisher = splitify3((String)bookTemp.get("publisher").toString());
				String edition = (String)bookTemp.get("edition");
				String type = (String)bookTemp.get("type");
				Book addBook = new Book(title, author, year, genre, desc, borrower, series, ratings, pages, awards, publisher, edition, type);
				loader.add(addBook);
			}
			FileReader reader2 = new FileReader(Av);
			//JSONParser parser2 = new JSONParser();
			JSONObject jsonData2 = (JSONObject)new JSONParser().parse(reader2);
			JSONArray videos = (JSONArray)jsonData2.get("video");
			reader2.close();
			for (int b = 0; b < videos.size(); b++)
			{
				JSONObject videoTemp = (JSONObject)videos.get(b);
				String title = (String)videoTemp.get("title");
				String author = (String)videoTemp.get("author");
				int year = Integer.parseInt((String) videoTemp.get("year").toString());
				String[] genre = splitify1((String)videoTemp.get("genre").toString());
				String desc = (String)videoTemp.get("desc");		
				LinkedList<String[]> borrower = splitify4((String)videoTemp.get("borrower").toString());
				String series = (String)videoTemp.get("series");
				double[] ratings = splitify2((String)videoTemp.get("ratings").toString());
				int time = Integer.parseInt((String)videoTemp.get("time").toString());
				LinkedList<String> awards = splitify3((String)videoTemp.get("awards").toString());
				LinkedList<String> studios = splitify3(videoTemp.get("studios").toString());
				boolean hasSisterMovies = Boolean.parseBoolean((String)videoTemp.get("hasSisterMovies").toString());
				Video addVid = new Video(title, author, year, genre, desc, borrower, series, ratings, time, studios, awards, hasSisterMovies);
				loader.add(addVid);
			}
			FileReader reader3 = new FileReader(Am);
			//JSONParser parser3 = new JSONParser();
			JSONObject jsonData3 = (JSONObject)new JSONParser().parse(reader3);
			JSONArray mags = (JSONArray)jsonData3.get("magazine");
			reader3.close();
			for (int c = 0; c < videos.size(); c++)
			{
				JSONObject magTemp = (JSONObject)mags.get(c);
				String title = (String)magTemp.get("title");
				String author = (String)magTemp.get("author");
				int year = Integer.parseInt((String)magTemp.get("year").toString());
				String[] genre = splitify1((String)magTemp.get("genre").toString());
				String desc = (String)magTemp.get("desc");		
				LinkedList<String[]> borrower = splitify4((String)magTemp.get("borrower").toString());
				String series = (String)magTemp.get("series");
				double[] ratings = splitify2((String)magTemp.get("ratings").toString());
				int articles = Integer.parseInt((String)magTemp.get("articles").toString());
				String[] issue = splitify1((String)magTemp.get("issue").toString());
				boolean isMature = Boolean.parseBoolean((String)magTemp.get("isMature").toString());
				Magazine addMag = new Magazine(title, author, year, genre, desc, borrower, series, ratings, articles, issue, isMature);
				loader.add(addMag);
			}
			System.out.println("Succesfully loaded the inventory with " + loader.size() + " item(s).");
			return loader;
		}
		catch (Exception e)
		{
			System.out.println("Error loading from inventory file.");
			e.printStackTrace();
			return null;
		}
	}
	
	public void saveData()
	{
		try
		{
			String books = "";
			String videos = "";
			String mags = "";
			for (int a = 0; a < inv.size(); a++)
			{
				Item item = inv.get(a);
				//Item b = new Book();
				//Video v = new Video();
				//Magazine m = new Magazine();
				String toWrite = item.getJSON().toString();
				if (toWrite.contains("type"))
				{
					books += prettify(toWrite.replace("\\\"",  "")) + ",\n";
				}
				else if (toWrite.contains("studios"))
				{
					videos += prettify(toWrite.replace("\\\"",  "")) + ",\n";
				}
				else				
				{	
					mags += prettify(toWrite.replace("\\\"",  "")) + ",\n";
				}
			}
			books = books.substring(0, books.length()-2);
			videos = videos.substring(0, videos.length()-2);
			mags =  mags.substring(0, mags.length()-2);
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
			System.out.print("Succesfully saved the inventory of " + inv.size() + " item(s).");
		}
		catch (Exception e)
		{
			System.out.println("Error in saving the data.");
			e.printStackTrace();
		}
	}
	
	public void addItem(Item toAdd)
	{
		inv.add(toAdd);
	}
	
	public void removeItem(String title, String form)
	{
		try {
			int index = 0;
			boolean isFound = false;
			for (int a = 0; a < inv.size(); a++)
			{
				index++;
				Item temp = inv.get(a);
				String sJ = temp.getJSON().toString();
				if (sJ.contains(title.toLowerCase()))
				{
					if (form.equals("Book") && sJ.contains("type"))
					{
						isFound = true;
						break;
					}
					else if (form.equals("Video") && sJ.contains("studios"))
					{
						isFound = true;
						break;
					}
					else if (form.equals("Magazine"))
					{
						isFound = true;
						break;
					}
				}
			}
			if (!isFound)
			{
				System.out.println("Cannot find the item with those parameters.");
				return;
			}
			Item ioi = inv.get(index);
			System.out.println("The item has been found in the inventory. There exist " + ioi.getQuantity() + "instance(s) of it."
					+ "\nPlease type in the index of the item that you would like to remove.");
			//TODO
			
		}
		catch (Exception e)
		{
			System.out.println("Error in removing an item.");
			e.printStackTrace();
		}
	}
	
	public static String prettify(String toEdit)
	{
		return toEdit.replace(",\"", ",\n\"").replace("{", "{\n").replace("}", "\n}");
	}
	
	//String conversion tools
	public static String[] splitify1(String toEdit)
	{
		return toEdit.replace("[", "").replace("]", "").split(",");
	}
	
	public static double[] splitify2(String toEdit)
	{
		String[] temp = toEdit.replace("[", "").replace("]", "").split(",");
		double a = Double.parseDouble(temp[0]);
		double b = Double.parseDouble(temp[1]);
		double[] toRet = {a, b};
		return toRet;
	}
	
	public static LinkedList<String> splitify3(String toEdit)
	{
		String[] temp = toEdit.replace("[", "").replace("]", "").split(",");
		LinkedList<String> toRet = new LinkedList<>();
		for (int a = 0; a < temp.length; a++)
		{
			toRet.add(temp[a]);
		}
		return toRet;
	}
	
	public static LinkedList<String[]> splitify4(String toEdit)
	{
		String[] temp = toEdit.replace("[[", "[").replace("]]", "]").replace("],[", "] [").split(" ");
		LinkedList<String[]> toRet = new LinkedList<>();
		for (int a = 0; a < temp.length; a++)
		{
			toRet.add(splitify1(temp[a]));
		}
		return toRet;
	}
}
