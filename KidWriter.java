package Library247;

import java.io.FileWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class KidWriter {

	private static final String KID_FILE = "src/Library247/kid.json";
	
	public static void main(String[] args) {
		
		JSONArray kidList = new JSONArray();
		
		JSONObject kid1 = new JSONObject();
		kid1.put("name", "Rick");
		kid1.put("age", 15);
		kid1.put("username", "ricky");
		kid1.put("password", "password1");
		kidList.add(kid1);
		
		JSONObject kid2 = new JSONObject();
		kid2.put("name", "Morty");
		kid2.put("age", 13);
		kid2.put("username", "morty");
		kid2.put("password", "password2");
		kidList.add(kid2);
		
		try {
			FileWriter fw = new FileWriter(KID_FILE);
			fw.write("{\"kids\": [");
			for(int i = 0; i < kidList.size(); i++) {
				fw.write(prettify(kidList.get(i).toString()));
				if(i != kidList.size()-1) {
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
