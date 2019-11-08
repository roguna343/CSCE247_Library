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
			Library test = new Library();
			test.saveData();
			
			
			
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
}
