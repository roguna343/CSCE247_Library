package CSCE247_Library;

public class testP {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		People adult = new Adult();
		People kid = new Kid();
		System.out.println(adult.getPassword());
		System.out.println(kid.getClass().equals(Adult.class));
		
	}
}
