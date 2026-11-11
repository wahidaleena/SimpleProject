package utility;

public class UserContext {

	//we can use this code if the test methods that share same data reside inside same class, if not use getters and setters inside base class
	private static final ThreadLocal<String> FULL_NAME = new ThreadLocal<>();
	private static final ThreadLocal<String> EMAIL = new ThreadLocal<>();
	private static final ThreadLocal<String> PASSWORD = new ThreadLocal<>();

    public static void setFullName(String name) {
        FULL_NAME.set(name);
    }

    public static String getFullName() {
        return FULL_NAME.get();
    }
    public static void setEmail(String email) {
    	EMAIL.set(email);
    }
    public static String getEmail() {
    	
    	return EMAIL.get();
    }
    public static void setPassword(String pwd) {
    	
    	PASSWORD.set(pwd);
    	
    }
    public static String getPassword() {
    	
    	return PASSWORD.get();
    }

    public static void clear() {
        FULL_NAME.remove();
 
    }
    
}
