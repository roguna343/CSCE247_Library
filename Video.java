package Library247;

import java.util.LinkedList;
import org.json.*;

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
	
	public Video(String title, String author, int year, String[] genre, String desc, LinkedList<String[]> borrower, String series, double[] ratings, LinkedList<String> comments, int time, LinkedList<String> studios, LinkedList<String> awards, boolean hasSisterMovies) {
		super(title, author, year, genre, desc, borrower, series, ratings, comments);
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
		ret.put("time", this.getTime());
		ret.put("awards", this.getAwards());
		ret.put("studios", this.getStudios());
		ret.put("hasSisterMovies", this.isHasSisterMovies());
		return ret;
	}
}