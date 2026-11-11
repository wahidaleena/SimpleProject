package com.simpleproject;

import java.awt.Window;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v150.page.Page.SetWebLifecycleStateState;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test {
	
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.get("https://automationtesting.co.uk/");
		driver.manage().window().maximize();
		Actions action = new Actions(driver);
		WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement tableTab=driver.findElement(By.xpath("//*[@id=\"menu\"]/ul/li[19]/a"));
		js.executeScript("arguments[0].scrollIntoView(true);", tableTab);
		tableTab.click();
		WebElement table=driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[1]/div/table/tbody/tr[1]/td[5]"));
		System.out.println("The selected country is: "+table.getText());
		
		WebElement nameHead=driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[1]/div/table/thead/tr/th[1]"));
		nameHead.click();
		waits.until(ExpectedConditions.attributeContains(nameHead, "class", " sorttable_sorted"));
		//here we get the specific column values using nth-child(column number)
		List<WebElement>firstnamesList=driver.findElements(By.cssSelector("table.sortable tbody tr td:nth-child(1)"));
		for(WebElement name:firstnamesList) {
			System.out.println(name.getText());
		}
		 List<WebElement> tableRows=driver.findElements(By.xpath("//*[@id=\"main\"]/div/div[1]/div/table/tbody/tr"));
		System.out.println("No.of rows= "+tableRows.size());
		
		List<WebElement> tableCols=driver.findElements(By.xpath("//*[@id=\"main\"]/div/div[1]/div/table/tbody/tr[1]/td"));
		System.out.println("No.of columns= "+tableCols.size());
		
		/*WebElement searchTab=driver.findElement(By.xpath("//*[@id=\"menu\"]/ul/li[18]/a"));
		js.executeScript("arguments[0].scrollIntoView(true);", searchTab);
		searchTab.click();
		WebElement searchBar=driver.findElement(By.id("myInput"));
		waits.until(ExpectedConditions.visibilityOf(searchBar));
		searchBar.sendKeys("Fr");
		By searchList=By.cssSelector("#myInputautocomplete-list > div");
		waits.until(ExpectedConditions.numberOfElementsToBeMoreThan(searchList, 0));
		List<WebElement> recom=driver.findElements(searchList);
		for(WebElement item:recom) {
			System.out.println("Suggestionns are: ["+item.getText()+"]");
			if(item.getText().trim().equals("France")) {
				System.out.println("Country found");
				item.click();
				WebElement but=waits.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"main\"]/div/div[1]/div/button")));
				but.click();
				WebElement msg=driver.findElement(By.id("info"));
				waits.until(ExpectedConditions.visibilityOf(msg));
				System.out.println("Result= "+msg.getText());
				break;
				
				
				
			}
		}
		
		*/
		
		/*WebElement loginTab=driver.findElement(By.xpath("//*[@id=\"menu\"]/ul/li[15]/a"));
		js.executeScript("arguments[0].scrollIntoView(true);", loginTab);
		loginTab.click();
		WebElement user=driver.findElement(By.cssSelector("input[type='text']"));
		user.sendKeys("test");
		WebElement pass=driver.findElement(By.xpath("//input[2]"));
		pass.sendKeys("test123");
		WebElement but=driver.findElement(By.id("login_btn"));
		but.click();
		Alert alert=driver.switchTo().alert();
		alert.accept();
		System.out.println("finished");
		*/
		
		/*WebElement popTab=driver.findElement(By.xpath("//*[@id=\"menu\"]/ul/li[17]/a"));
		js.executeScript("arguments[0].scrollIntoView(true);", popTab);
		popTab.click();
		WebElement but=driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[1]/div/button"));
		String parentWindow=driver.getWindowHandle();	
		but.click();
		
		
		waits.until(ExpectedConditions.numberOfWindowsToBe(2));
		Set<String> windowHandles=driver.getWindowHandles();
		
		for(String window:windowHandles) {
			if(!window.equals(parentWindow)) {
				driver.switchTo().window(window);
				
				//System.out.println("switched to child");
				//waits.until(ExpectedConditions.titleContains("blank"));
				//System.out.println(driver.getCurrentUrl());
				//By text=By.tagName("p");
				// WebElement popupText=waits.until(ExpectedConditions.visibilityOfElementLocated(text));
				
				//System.out.println("popup text: "+popupText.getText());
				//driver.close();
				//driver.switchTo().window(parentWindow);
				 /*waits.until(d -> {
			            try {
			                d.getWindowHandle();
			                return true;
			            } catch (NoSuchWindowException e) {
			                return false;
			            }
			        });
				 System.out.println("1 - Switched");
				 System.out.println("Parent"+parentWindow);

				 System.out.println("2 - Handle: " + driver.getWindowHandle());

				 By text = By.tagName("body");

				 System.out.println("5 - Looking for paragraph");

				 System.out.println("Popup text: " + driver.findElement(text).getText());

				 System.out.println("6 - Text printed");
				break;
			}
		}
		
		
		
		WebElement alerBut=driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div/button"));
		alerBut.click();
		waits.until(ExpectedConditions.alertIsPresent());
		Alert alert=driver.switchTo().alert();
		System.out.println("Msg is: "+alert.getText());
		alert.accept();
		*/
		
		/*WebElement hidTab=driver.findElement(By.xpath("//*[@id=\"menu\"]/ul/li[11]/a"));
		hidTab.click();
		WebElement hidd=driver.findElement(By.id("myDIV"));
		System.out.println("Before click: "+hidd.isDisplayed());
		WebElement bbut=driver.findElement(By.tagName("button"));
		bbut.click();
		System.out.println("After click: "+hidd.isDisplayed());
		By hidPar=By.cssSelector("p[hidden]");
		WebElement par=driver.findElement(hidPar);
		System.out.println("Is displayed? "+par.isDisplayed());
		*/
		
		/*
		//webelement
		WebElement uploadTab=driver.findElement(By.xpath("//*[@id=\"menu\"]/ul/li[10]/a"));
		uploadTab.click();
		//locator
		By choosefile=By.id("fileToUpload");
		WebElement fileElement=waits.until(ExpectedConditions.presenceOfElementLocated(choosefile));
		fileElement.sendKeys("/Users/aleena/Documents/pic.png");
		//to get the uploaded filepath+name
		System.out.println("File is: "+fileElement.getAttribute("value"));
		
		*/
		
		
		/*driver.findElement(By.xpath("//*[@id=\"menu\"]/ul/li[8]/a")).click();
		WebElement date=driver.findElement(By.id("basicDate"));
		date.click();
		By dateSel=By.cssSelector("[aria-label='September 9, 2026']");	
		waits.until(ExpectedConditions.elementToBeClickable(dateSel)).click();
		System.out.println("Date selected is: "+driver.findElement(dateSel).getAttribute("aria-label"));
		//use By directly if the calendar re-renders to avoid stale exception
		*/
		
		
		
		//WebElement tab1=driver.findElement(By.xpath("//*[@id=\"menu\"]/ul/li[5]/a"));
		//tab1.click();
		
		/*WebElement form=driver.findElement(By.xpath("//*[@id=\"menu\"]/ul/li[7]/a"));
		form.click();
		WebElement fname=driver.findElement(By.name("first_name"));
		fname.sendKeys("Aleena");
		WebElement lname=driver.findElement(By.name("last_name"));
		lname.sendKeys("Wahid");
		WebElement email=driver.findElement(By.name("email"));
		email.sendKeys("wah@gmail.com");
		WebElement msg=driver.findElement(By.name("message"));
		msg.sendKeys("thank you");
		WebElement but=driver.findElement(By.xpath("//*[@id=\"form_buttons\"]/input[2]"));
		but.submit();
		WebElement head=driver.findElement(By.tagName("h3"));
		waits.until(ExpectedConditions.visibilityOf(head));
		System.out.println("Result: "+head.getText());
		driver.navigate().back();
		*/
		
		
		
		/*WebElement but1=driver.findElement(By.xpath("//*[@id=\"btn_one\"]"));
		 
		System.out.println("Text: "+but1.getText());
		but1.click();
		driver.switchTo().alert().accept();
		
		WebElement but2=driver.findElement(By.cssSelector("#btn_two"));
		//WebElement but3=driver.findElement(By.cssSelector("#btn_three"));
		//System.out.println("Text: "+but2.getText());
		//js.executeScript("arguments[0].click();", but2);
		
		System.out.println("Text: "+but3.getText());
		System.out.println("Displayed: " + but3.isDisplayed());
		System.out.println("Enabled: " + but3.isEnabled());
		waits.until(ExpectedConditions.elementToBeClickable(but3));
		action.moveToElement(but3).click().build().perform();
		waits.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		
		
			try {
				WebElement but4 = driver.findElement(By.cssSelector("#btn_four"));
				System.out.println("Is enabled? " + but4.isEnabled());
				but4.click();
			}

			
		 catch (ElementClickInterceptedException e) {
			System.out.println("element cannot be interacted with");
		}
			finally {
				driver.quit();
			} 
	*/	
		
/*
		// window handle
		WebElement browserTab = driver.findElement(By.xpath("//*[@id=\"menu\"]/ul/li[4]/a"));
		browserTab.click();

		String parentWindowHandle = driver.getWindowHandle();
		System.out.println("Parent Window handle: " + parentWindowHandle);

		WebElement buttoN = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/form/input"));
		waits.until(ExpectedConditions.elementToBeClickable(buttoN));
		buttoN.click();
		// js.executeScript("arguments[0].click();", buttoN);
		waits.until(ExpectedConditions.numberOfWindowsToBe(2));
		for (String tab : driver.getWindowHandles()) {
			if (!tab.equals(parentWindowHandle)) {
				System.out.println("Child window:"+tab);
				driver.switchTo().window(tab);
				break;
			}
		}
		System.out.println("Title:" + driver.getTitle());

		// Wait practise

		
		 * WebElement
		 * actionsTab=driver.findElement(By.xpath("//*[@id=\"menu\"]/ul/li[3]/a"));
		 * actionsTab.click(); WebElement
		 * button1=driver.findElement(By.id("dragtarget")); WebElement
		 * button2=driver.findElement(By.xpath(
		 * "//*[@id=\"main\"]/div/div[1]/div[1]/div[2]")); Actions actions=new
		 * Actions(driver); actions.dragAndDrop(button1, button2).perform(); WebElement
		 * res=driver.findElement(By.id("demo"));
		 * System.out.println("The text is: "+res.getText());
		 * 
		 * WebElement button3=driver.findElement(By.id("click-box"));
		 * actions.clickAndHold(button1).perform();
		 * System.out.println("The message when hold is: "+button3.getText());
		 * 
		 * WebElement doubButt=driver.findElement(By.xpath("//*[@id=\"click-box\"]"));
		 * actions.doubleClick(doubButt).perform();
		 * 
		 * WebElement
		 * shiftBut=driver.findElement(By.xpath("//p[text()='Hold Shift & Click Here']")
		 * );
		 * actions.moveToElement(shiftBut).click().keyDown(Keys.SHIFT).keyUp(Keys.SHIFT)
		 * .build().perform();
		 * 
		 * driver.switchTo().alert().accept();
		 * 
		 * WebElement acc=driver.findElement(By.xpath("//*[@id=\"menu\"]/ul/li[2]/a"));
		 * acc.click(); WebElement
		 * header1=driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div[1]"));
		 * waits.until(ExpectedConditions.elementToBeClickable(header1));
		 * header1.click(); WebElement
		 * content=driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div[2]"));
		 * waits.until(ExpectedConditions.visibilityOf(content));
		 * System.out.println("The content is"+"\n"+content.getText());
		 * System.out.println(content.getAttribute("aria-expanded"));
		 * 
		 * 
		 * 
		 * WebElement
		 * loadermenu=driver.findElement(By.xpath("//*[@id=\"menu\"]/ul/li[13]/a"));
		 * js.executeScript("arguments[0].scrollIntoView(true);", loadermenu);
		 * action.moveToElement(loadermenu).click().build().perform();
		 * 
		 * WebElement buttonDis=driver.findElement(By.id("loaderBtn")); //implicit wait
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 * buttonDis.click(); WebElement
		 * afterDis=driver.findElement(By.id("p_wording"));
		 * System.out.println("Displayed text: "+afterDis.getText());
		 * 
		 * WebElement
		 * loader2=driver.findElement(By.xpath("//*[@id=\"menu\"]/ul/li[14]/a"));
		 * loader2.click(); //fluent wait
		 * 
		 * FluentWait<WebDriver> wait=new
		 * FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
		 * .pollingEvery(Duration.ofSeconds(1)) .ignoring(NoSuchElementException.class);
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("appears")));
		 * 
		 * WebElement
		 * frametab=driver.findElement(By.xpath("//*[@id=\"menu\"]/ul/li[12]/a"));
		 * frametab.click();
		 * 
		 * WebElement frameLoc=driver.findElement(By.xpath(
		 * "//*[@id=\"main\"]/div/div[1]/div/iframe"));
		 * driver.switchTo().frame(frameLoc); WebElement
		 * toggleBut=driver.findElement(By.className("toggle")); toggleBut.click();
		 * WebElement home=driver.findElement(By.linkText("HOMEPAGE")); home.click();
		 * driver.switchTo().defaultContent();
		 * 
		 * driver.navigate().to("https://automationtesting.co.uk/dropdown.html");
		 * driver.manage().window().maximize();
		 * 
		 * 
		 * 
		 * //Radio button WebElement
		 * button=driver.findElement(By.name("demo-priority")); //button.click();
		 * js.executeScript("arguments[0].click();", button);
		 * 
		 * WebElement label=driver.findElement(By.xpath(
		 * "//*[@id=\"main\"]/div/div[1]/div[1]/div[1]/label"));
		 * 
		 * System.out.println("Selected radio button:"+label.getText());
		 * 
		 * 
		 * //Dropdown locate WebElement dropdown=driver.findElement(By.id("cars"));
		 * 
		 * //select dropdown Select select=new Select(dropdown);
		 * 
		 * //check if multiple options are there Boolean result=select.isMultiple();
		 * 
		 * System.out.println("Result: "+result); select.selectByIndex(3);
		 * 
		 * WebElement selectedOption=select.getFirstSelectedOption();
		 * System.out.println("Selected option: "+selectedOption.getText()); 
		 * String title=driver.getTitle();
		 * 
		 * //Navigation bar hover
		 * 
		 * WebElement
		 * hover1=driver.findElement(By.xpath("//*[@id=\"primary_nav_wrap\"]/ul/li[2]/a"
		 * )); action.moveToElement(hover1).click().build().perform();
		 * System.out.println("Navigation text: "+hover1.getText());
		 * 
		 * //Seleium waits- Explicit WebDriverWait wait2=new WebDriverWait(driver,
		 * Duration.ofSeconds(10));
		 * 
		 * WebElement hover2=driver.findElement(By.xpath(
		 * "//*[@id=\"primary_nav_wrap\"]/ul/li[2]/ul/li[1]/a"));
		 * wait2.until(ExpectedConditions.visibilityOf(hover2));
		 * action.moveToElement(hover2).build().perform();
		 * System.out.println("Navigation text2: "+hover2.getText());
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		driver.quit();
		

	}

}
