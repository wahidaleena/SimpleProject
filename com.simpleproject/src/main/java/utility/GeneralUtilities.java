package utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GeneralUtilities {
	
	public String getTextOfElement(WebElement element) {
		
		return element.getText();
	}
	
	public void scrollThePageDown(WebDriver driver,WebElement element) {
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		
	}
	public String getAttributeOfElement(WebElement element,String attributeName) {
		
		return element.getAttribute(attributeName);
	}
	
	public void javascriptClick(WebDriver driver,WebElement element) {
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
		
	}
	
	public String getTitleOfPage(WebDriver driver) {
		
		return driver.getTitle() ;
		
	}
	public boolean checkIfTextIsDisplayed(WebElement element) {
		
		return element.isDisplayed() ;
		
		
	}
	public String getValidationErrorMessage(WebElement element,WebDriver driver) {
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String message=(String)js.executeScript("return arguments[0].validationMessage;", element);
		return message;
		
	}

}
