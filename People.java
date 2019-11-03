package Library247;

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
	
	public abstract String toString();
}
