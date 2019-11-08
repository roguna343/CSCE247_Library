package Library247;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.FileWriter;

public class AdultWriter {
	
	private static final String ADULT_FILE = "src/Library247/adult.json";
	

	public static void main(String[] args) {
		
		JSONArray adultList = new JSONArray();
		
		JSONObject adult1 = new JSONObject();
		adult1.put("name", "Michael");
		adult1.put("age", 35);
		adult1.put("username", "michaeljscott");
		adult1.put("password", "dundermifflin");
		adultList.add(adult1);
		
		JSONObject adult2 = new JSONObject();
		adult2.put("name", "Dwight");
		adult2.put("age", 40);
		adult2.put("username", "dwightkschrute");
		adult2.put("password", "schrutefarms");
		adultList.add(adult2);
		
		try {
				FileWriter fw = new FileWriter(ADULT_FILE);
				fw.write("{\"adults\": [");
				for(int i = 0; i < adultList.size(); i++) {
					fw.write(prettify(adultList.get(i).toString()));
					if(i != adultList.size()-1) {
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
