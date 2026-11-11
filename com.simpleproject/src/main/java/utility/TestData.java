package utility;

public class TestData {

	private static String FULL_NAME;
	private static String EMAIL;
	private static String PASSWORD;
	
	public static void setFullname(String name) {
		
		FULL_NAME=name;
	}
	public static String getFullname() {
		
		return FULL_NAME;
		
	}
public static void setEmail(String email) {
		
	EMAIL=email;
	}
	
public static String getEmail() {
	
	return EMAIL;
	}
public static void setPassword(String password) {
	
	PASSWORD=password;
}
public static String getPassword() {
	
	return PASSWORD;
	
}
}
