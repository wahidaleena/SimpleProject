package dataProvider;

import org.testng.annotations.DataProvider;

import utility.RandomDataUtility;
import utility.UserContext;

public class DataProviderClass {
	
	
	@DataProvider(name="UserRegistration")
	public Object[][]dp1(){
		
		String fname=RandomDataUtility.getFirstName();
		String lname=RandomDataUtility.getLastName();
		
		return new Object[][] {
			
			
			
			new Object[]{fname,lname,RandomDataUtility.getEmail(),
				RandomDataUtility.getPassword(),RandomDataUtility.getDateOfBirth()}
			
			//multiple data sets for stress testing
			/*new Object[] {RandomDataUtility.getFirstName(),
					RandomDataUtility.getLastName(),RandomDataUtility.getEmail(),RandomDataUtility.getPassword(),
					RandomDataUtility.getDateOfBirth()} ;*/
		};
		
		
	}
	
	@DataProvider(name="signIn")
	public Object[][]dp2(){
		
		
		return new Object[][] {
			
			new Object[] {UserContext.getEmail(),UserContext.getPassword()}
		};
		
		
	}
}

