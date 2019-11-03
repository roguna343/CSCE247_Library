package CSCE247_Library;

public class Librarian extends People {
	public boolean isAdmin;
	
	public Librarian() {
		super();
		this.isAdmin = false;
	}
	
	public Librarian(boolean admin) {
		this.getName();
		this.getAge();
		this.getUsername();
		this.getPassword();
		this.isAdmin = admin;
	}
	public void addItem(Item anItem) {
		
	}
	
	public void remove(Item anItem) {
		
	}

	public String toString() {
		return null;
	}
}
