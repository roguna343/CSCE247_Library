package Library247;

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
		Item[] checkedItem, int birthday, double fines,
		boolean enabled) {
		this.getName();
		this.getAge();
		this.getUsername();
		this.getPassword();
		this.checkedItem = checkedItem;
		this.Birthday = Birthday;
		this.fines = fines;
		this.enabled = enabled;	
	}
	
	public Item[] getCheckedItem() {
		return checkedItem;
	}

	public void setCheckedItem(Item[] checkedItem) {
		this.checkedItem = checkedItem;
	}

	public String getBirthday() {
		return Birthday;
	}

	public void setBirthday(String birthday) {
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
		
	}
	
	public void checkIn(Item checkedInItem) {
		
	}
	
	public void donate(Item aDonation) {
		
	}
	
	public void getFees() {
		
	}

}
