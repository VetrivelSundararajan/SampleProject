package basepackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	public WebDriver driver;
	@BeforeClass
	public void openBrowser()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Reporter.log("Browser Opened Successfully", true);
		
	}
	
	@AfterClass 
	public void closeBrowser()
	{
		driver.quit();
		Reporter.log("Browser Closed Successfully", true);
	}
	
	@BeforeMethod
	public void login()
	{
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.partialLinkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys("manugowda123@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("12345678");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		Reporter.log("Login Successfully", true);
		
	}
	
	@AfterMethod
	public void logout()
	{
		driver.findElement(By.xpath("//a[@class='ico-logout']")).click();
		Reporter.log("Loggedout Successfully", true);
	}
	
	
}
