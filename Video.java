package Library247;

import java.util.LinkedList;

public class Video extends Item {
	//Variables
	private int time;
	private LinkedList<String> awards;
	private LinkedList<String> studios;
	private boolean hasSisterMovies;
	
	//Constructors
	public Video() {
		super();
		time = 0;
		awards = new LinkedList<String>();
		studios = new LinkedList<String>();
		hasSisterMovies = false;
	}
	
	public Video(String title, String author, int year, Genre[] genre, String desc, LinkedList<String[]> borrower, String series, double[] ratings, int time, LinkedList<String> studios, LinkedList<String> awards, boolean hasSisterMovies) {
		super(title, author, year, genre, desc, borrower, series, ratings);
		this.time = time;
		this.awards = awards;
		this.studios = studios;
		this.hasSisterMovies = hasSisterMovies;
	}

	//Getters and Setters
	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public LinkedList<String> getAwards() {
		return awards;
	}

	public void setMovieAwards(LinkedList<String> awards) {
		this.awards = awards;
	}

	public LinkedList<String> getStudios() {
		return studios;
	}

	public void setStudios(LinkedList<String> studios) {
		this.studios = studios;
	}

	public boolean isHasSisterMovies() {
		return hasSisterMovies;
	}

	public void setHasSisterMovies(boolean hasSisterMovies) {
		this.hasSisterMovies = hasSisterMovies;
	}
	
	public String toSave()
	{
		return "";
	}
}