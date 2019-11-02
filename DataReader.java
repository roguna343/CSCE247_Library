package CSCE247_Library;

import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataReader {
	private static final String BOOK_LIST = "Data.json";
	
	public static ArrayList<Book> loadItems() {
		ArrayList<Book> item = new ArrayList<Book>();
		
		try {
			FileReader reader = new FileReader("src/Data.json");
			JSONParser parser = new JSONParser();
			JSONObject jsonData = (JSONObject)new JSONParser().parse(reader);
			JSONArray itemJSON = (JSONArray)jsonData.get("item");
			
			for(int i = 0; i < itemJSON.size(); i++) {
				JSONObject itemsJSON = (JSONObject)itemJSON.get(i);
				String title = (String)itemsJSON.get("title");
				String author = (String)itemsJSON.get("author");
				int year = (int)itemsJSON.get("year");
				String desc = (String)itemsJSON.get("desc");
				String borrower = (String)itemsJSON.get("borrower");
				String series = (String)itemsJSON.get("serires");
				double[] ratings = (double[])itemsJSON.get("ratings");
				int pages = (int)itemsJSON.get("pages");
				String awards = (String)itemsJSON.get("awards");
				String publisher = (String)itemsJSON.get("publisher");
				String edition = (String)itemsJSON.get("edition");
				
				JSONArray genre = (JSONArray) jsonData.get("genre");
				for (Object g : genre) {
					System.out.println(g + "");
				}
				
				JSONArray type = (JSONArray) jsonData.get("type");
				for (Object t : type) {
					System.out.print(t + "");
				}
				item.add(new Book());
				
			}
			return item;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
