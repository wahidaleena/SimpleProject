package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.GeneralUtilities;
import utility.WaitUtility;

public class SignInPage {
	
	private WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	WaitUtility wu=new WaitUtility();
	
	public SignInPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="field-email")
	WebElement email;
	@FindBy(id="field-password")
	WebElement password;
	@FindBy(id="submit-login")
	WebElement signInSubmit;
	@FindBy(xpath="//*[@id=\"content\"]/section/div/ul/li")
	WebElement authError;
	
public AccountPage signIn(String emailTab,String pwd) {
		
		
		email.sendKeys(emailTab);
		password.sendKeys(pwd);
		signInSubmit.click();
		return new AccountPage(driver);
		
	}
public String getErrorMessageOnInvalidLogin() {
	
	return gu.getTextOfElement(authError);
	
}
	public boolean checkIfErrorMsgDisplayedInInvalidLogin() {
		
		return gu.checkIfTextIsDisplayed(authError);
		
	}
	public String getErrorMessageOfEmail() {
		
		return gu.getValidationErrorMessage(email, driver);
		
	}

}
