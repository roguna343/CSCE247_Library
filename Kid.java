package Library247;

import java.util.LinkedList;

import org.json.*;

public class Kid extends User {
	
	public String parent;
	
	public Kid() {
		super();
		this.parent = "no parent";
	}
	
	public Kid(String name, int age, String username, String password, LinkedList<String> checkedItem, LinkedList<String> lookForItem, int birthday, double fines, boolean enabled, String notification, String parentName) {
		super(name, age, username, password, checkedItem, lookForItem, birthday, fines, enabled, notification);
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
		ret.put("lookForItem", this.lookForItem);
		ret.put("birthday", this.getBirthday());
		ret.put("fines", this.getFines());
		ret.put("enabled", this.isEnabled());
		ret.put("notification", this.notifications);
		ret.put("parent", this.getParent());
		return ret;
	}
}
