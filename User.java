package Library247;

import java.util.LinkedList;

/**
 * This should of been combined with people, but due to time constraints, it was never combined.
 * @author thisi
 *
 */

public abstract class User extends People {
	private LinkedList<String> checkedItem;
	private LinkedList<String> lookForItem;
	private int Birthday;
	private double fines;
	private boolean enabled;
	
	public User() {
		super();
		this.checkedItem = new LinkedList<>();
		this.lookForItem = new LinkedList<>();
		this.Birthday = 0;
		this.fines = 0.0;
		this.enabled = false;
	}
	
	public User(String name, int age, String username, String password, LinkedList<String> checkedItem, LinkedList<String> lookForItem, int birthday, double fines, boolean enabled) {
		super(name, age, username, password);
		this.checkedItem = checkedItem;
		this.lookForItem = lookForItem;
		this.Birthday = birthday;
		this.fines = fines;
		this.enabled = enabled;
	}

	public LinkedList<String> getCheckedItem() {
		return checkedItem;
	}

	public void setCheckedItem(LinkedList<String> checkedItem) {
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
	
	public LinkedList<String> getLookForItem() {
		return lookForItem;
	}

	public void setLookForItem(LinkedList<String> lookForItem) {
		this.lookForItem = lookForItem;
	}

	public abstract String getInfo();
}