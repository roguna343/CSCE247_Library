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
		ret.put("hasKids", this.hasKids);
		return ret;
	}
}
