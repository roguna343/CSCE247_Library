package CSCE247_Library;

public class Kid extends User {
	public Adult parent;
	
	public Kid() {
		super();
		this.parent = new Adult();
	}
	
	public Kid(Adult aParent) {
		this.getName();
		this.getAge();
		this.getUsername();
		this.getPassword();
		this.getCheckedItem();
		this.getFines();
		this.isEnabled();
		this.parent = aParent;
	}

	public Adult getParent() {
		return parent;
	}

	public void setParent(Adult parent) {
		this.parent = parent;
	}
	
	public void payFines() {
		
	}
	
	public void growUp() {
		
	}

	public String toString() {
		return null;
	}
	
	
}
