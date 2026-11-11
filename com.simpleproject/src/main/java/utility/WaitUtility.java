package utility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	
	
	public void explicitWaitVisibilityOfElementLocator(WebDriver driver,By locator) {
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(Constants.time));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
	}
	
	public void implicitWait(WebDriver driver) {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.time));
	}
	
	public void explicitWaitClickable(WebDriver driver,WebElement element) {
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(Constants.time));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}

}
