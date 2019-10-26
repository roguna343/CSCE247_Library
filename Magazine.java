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
		this.issue = new String[2];
		this.isMature = false;
	}
	
	public Magazine(String title, String author, int year, Genre[] genre, String desc, LinkedList<String[]> borrower, String series, int articles, String[] issue, boolean isMature) {
		super(title, author, year, genre, desc, borrower, series);
		this.articles = 0;
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
	
	public String toString() {
		String ret;
		ret = "Title: " + this.getTitle() + "\n";
		ret += "Author: " + this.getAuthor() + "\n";
		ret += "Year: " + this.getYear() + "\n";
		ret += "Genre: " + this.getGenre()[0] + " " + this.getGenre()[1] + "\n";
		ret += "Desc: " + this.getDesc() + "\n";
		ret += "Borrower: " + this.getBorrower().size() + "\n";
		ret += "Series: " +  this.getSeries() + "\n";
		ret += "Articles: " + this.getArticles() + "\n";
		ret += "Issue: " + this.getIssue()[0] + this.getIssue()[1] + "\n";
		ret += "Mature: " + this.isMature();
		return ret;
	}
}
