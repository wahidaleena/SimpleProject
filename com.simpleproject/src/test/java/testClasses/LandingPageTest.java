package testClasses;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import elementRepository.LandingPage;
import elementRepository.UserRegistration;

public class LandingPageTest extends BaseClass {
	
	LandingPage lp;
	UserRegistration ur;
	
	@Test(priority=0,description="To verify the text of page")
	public void verifyTheTextOfpage() {
		
		lp=new LandingPage(getDriver());
		String result=lp.getTheTextofPage();
		String expectedResult="POPULAR PRODUCTS";
		System.out.println("Text: "+result);
		Assert.assertEquals(result, expectedResult,"Page text is not matching");
		
	}
	@Test(priority = 1,description="To verify the title of page")
	public void verifyTheTitleOfPage() {
		
		lp=new LandingPage(getDriver());
		String actualResult=lp.getTitleOfPage();
		String expectedResult="Test Store";
		System.out.println("Title: "+actualResult);
		Assert.assertEquals(actualResult, expectedResult,"Title doesn't match");
	}
	
	@Test(priority = 2,description="To verify the user directs to account registration page")
	public void registerNewUser() {
		
		lp=new LandingPage(getDriver());
		ur=lp.registerNewUser();
		String expectedResult="Create an account";
		String actualResult=ur.getTextofHeading();
		System.out.println("Heading: "+actualResult);
		Assert.assertEquals(actualResult, expectedResult);
				
		
	}
	

}
