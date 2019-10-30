package Library247;

import java.util.LinkedList;

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
	
	public Magazine(String title, String author, int year, Genre[] genre, String desc, LinkedList<String[]> borrower, int[] ratings, String series, int articles, String[] issue, boolean isMature) {
		super(title, author, year, genre, desc, borrower, series, ratings);
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

	public boolean isMature() {
		return isMature;
	}

	public void setMature(boolean isMature) {
		this.isMature = isMature;
	}
	
	public String toSave()
	{
		return "";
	}
}