package SeleniumTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReusableMethode {
	
	public static WebDriver driver;
	
	public static WebDriver launchBrowser(String name){
		
		String driverPath =  "/home/shubhangi/workspace/SeleniumDriver/src/utility/geckodriver";
		
		if(name.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver",driverPath );
		driver=new FirefoxDriver();
		}
		else if(name.equalsIgnoreCase("chrome")){
			System.out.println("chrome entered");
			System.setProperty("webdriver.chrome.driver","I:\\project codes\\selenium projects\\selenium\\src\\library\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		return driver;
	}

	public static WebDriver closeBrowser(WebDriver driver){
		try{
			driver.quit();
		}
		catch(Exception e){
			
		}
		return driver;
	}
	public static WebDriver Login_toXerox(WebDriver driver) throws InterruptedException{
		
		driver.get("https://login.xero.com/");
		driver.findElement(By.id("email")).sendKeys("shubhangi.takawane@gmail.com");
		driver.findElement(By.id("password")).sendKeys("shubhangi1");
		driver.findElement(By.id("submitButton")).click();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String actualText=driver.findElement(By.xpath(".//*[@id='root']/div/div/div[1]/div[1]/div[1]/div/div[1]/div")).getText();
		String expString="Welcome to Xero";
		
		if(actualText.equalsIgnoreCase(expString))
			System.out.println("User's Home Page is displayed");
		else
			System.out.println("eUser's Home Page is not displayed");
		
		return driver;
	}
	

	
}
