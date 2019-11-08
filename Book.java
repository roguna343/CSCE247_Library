package Library247;

import java.util.LinkedList;
import org.json.*;

public class Book extends Item {
	
	//Variables
	private int pages;
	private LinkedList<String> awards;
	private LinkedList<String> publisher;
	private String edition;
	private String type;

	//Constructors
	public Book() {
		super();
		this.pages = 0;
		this.awards = new LinkedList<String>();
		this.publisher = new LinkedList<String>();
		this.edition = "No edition";
		this.type = "No type";
		String temp[] = { "Sally", "14" };
		String temp2[] = { "Brian" , "12" };
		this.borrower.add(temp);
		this.borrower.add(temp2);
		
	}

	public Book(String title, String author, int year, String[] genre, String desc, LinkedList<String[]> borrower, String series, double[] ratings, int pages, LinkedList<String> awards, LinkedList<String> publisher, String edition, String type) {
		super(title, author, year, genre, desc, borrower, series, ratings);
		this.pages = pages;
		this.awards = awards;
		this.publisher = publisher;
		this.edition = edition;
		this.type = type;
	}

	//Getters and Setters
	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public LinkedList<String> getAwards() {
		return awards;
	}

	public void setAwards(LinkedList<String> awards) {
		this.awards = awards;
	}

	public LinkedList<String> getPublisher() {
		return publisher;
	}

	public void setPublisher(LinkedList<String> publisher) {
		this.publisher = publisher;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		if (type.toLowerCase().equals("hardback")) {
			type = "Hardback";
		}
		else if (type.toLowerCase().equals("paperback"))
		{
			type = "Paperback";
		}
		else if (type.toLowerCase().equals("audio"))
		{
			type = "Audio";
		}
		else if (type.toLowerCase().equals("ebook"))
		{
			type = "eBook";
		}
		else {
			type = "Other Type";
		}
	}
	
	public JSONObject getJSON() throws Exception
	{
		JSONObject ret = new JSONObject();
		ret.put("title", this.getTitle());
		ret.put("author", this.getAuthor());
		ret.put("year", this.getYear());
		ret.put("genre", this.getGenre());
		ret.put("desc", this.getDesc());
		ret.put("borrower", this.getBorrower());
		ret.put("series", this.getSeries());
		ret.put("ratings", this.getRatings());
		ret.put("pages", this.getPages());
		ret.put("awards", this.getAwards());
		ret.put("publisher", this.getAwards());
		ret.put("edition", this.getEdition());
		ret.put("type", this.getType());
		return ret;
	}
}