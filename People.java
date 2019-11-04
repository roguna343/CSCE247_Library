package CSCE247_Library;

import org.json.simple.JSONObject;

public abstract class People {
	
	private String name;
	private int age;
	private String username;
	private String password;
	
	public People() {
		this.name = "no name";
		this.age = 0;
		this.username = "no username";
		this.password = "no password";
	}
	
	public People(String name, int age, String username, String password) {
		this.name = name;
		this.age = age;
		this.username = username;
		this.password = password;
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
	
	public String toString() {
		return "Name: " + this.name + 
				"\nAge: " + this.age + 
				"\nUsername: " + this.username + 
				"\nPassword: " + this.password;
	}
	
	public JSONObject getJSON() throws Exception {
		JSONObject ret = new JSONObject();
		ret.put("name", this.getName());
		ret.put("age", this.getAge());
		ret.put("username", this.getUsername());
		ret.put("password", this.getPassword());
		return ret;
	}
}
