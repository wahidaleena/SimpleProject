package testClasses;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseClass;
import dataProvider.DataProviderClass;
import elementRepository.AccountPage;
import elementRepository.LandingPage;
import elementRepository.SignInPage;
import utility.Constants;
import utility.ExcelRead;
import utility.TestData;
import utility.UserContext;

public class SignInTest extends BaseClass {
	
	LandingPage lp;
	SignInPage sp;
	AccountPage ap;
	
	@Test(priority=0,description="verify successful login")
	public void verifySuccessfulLogin() throws IOException {
		
		lp=new LandingPage(getDriver());
		sp=lp.clickOnsignIn();
		//String email=TestData.getEmail();
		//String pwd=TestData.getPassword();
		String fullname = ExcelRead.getStringData(1, 0, "Registered Users");
		String email    = ExcelRead.getStringData(1, 1, "Registered Users");
		String password = ExcelRead.getStringData(1, 2, "Registered Users");
		ap=sp.signIn(email, password);	
		String actualResult=ap.getAccountName();
		String expectedResult=fullname;
		System.out.println("Account name after login: "+expectedResult);
		Assert.assertEquals(actualResult, expectedResult,"Invalid user");
				
		
	}
	
	@Test(priority=1,description="Unsuccessful login with invalid email and valid password",groups= {"smoke"})
    public void verifyUnsuccessfulLoginWithInvalidUsername() throws IOException {
		
		lp=new LandingPage(getDriver());
		sp=lp.clickOnsignIn();
		String email=Constants.invalidEmail;
		String pwd=ExcelRead.getStringData(1, 2, "Registered Users");
		ap=sp.signIn(email, pwd);
		boolean actualResult=sp.checkIfErrorMsgDisplayedInInvalidLogin();
		String expectedResult=Constants.authError;
		System.out.println("Unsuccessful login  scenario 1 done");
		Assert.assertTrue(actualResult,"Error message is not displayed");
		
	}
	@Test(priority=2,description="Unsuccessful login with invalid email and valid password",groups= {"smoke"})
    public void verifyUnsuccessfulLoginWithInvalidPassword() throws IOException {
		
		lp=new LandingPage(getDriver());
		sp=lp.clickOnsignIn();
		String email=ExcelRead.getStringData(1, 1, "Registered Users");;
		String pwd=Constants.invalidPassword;
		ap=sp.signIn(email, pwd);	
		String actualResult=sp.getErrorMessageOnInvalidLogin();
		String expectedResult=Constants.authError;
		System.out.println("Unsuccessful login  scenario 2 done");
		Assert.assertEquals(actualResult, expectedResult);
	}
	@Test(priority=3,description="Unsuccessful login with invalid email and invalid password",groups= {"smoke"})
    public void verifyUnsuccessfulLoginWithInvalidusernameAndPassword() {
		
		lp=new LandingPage(getDriver());
		sp=lp.clickOnsignIn();
		String email=Constants.invalidEmail;
		String pwd=Constants.invalidPassword;
		ap=sp.signIn(email, pwd);
		String actualResult=sp.getErrorMessageOnInvalidLogin();
		String expectedResult=Constants.authError;
		System.out.println("Unsuccessful login  scenario 3 done");
		Assert.assertEquals(actualResult, expectedResult);
		
	}
	@Test(priority=4,description="Unsuccessful login with blank email and invalid password")
	@Parameters("browser")
    public void verifyUnsuccessfulLoginWithBlankusername(String browser) {
		
		lp=new LandingPage(getDriver());
		sp=lp.clickOnsignIn();
		String email=Constants.blankEmail;
		String pwd=Constants.invalidPassword;
		ap=sp.signIn(email, pwd);
		String actualResult=sp.getErrorMessageOfEmail();
		String expectedResult="";
		if(browser.equals("chrome")) {
		expectedResult=Constants.errMsgBlankFieldChrome;
		}
		else if(browser.equals("firefox")) {
			
			expectedResult=Constants.errMsgBlankFieldFirefox;
		}
		else
			throw new IllegalArgumentException("Browser not supported"+browser);
		System.out.println(actualResult);
		System.out.println("Unsuccessful login  scenario 4 done");
		Assert.assertEquals(actualResult, expectedResult,"Validation error message does not match");
		
	}
	
}
