package elementRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.GeneralUtilities;
import utility.WaitUtility;

public class AccountPage {
	
	private WebDriver driver;
	GeneralUtilities gl=new GeneralUtilities();
	WaitUtility wu=new WaitUtility();
	
	public AccountPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"_desktop_user_info\"]/div/a[2]/span")
	WebElement accountName;
	
	public String getAccountName() {
		
		wu.explicitWaitVisibilityOfElementLocator(driver, By.xpath("//*[@id=\"_desktop_user_info\"]/div/a[2]/span"));
		return gl.getTextOfElement(accountName);
	}

}
