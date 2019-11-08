package CSCE247_Library;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Librarian extends People {
	private boolean isAdmin;
	
	public Librarian() {
		super();
		this.isAdmin = true;
	}
	
	public Librarian(String name, int age, String username, String password, 
			boolean admin) {
		super(name, age, username, password);
		this.isAdmin = admin;
	}
	
	public static double addFine(double accFine) {
		double fines = 5.00;
		fines = accFine;
		
		return fines;
	}
	
	public void viewDatabase(PeopleWriter per) {
		
	}

	public String toString() {
		return null;
	}
}
