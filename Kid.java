package Library247;

import java.util.LinkedList;

import org.json.*;

public class Kid extends User {
	
	public Adult parent;
	
	public Kid() {
		super();
		this.parent = new Adult();
	}
	
	public Kid(String name, int age, String username, String password, LinkedList<String> checkedItem, LinkedList<String> lookForItem, int birthday, double fines, boolean enabled, String notification, Adult aParent) {
		super(name, age, username, password, checkedItem, lookForItem, birthday, fines, enabled, notification);
		this.parent = aParent;
	}

	public Adult getParent() {
		return parent;
	}

	public void setParent(Adult parent) {
		this.parent = parent;
	}
	
	public String toString() {
		return null;
	}	
	
	public JSONObject getJSON() throws Exception{
		JSONObject ret = new JSONObject();
		ret.put("name", this.getName());
		ret.put("age", this.getAge());
		ret.put("username", this.getUsername());
		ret.put("password", this.getPassword());
		return ret;
	}
}
