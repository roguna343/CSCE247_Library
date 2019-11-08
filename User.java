package Library247;

import java.util.LinkedList;

public abstract class User extends People {
	public static final int LIMIT = 10;
	public LinkedList<String> checkedItem;
	public LinkedList<String> lookForItem;
	public int Birthday;
	private double fines;
	private boolean enabled;
	String notifications;
	
	public User() {
		super();
		this.checkedItem = new LinkedList<>();
		this.lookForItem = new LinkedList<>();
		this.Birthday = 0;
		this.fines = 0.0;
		this.enabled = false;
	}
	
	public User(String name, int age, String username, String password, LinkedList<String> checkedItem, LinkedList<String> lookForItem, int birthday, double fines, boolean enabled, String notification) {
		super(name, age, username, password);
		this.checkedItem = checkedItem;
		this.lookForItem = lookForItem;
		this.Birthday = birthday;
		this.fines = fines;
		this.enabled = enabled;
		this.notifications = notification;
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

	public String getNotifications() {
		return notifications;
	}

	public void setNotifications(String notifications) {
		this.notifications = notifications;
	}

	public void checkout(Item check, int days)
	{
		if (fines != 0) {
			System.out.print("Please pay your fines of $" + this.getFines() + ".");
			return;
		}
		else if (this.checkedItem.size() >= LIMIT) {
			System.out.println("You have checked out the maximum amount of items.");
			return;
		}
		else {
			this.checkedItem.add(check.getTitle());
			String[] info = {this.getName(), Integer.toString(days)};
			LinkedList<String[]> borrowers = check.getBorrower();
			int index = 0;
			for (int a = 0; a < borrowers.size(); a++) {
				String[] temp = borrowers.get(a);
				if (temp[0].length() == 2) {
					index = a;
					break;
				}
			}
			borrowers.set(index, info);
			check.setBorrower(borrowers);
			System.out.println("Succesfully checked out the item");
		}
	}
	
	public void checkIn(Item check)
	{
		LinkedList<String[]> borrowers = check.getBorrower();
		int index = 0;
		for (int a = 0; a < borrowers.size(); a++) {
			String[] temp = borrowers.get(a);
			if (temp[0].equals(this.getName())) {
				index = a;
				break;
			}
		}
		String[] temp = {"", ""};
		borrowers.set(index, temp);
		check.setBorrower(borrowers);
		this.checkedItem.remove(check.getTitle());
		System.out.println("Succesfully checked in the item");
	}
	
}