package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.latest.fedcm.model.Account;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.GeneralUtilities;

public class UserRegistration {
	
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();

	public UserRegistration(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(tagName = "h1")
	WebElement heading;
	@FindBy(id="field-id_gender-1")
	WebElement female;
	@FindBy(name="firstname")
	WebElement firstName;
	@FindBy(name="lastname")
	WebElement lastName;
	@FindBy(name="email")
	WebElement emailField;
	@FindBy(id="field-password")
	WebElement password;
	@FindBy(id="field-birthday")
	WebElement birthdate;
	@FindBy(name="optin")
	WebElement checkbox1;
	@FindBy(css="[type='submit'")
	WebElement saveButton;
	@FindBy(xpath="//*[@id=\"customer-form\"]/div/div[8]/div[1]/span/label/input")
	WebElement agree;
	
	
	public String getTextofHeading() {
		
		return gu.getTextOfElement(heading);
		
	}
	public AccountPage createAnAccount(String fname,String lname,String email,String pwd,String bday ) {
		
		female.click();
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		emailField.sendKeys(email);
		password.sendKeys(pwd);
		birthdate.sendKeys(bday);
		checkbox1.click();
		agree.click();
		saveButton.click();
		return new AccountPage(driver);
		
		
	}

}
