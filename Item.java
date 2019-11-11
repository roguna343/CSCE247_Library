package Library247;

import java.util.LinkedList;
import org.json.*;

public abstract class Item {
	
	//Variables
	private String title;
	private String author;
	private int year;
	private String[] genre; //2 genres at most
	private String desc;
	private LinkedList<String[]> borrower = new LinkedList<>(); //String[2] = borrower, daysLeft
	private String series;
	private double[] ratings; //double[2] = overall rating, # of ratings
	private LinkedList<String> comments;
	
	//Constructors
	public Item() {
		this.title = "No title";
		this.author = "No author";
		this.year = 0;
		this.genre = new String[2];
		this.desc = "No desc";
		this.borrower = new LinkedList<String[]>();	
		String[] temp = { "", ""};
		this.borrower.add(temp);
		this.series = "No series";
		double[] toSet = {0, 0};
		this.ratings = toSet;
		this.comments = new LinkedList<String>();
	}
	
	public Item(String title, String author, int year, String[] genre, String desc, LinkedList<String[]> borrower, String series, double[] ratings, LinkedList<String> comments) {
		this.title = title;
		this.author = author;
		this.year = year;
		this.genre = genre;
		this.desc = desc;
		this.borrower = borrower;
		this.series = series;
		this.ratings = ratings;
		this.comments = comments;
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
		if (year >= 0) {
			this.year = year;
		}
	}

	public String[] getGenre() {
		return genre;
	}

	public void setGenre(String genre, int index) {
		if (index == 0 || index == 1) {
			if (genre.toLowerCase().equals("fantasy")) {
				this.genre[index] = "Fantasy";
			}
			else if (genre.toLowerCase().equals("scifi")) {
				this.genre[index] = "Scifi";
			}
			else if (genre.toLowerCase().equals("horror")) {
				this.genre[index] = "Horror";
			}
			else if (genre.toLowerCase().equals("drama")) {
				this.genre[index] = "Drama";
			}
			else if (genre.toLowerCase().equals("romantic")) {
				this.genre[index] = "Romantic";
			}
			else if (genre.toLowerCase().equals("comedy")) {
				this.genre[index] = "Comedy";
			}
			else if (genre.toLowerCase().equals("history")) {
				this.genre[index] = "History";
			}
			else if (genre.toLowerCase().equals("drama")) {
				this.genre[index] = "Drama";
			}
			else if (genre.toLowerCase().equals("poetry")) {
				this.genre[index] = "Poetry";
			}
			else if (genre.toLowerCase().equals("information")) {
				this.genre[index] = "Information";
			}
			else if (genre.toLowerCase().equals("biography")) {
				this.genre[index] = "Biography";
			}
			else if (genre.toLowerCase().equals("mystery")) {
				this.genre[index] = "Mystery";
			}
			else if (genre.toLowerCase().equals("comic")) {
				this.genre[index] = "Comic";
			}
			else if (genre.toLowerCase().equals("textbook")) {
				this.genre[index] = "Textbook";
			}
			else {
				this.genre[index] = "Other";
			}
		}
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
	
	public LinkedList<String> getComments()
	{
		return comments;
	}
	
	public void setComments(LinkedList<String> newComment) {
		this.comments = newComment;
	}
	
	//Methods
	public int getQuantity() {
		return this.getBorrower().size();
	}
	
	public void updateRatings(double given)
	{
		if (given >= 0 || given <= 5) {
			double newOverall = given + (this.getRatings()[0] * this.getRatings()[1]);
			newOverall /= (this.getRatings()[1] + 1);
			double[] toSet = {newOverall, this.getRatings()[1] + 1};
			this.setRatings(toSet);
		}
	}
		
	public abstract JSONObject getJSON() throws Exception;
	
	public abstract String getInfo();
}