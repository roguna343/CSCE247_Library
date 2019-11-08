package CSCE247_Library;

public class Kid extends User {
	public Adult parent;
	
	public Kid() {
		super();
		this.parent = new Adult();
	}
	
	public Kid(String name, int age, String username, String password, Item[] 
			checkedItem, int birthday, double fines, boolean enabled, 
			Adult aParent) {
		super(name, age, username, password, checkedItem, birthday, fines, 
				enabled);
		this.parent = aParent;
	}

	public Adult getParent() {
		return parent;
	}

	public void setParent(Adult parent) {
		this.parent = parent;
	}
	
	public static Adult from(Kid aKid) {
		Adult toAdult = new Adult();
		return toAdult;
	}
	// this causes the child to become an adult

	public String toString() {
		return null;
	}	
}
