package Library247;

import java.util.LinkedList;

import org.json.*;

public class Adult extends User {
	
	public boolean hasKids;
	
	public Adult() {
		super();
		this.hasKids = false;
	}
	
	public Adult(String name, int age, String username, String password, LinkedList<String> checkedItem, LinkedList<String> lookForItem, int birthday, double fines, boolean enabled, String notification, boolean hasKids) {
		super(name, age, username, password, checkedItem, lookForItem, birthday, fines, enabled, notification);
		this.hasKids = false;
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
