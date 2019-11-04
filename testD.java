package Library247;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;

public class testD {
	
	public static void main(String[] args) { 
		// TODO Auto-generated method stub
		try {
			/*
			Item mag = new Magazine();
			Item video = new Video();
			Item book = new Book();
			FileWriter file = new FileWriter("src/Library247/magazines.json");
			file.write("{\"magazine\":[\n");
			file.write(prettify(mag.getJSON().toString()));
			file.write("\n]}");
			file.close();
			System.out.println(prettify(mag.getJSON().toString()));
			*/
			
			/*FileReader reader = new FileReader("src/Library247/books.json");
			JSONParser parser = new JSONParser();
			JSONObject jsonData = (JSONObject)new JSONParser().parse(reader);
			JSONArray books = (JSONArray)jsonData.get("book");
			System.out.println(books.size());*/
			/*
			JSONObject bookTemp = (JSONObject)books.get(0);
			//String firstName = (String)personJSON.get("firstName");
			String title = (String)bookTemp.get("title");
			//String desc, LinkedList<String[]> borrower, String series, double[] ratings, int pages, LinkedList<String> awards, LinkedList<String> publisher, String edition, String type) {
			String author = (String)bookTemp.get("author");
			int year = Integer.parseInt((String) bookTemp.get("year").toString());
			String[] genre = splitify((String)bookTemp.get("genre").toString());
			//String desc =
			*/
			Library test = new Library();
			
			
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
	
	public static String prettify(String toEdit) //Used to make Json file look pretty when we write into it
	{
		return toEdit.replace(",\"", ",\n\"").replace("{", "{\n").replace("}", "\n}");
	}
	
	public static String[] splitify(String toEdit) //Used to convert a nasty json array into a nice Java array
	{
		return toEdit.replace("[", "").replace("]", "").split(",");
	}
}
