package Library247;

import org.json.JSONObject;

public abstract class People {
	private String name;
	private int age;
	private String username;
	private String password;
	
	public People() {
		this.name = "No name";
		this.age = 0;
		this.username = "No username";
		this.password = "No password";
	}
	
	public People(String name, int age, String username, String password) {
		this.name = name;
		this.age = 0;
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
	
	public abstract JSONObject getJSON() throws Exception;
}