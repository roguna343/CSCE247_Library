package CSCE247_Library;

import java.util.Scanner;

public class logIn {
	public static void main(String[] args) {
	Scanner keyboard = new Scanner(System.in);
	
	final String userName = "TheAdmin";
	final String passWord = "password";
		
	System.out.println("Hello and welcome, administrator.");
		
	String inputUserName = keyboard.nextLine();
	String inputPassword = keyboard.nextLine();
		
	while(!inputUserName.contentEquals(userName) && 
			!inputPassword.contentEquals(passWord)) {
		System.out.println("We apologize that is incorrect please try again");
		inputUserName = keyboard.nextLine();
		inputPassword = keyboard.nextLine();
	}
		System.out.println("Hello Administrator! What would you like to do?");	
	}
}
