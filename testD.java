package Library247;

import java.io.*;
import org.json.simple.*;

public class testD {
	public static void main(String[] args) { 
		// TODO Auto-generated method stub
		try {
			Item mag = new Magazine();
			Item video = new Video();
			Item book = new Book();
			book.setTitle("hey");
			
			JSONArray test = new JSONArray();
			test.add(book.getJSON());
			//test.add(video.getJSON());
			//test.add(mag.getJSON());
			
			FileWriter file = new FileWriter("C:\\Users\\thisi\\eclipse-workspace\\247\\src\\Library247\\Data.json");
			//System.out.println(test.toJSONString());
			file.write(test.toJSONString());
			file.flush();
			file.close();
			//file.flush();
			System.out.println(test);
			
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
		
		/*
		try (FileWriter file = new FileWriter("employees.json")) {
			 
            file.write(employeeList.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }*/
		
	}

}
