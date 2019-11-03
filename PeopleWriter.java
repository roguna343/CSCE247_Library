package Library247;

import java.io.FileWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.util.ArrayList;

public class PeopleWriter {
	
	private static final String PEOPLE_FILE = "src/Library247/people.json";
	 
	public static void main(String[] args) {
		
		JSONArray peopleList = new JSONArray();
		
		JSONObject person1 = new JSONObject();
		person1.put("name", "Brad");
		person1.put("age", 21);
		person1.put("username", "brad23");
		person1.put("password", "password1");
		peopleList.add(person1);
		
		JSONObject person2 = new JSONObject();
		person2.put("name", "Chad");
		person2.put("age", 21);
		person2.put("username", "chad23");
		person2.put("password", "stacy");
		peopleList.add(person2);
	
		try {
				FileWriter fw = new FileWriter(PEOPLE_FILE);
				fw.write("{\"people\": [");
				for(int i = 0; i < peopleList.size(); i++) {
					fw.write(prettify(peopleList.get(i).toString()));
					if(i != peopleList.size()-1) {
						fw.write(",\n");
					}
				}
				fw.write("\n] }");
				
				fw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public static String prettify(String toEdit) {
		return toEdit.replace(",\"", ",\n\"").replace("{", "{\n").replace("}", "\n}");
	}

}
