package Library247;

import java.util.LinkedList;
import org.json.*;

public class Magazine extends Item {
	//Variables
	private int articles;
	private String[] issue;
	private boolean isMature;
	
	//Constructor
	public Magazine() {
		super();
		this.articles = 0;
		this.issue = new String[2]; //Month Year
		this.isMature = false;
	}
	
	public Magazine(String title, String author, int year, String[] genre, String desc, LinkedList<String[]> borrower, String series, double[] ratings, LinkedList<String> comments, int articles, String[] issue, boolean isMature) {
		super(title, author, year, genre, desc, borrower, series, ratings, comments);
		this.articles = articles;
		this.issue = issue;
		this.isMature = isMature;
	}

	//Getters and Setters
	public int getArticles() {
		return articles;
	}

	public void setArticles(int articles) {
		this.articles = articles;
	}

	public String[] getIssue() {
		return issue;
	}

	public void setIssue(String[] issue) {
		this.issue = issue;
	}

	public boolean getMature() {
		return isMature;
	}

	public void setMature(boolean isMature) {
		this.isMature = isMature;
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
		ret.put("comments", this.getComments());
		ret.put("articles", this.getArticles());
		ret.put("issue", this.getIssue());
		ret.put("isMature", this.getMature());
		return ret;
	}
}