package CSCE247_Library;

public class Adult extends User {
	public boolean hasKids;
	
	public Adult() {
		super();
		this.hasKids = false;
	}
	
	public Adult(String name, int age, String username, String password, 
			Item[] checkedItem, int birthday, double fines, boolean enabled,
			boolean hasKids) {
		super(name, age, username, password, checkedItem, birthday, fines,
				enabled);
		this.hasKids = false;
	}
	
	public String toString() {
		return null;
	}
}
