package SeleniumTest;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

	public class SeleniumTestScript_1 {
		public static WebDriver driver;
		
		@Test(enabled=true)
		public static void NavigateToXERO_TC01() throws InterruptedException{
			
			String driverPath =  "/home/shubhangi/workspace/SeleniumDriver/src/utility/geckodriver";
			System.setProperty("webdriver.gecko.driver",driverPath );
			
			driver=new FirefoxDriver();
			driver.get("https://login.xero.com/");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			String applicationTitle=driver.getTitle();
			if(applicationTitle.contains("Xero"))
				System.out.println("Xero application page is displayed");
			else
				System.out.println("Xero application page is not displayed");
			
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
			
			driver.close();
		}
	}