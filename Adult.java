package Library247;

import java.util.LinkedList;
import org.json.*;

public class Adult extends User { 
	
	private boolean hasKids; /**Has a unique boolean making it set apart from kid**/
	
	public Adult() {
		super();
		this.hasKids = false;
	}
	
	public Adult(String name, int age, String username, String password, LinkedList<String> checkedItem, LinkedList<String> lookForItem, int birthday, double fines, boolean enabled, boolean hasKids) {
		super(name, age, username, password, checkedItem, lookForItem, birthday, fines, enabled);
		this.hasKids = false;
	}
	
	public boolean getHasKids()
	{
		return this.hasKids;
	}
	
	public void setHasKids(boolean setTo)
	{
		this.hasKids = setTo;
	}
	
	/**Abstract methods built to work with fileIO and console interface respectively**/
	public JSONObject getJSON() throws Exception { //Could have been demoted from abstract to include super to shorten it
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
		ret.put("hasKids", this.hasKids);
		return ret;
	}

	@Override
	public String getInfo() { //Used for patron method
		String ret = "Name: " + this.getName() + "\n"
				+ "Age: " + this.getAge() + "\n"
				+ "Birthday: " + this.getBirthday() + "\n"
				+ "Fines: " + this.getFines() + "\n"
				+ "Has Kids: " + this.getHasKids();
		return ret;
	}
}
