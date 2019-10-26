package Library247;

import java.util.LinkedList;

public class Video extends Item {
	
	private int time;
	private LinkedList<String> awards;
	private LinkedList<String> studios;
	private boolean hasSisterMovies;
	
	public Video() {
		super();
		time = 0;
		awards = new LinkedList<String>();
		studios = new LinkedList<String>();
		hasSisterMovies = false;
	}
	
	public Video(String title, int year, String desc, int time, LinkedList<String> studios, 
			LinkedList<String> awards, boolean hasSisterMovies, LinkedList<String[]> borrower) {
		super.setTitle(title);
		super.setYear(year);
		super.setDesc(desc);
		this.time = time;
		this.awards = awards;
		this.studios = studios;
		this.hasSisterMovies = hasSisterMovies;
		super.setBorrower(borrower);
	}

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
	
	public String toString() {
		return "\nVideo title: " + super.getTitle() +
				"\nYear: " + super.getYear() +
				"\nVideo description: " + super.getDesc() +
				"\nTime: " + this.time +
				"\nStudio(s): " + this.studios +
				"\nAwards: " + this.awards +
				"\nHas any prequels/sequels? " + (this.hasSisterMovies ? "yes" : "no") +
				"\nBorrower: " + super.getBorrower().size();
	}

}
