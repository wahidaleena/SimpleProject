package testClasses;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.IOException;

import org.openqa.selenium.devtools.latest.fedcm.model.Account;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import dataProvider.DataProviderClass;
import elementRepository.AccountPage;
import elementRepository.LandingPage;
import elementRepository.UserRegistration;
import utility.ExcelWrite;
import utility.RandomDataUtility;
import utility.TestData;
import utility.UserContext;

public class UserRegistrationTest extends BaseClass {
	
	LandingPage lp;
	UserRegistration ur;
	AccountPage ap;
	
	@Test(priority=0,description="To check if we can register a user on this application",dataProviderClass=DataProviderClass.class,dataProvider="UserRegistration",groups={"smoke"})
	public void verifyUserRegistration(String fname,String lname,String email,String pwd,String bdate) throws IOException {
		
		lp=new LandingPage(getDriver());
		ur=lp.registerNewUser();
		String fullName=fname+ " "+lname;
		//setters and getters used to store data and retrieve it in entire test execution
		//TestData.setFullname(fname+" "+lname);
		//TestData.setEmail(email);
		//TestData.setPassword(pwd);
		ExcelWrite.writeDataIntoExcelFile(fullName, email, pwd);
		ap=ur.createAnAccount(fname, lname, email,pwd,bdate);	
		String actualResult=ap.getAccountName();
		String expectedResult=fname+" "+lname;
		System.out.println("Account name: "+actualResult);
		System.out.println("Registration successfully done");
		Assert.assertEquals(actualResult, expectedResult);
	}

}
