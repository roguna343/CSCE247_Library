package Library247;

import java.util.LinkedList;

public abstract class Item {
	
	protected String title;
	protected String author;
	protected int year;
	protected String desc;
	protected LinkedList<String[]> borrower;
	protected double[] ratings;
	protected Genre[] genres;
	protected String series;
	
	enum Genre {
		Fantasy, Scifi, Horror, Drama, Audio, 
		Romantic, Comedy, History, Poetry, Information, 
		Biography, Mystery, Comic, Textbook;  
	}
	
	public Item() {
		this.title = null;
		this.author = null;
		this.year = 0;
		this.desc = null;
		this.borrower = new LinkedList<String[]>();
		this.ratings = new double[2];
		this.series = null;
		genres = new Genre[2];
	}
	
	public Item(String title, String author, int year, Genre[] genres, String desc, LinkedList<String[]> borrower, String series, double[] ratings) {
		this.title = title;
		this.author = author;
		this.year = year;
		this.desc = desc;
		this.ratings = ratings;
		this.borrower = borrower;
		this.series = series;
		this.genres = genres;
	}

	// Accessors and mutators
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
	
	public double[] getRatings() {
		return ratings;
	}
	
	public void setRatings(double[] ratings) {
		this.ratings = ratings;
	}
	
	public Genre[] getGenre() {
		return genres;
	}
	
	public void setGenre(Genre[] genres) {
		this.genres = genres;
	}
	
	public String getSeries() {
		return series;
	}
	
	public void setSeries(String series) {
		this.series = series;
	}
	
	public String toString() {
		/*
		return "Title: " + this.title +
				"\nAuthor: " + this.author +
				"\nYear: " + this.year +
				"\nDescription: " + this.desc +
				"\nQuantity: " + this.borrower.size();
		*/
		String ret = "Title: ";
		ret += this.title + "\n";
		ret += "Author: ";
		ret += this.author + "\n";
		ret += "Year: ";
		ret += this.year + "\n";
		ret += "Desc: ";
		ret += this.desc + "\n";
		ret += "Quantity: ";
		ret += this.borrower.size() + "\n";
		ret += "Ratings: ";
		ret += this.ratings + "\n";
		ret += "Series: ";
		ret += this.series + "\n";
		ret += "Genres: ";
		ret += this.genres + "\n";
		return ret;
	}
	
	// public abstract String toSave();
}
