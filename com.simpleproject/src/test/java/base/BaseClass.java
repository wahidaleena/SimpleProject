package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import extentReport.ExtentManager;
import extentReport.TestListener;
import retry.RetryListener;
import utility.Constants;
import utility.UserContext;

public class BaseClass {
	
	//to execute parallel execution with listeners threadlocal is safe
	private static ThreadLocal<WebDriver> driver=new ThreadLocal<>();
	//to make the tests run parallel we can change the driver from static variable to an instance variable
	public Properties prop;
	
	public static WebDriver getDriver() {
		
		return driver.get();
	}
	
public static void setDriver(WebDriver webdriver) {
		
		driver.set(webdriver);
	}
	

	//change static keyword from driver,prop and read property to resolve shared mutable state
	public void readProperty()throws IOException {
		
		prop=new Properties();
		FileInputStream f=new FileInputStream(System.getProperty("user.home")+"//eclipse-workspace//com.simpleproject//src//main//resources//config//config.properties");
		prop.load(f);
	}

	@BeforeSuite
	public void createExtentReport() {
		
		ExtentManager.createInstance();
		System.out.println("Extent report instance created");
	}
	
	@BeforeMethod(alwaysRun=true)
	@Parameters("browser")
	public void beforeMethod(String browser) throws IOException {
		
		//read the file and get in prop instance
		readProperty();
		
		WebDriver webdriver;
		//driver initialize
		if(browser.equalsIgnoreCase("chrome")) {
			
			webdriver=new ChromeDriver();
			System.out.println("#######Executing tests using " +browser+" driver");
		}
		
		else if(browser.equalsIgnoreCase("firefox"))
		{
			webdriver=new FirefoxDriver();
			System.out.println("######Executing test using "+ browser+" driver");
		}
		else
			throw new IllegalArgumentException("***Not a valid browser,browser not supported"+browser);
		
		setDriver(webdriver);
		
		
		//navigate to url
		getDriver().get(prop.getProperty("base_url"));
		//maximise window
		getDriver().manage().window().maximize();
		//wait
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.time));
		//To get the id of the thread which is running
		System.out.println("Current Thread ID: "+Thread.currentThread().getId());
		
	}
	@AfterMethod(alwaysRun = true)
    public void afterMethod() {

        WebDriver webDriver = getDriver();

        try {
            if (webDriver != null) {
            	//close the current browser
                webDriver.quit();
            }
        } finally {
        	//clears the stored reference in thread local storage
            driver.remove();
        }
	
}
}