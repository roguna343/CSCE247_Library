package Library247;

import java.util.LinkedList;

public class Item {
	//Instance
	private String title;
	private String author;
	private int year;
	private String desc;
	private LinkedList<String[]> borrower = new LinkedList<>(); //String[2] = borrower, daysLeft
	/**
	 * Convert all methods to private
	 * Currently public for JUnit testing
	 */
	//Constructors
	public Item() {
		this.title = null;
		this.author = null;
		this.year = 0;
		this.desc = null;
		this.borrower = new LinkedList<>();		
	}
	
	public Item(String title, String author, int year, String desc, LinkedList<String[]> borrower) {
		this.title = title;
		this.author = author;
		this.year = year;
		this.desc = desc;
		this.borrower = borrower;
	}
	
	//Getters and Setters
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public LinkedList<String[]> getBorrower() {
		return borrower;
	}

	public void setBorrower(LinkedList<String[]> borrower) {
		this.borrower = borrower;
	}
	
	public String toString() {
		String ret = "Title: ";
		ret += this.title + "\n";
		ret += "Author: ";
		ret += this.author + "\n";
		ret += "Year: ";
		ret += this.year + "\n";
		ret += "Desc: ";
		ret += this.desc + "\n";
		ret += "Quantity: ";
		ret += this.borrower.size();
		return ret;
	}
	
	
}
