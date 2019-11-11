package Library247;

import java.util.LinkedList;

import org.json.*;

public class Kid extends User {
	
	private String parent;
	
	/**
	 * Kid stands out from adult in that its gets the variable parent, and its fines act different. Kids can collect fines, but
	 * when they are trying to pay it, it will make the parents have the fines.
	 */
	
	public Kid() {
		super();
		this.parent = "no parent";
	}
	
	public Kid(String name, int age, String username, String password, LinkedList<String> checkedItem, LinkedList<String> lookForItem, int birthday, double fines, boolean enabled, String parentName) {
		super(name, age, username, password, checkedItem, lookForItem, birthday, fines, enabled);
		this.parent = parentName;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}
	
	public static Adult from(Kid toConvert) {
		Adult toAdult= new Adult();
		return toAdult;
	}
	
	public JSONObject getJSON() throws Exception {
		JSONObject ret = new JSONObject();
		ret.put("name", this.getName());
		ret.put("age", this.getAge());
		ret.put("username", this.getUsername());
		ret.put("password", this.getPassword());
		ret.put("checkedItem", this.getCheckedItem());
		ret.put("lookForItem", this.getLookForItem());
		ret.put("birthday", this.getBirthday());
		ret.put("fines", this.getFines());
		ret.put("enabled", this.isEnabled());
		ret.put("parent", this.getParent());
		return ret;
	}
	
	@Override
	public String getInfo() {
		String ret = "Name: " + this.getName() + "\n"
				+ "Age: " + this.getAge() + "\n"
				+ "Birthday: " + this.getBirthday() + "\n"
				+ "Fines: " + this.getFines() + "\n"
				+ "Parent: " + this.getParent();
		return ret;
	}
}
