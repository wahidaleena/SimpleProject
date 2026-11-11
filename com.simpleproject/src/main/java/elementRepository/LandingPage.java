package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.GeneralUtilities;
import utility.WaitUtility;

public class LandingPage {

	private WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	WaitUtility wu = new WaitUtility();

	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	@FindBy(css="[alt='Test Store']")
	WebElement logo;
	@FindBy(xpath="//*[@id=\"content\"]/section[1]/h2")
	WebElement text;
	@FindBy(xpath="//*[@id=\"_desktop_user_info\"]/div/a/span")
	WebElement signinButton;
	@FindBy(xpath = "//*[@id=\"content\"]/div/a")
	WebElement createAccount;
	
	
	public String getTheTextofPage() {
		
		return gu.getTextOfElement(text);
	}
	
	public String getTitleOfPage() {
		
		return gu.getTitleOfPage(driver);
		
	}
	public UserRegistration registerNewUser() {
		
		signinButton.click();
		wu.explicitWaitClickable(driver, createAccount);
		createAccount.click();
		return new UserRegistration(driver);
	}
	public SignInPage clickOnsignIn() {
		
		signinButton.click();
		return new SignInPage(driver);
		
	}
	

}
