package CSCE247_Library;

import java.util.ArrayList;

public abstract class User extends People {
	public static final int LIMIT = 10;
	public Item[] checkedItem;
	public int Birthday;
	private double fines;
	private boolean enabled;
	
	public User() {
		super();
		this.checkedItem = new Item[LIMIT];
		this.Birthday = 0;
		this.fines = 0.0;
		this.enabled = false;
	}
	
	public User(String name, int age, String username, String password, 
			Item[] checkedItem, int birthday, double fines, boolean enabled) {
		super(name, age, username, password);
		this.checkedItem = checkedItem;
		this.Birthday = birthday;
		this.fines = fines;
		this.enabled = enabled;
	}

	public Item[] getCheckedItem() {
		return checkedItem;
	}

	public void setCheckedItem(Item[] checkedItem) {
		this.checkedItem = checkedItem;
	}

	public int getBirthday() {
		return Birthday;
	}

	public void setBirthday(int birthday) {
		Birthday = birthday;
	}

	public double getFines() {
		return fines;
	}

	public void setFines(double fines) {
		this.fines = fines;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	/**
	 * Need a database for this
	 */
	public void checkOut(Item checkedOutItem) {
		ArrayList<Item> withdraw = new ArrayList<Item>();
	}
	
	public void checkIn(Item checkedInItem) {
		ArrayList<Item> deposit = new ArrayList<Item>();
	}
	
	public void donate(Item aDonation) {
		ArrayList<Item> donation = new ArrayList<Item>();
	}
	
	public void getFees() {
		
	}
}
