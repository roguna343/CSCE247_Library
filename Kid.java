package CSCE247_Library;

public class Kid extends User {
	
	public Adult parent;
	private boolean grownUp;
	
	public Kid() {
		super();
		this.parent = new Adult();
		grownUp = false;
	}
	
	public Kid(Adult aParent) {
		this.getName();
		this.getAge();
		if(this.getAge() >= 18) {
			this.growUp();
		}
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
		grownUp = true;
	}

	public String toString() {
		return null;
	}
	
	
}
