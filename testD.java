package Library247;

import java.io.*;
import java.util.ArrayList;
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
			FileWriter file = new FileWriter("src/Library247/books.json");
			file.write("{\"book\":[\n");
			file.write(prettify(book.getJSON().toString()));
			file.write("\n]}");
			file.close();
			System.out.println(prettify(book.getJSON().toString()));
			*/
			
			FileReader reader = new FileReader("src/Library247/books.json");
			JSONParser parser = new JSONParser();
			JSONObject jsonData = (JSONObject)new JSONParser().parse(reader);
			JSONArray books = (JSONArray)jsonData.get("book");
			System.out.println(books.size());
			
			JSONObject bookTemp = (JSONObject)books.get(0);
			//String firstName = (String)personJSON.get("firstName");
			System.out.println((bookTemp.get("genre").toString()));
			System.out.println((bookTemp.get("genre").toString().length()));
			
			
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
	
	public static String prettify(String toEdit)
	{
		return toEdit.replace(",\"", ",\n\"").replace("{", "{\n").replace("}", "\n}");
	}
}
