package CSCE247_Library;

public class Adult extends User {
	public boolean hasKids;
	
	public Adult() {
		super();
		this.hasKids = false;
	}
	
	public Adult(boolean hasKids) {
		this.getName();
		this.getAge();
		this.getUsername();
		this.getPassword();
		this.getCheckedItem();
		this.getFines();
		this.isEnabled();
		this.hasKids = false;
	}
	
	public void payFines() {
		
	}
	
	public String toString() {
		return null;
	}
}
