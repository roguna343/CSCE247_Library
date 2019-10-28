package Library247;

import java.util.LinkedList;

public class Book extends Item {
	
	enum bookType {
		hardback, paperback, audiobook, ebook;
	}

	private int pages;
	private LinkedList<String> awards;
	private LinkedList<String> publisher;
	private String edition;
	private bookType type;

	public Book() {
		super();
		this.pages = 0;
		this.awards = null;
		this.publisher = null;
		this.edition = null;
		this.type = null;
	}

	public Book(int pages, LinkedList<String> awards, LinkedList<String> publisher,
			String edition, bookType type) {

		this.getAuthor();
		this.getTitle();
		this.getYear();
		this.getGenre();
		this.getDesc();
		this.getBorrower();
		this.pages = pages;
		this.awards = awards;
		this.publisher = publisher;
		this.edition = edition;
		this.type = type;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public LinkedList<String> getAwards() {
		return awards;
	}

	public void setAwards(LinkedList<String> awards) {
		this.awards = awards;
	}

	public LinkedList<String> getPublisher() {
		return publisher;
	}

	public void setPublisher(LinkedList<String> publisher) {
		this.publisher = publisher;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public bookType getType() {
		return type;
	}

	public void setType(bookType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		String ret;
		ret = "Book Title: " + this.getTitle() + "\n";
		ret += "Author: " + this.getAuthor() + "\n";
		ret += "Year: " + this.getYear() + "\n";
		ret += "Book Desc: " + this.getDesc() + "\n";
		ret += "Part of Series: " + this.getSeries() + "\n";
		ret += "Awards: " + this.getAwards();
		return ret;
	}
}
