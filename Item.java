package Library247;

import java.util.LinkedList;

public abstract class Item {
	//Enum for genre variable
	enum Genre {
		Fanstasy, Scifi, Horror, Drama, Audio,
		Romantic, Comedy, History, Poetry, Information, 
		Biography, Mystery, Comic, Textbook;  
	}
	
	//Variables
	private String title;
	private String author;
	private int year;
	protected Genre[] genre; //2 genres at most
	private String desc;
	protected LinkedList<String[]> borrower = new LinkedList<>(); //String[2] = borrower, daysLeft
	private String series;
	protected double[] ratings;
	
	//Constructors
	public Item() {
		this.title = null;
		this.author = null;
		this.year = 0;
		this.genre = new Genre[2];
		this.desc = null;
		this.borrower = new LinkedList<String[]>();	
		this.series = null;
		this.ratings = new double[2];
	}
	
	public Item(String title, String author, int year, Genre[] genre, String desc, LinkedList<String[]> borrower, String series, double[] ratings) {
		this.title = title;
		this.author = author;
		this.year = year;
		this.genre = genre;
		this.desc = desc;
		this.borrower = borrower;
		this.series = series;
		this.ratings = ratings;
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

	public Genre[] getGenre() {
		return genre;
	}

	public void setGenre(Genre[] genre) {
		this.genre = genre;
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

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public double[] getRatings() {
		return ratings;
	}

	public void setRatings(double[] ratings) {
		this.ratings = ratings;
	}
	
	public abstract String toSave();
}