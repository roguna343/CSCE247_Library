package Library247;

import org.json.JSONObject;

public abstract class People {
	private String name;
	private int age;
	private String username;
	private String password;
	
	public People() {
		this.name = null;
		this.age = 0;
		this.username = null;
		this.password = null;
	}
	
	public People(String name, int age, String[] loginCred) {
		this.name = null;
		this.age = 0;
		this.username = null;
		this.password = null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public static Adult from(Kid aKid) {
		Adult toAdult = new Adult();
		return toAdult;
	}
	// this causes the child to become an adult
	
	public JSONObject getJSON() throws Exception {
		JSONObject ret = new JSONObject();
		ret.put("name", this.getName());
		ret.put("age", this.getAge());
		ret.put("username", this.getUsername());
		ret.put("password", this.getPassword());
		return ret;
	}
}
