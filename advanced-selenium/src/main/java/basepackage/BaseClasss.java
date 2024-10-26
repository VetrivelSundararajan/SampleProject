package basepackage;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import fileutilities.ReadProperty;

public class BaseClasss {
	public static WebDriver driver;
	
	@BeforeClass(alwaysRun = true)
	@Parameters("browser")
	public void openBrowser(String browser)
	{
		//Reporter.log(browser);
		//driver = new ChromeDriver();
		if(browser.equals("Chrome"))
		{
			driver = new ChromeDriver();	
		}
		else if(browser.equals("Edge"))
		{
			driver = new EdgeDriver();
		}	
		else
		{
			Reporter.log("Error in opening", true);
		}
		
		
		ReadProperty read=new ReadProperty();
		String url=read.fetchProperty("url");
		driver.get(url);
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, url);
		Reporter.log("Demo site is loaded successfully", true);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Reporter.log("Opening Browser", true);
	}
	@BeforeMethod(alwaysRun = true)
	public void login()
	{
		Reporter.log("Login", true);
		driver.findElement(By.xpath("//a[@class='ico-login']")).click();
		String title = driver.getTitle();
		Assert.assertTrue(title.contains("Login"));
		Reporter.log("Login page is displayed successfully", true);
		ReadProperty read=new ReadProperty();
		String username=read.fetchProperty("username");
		String password=read.fetchProperty("password");		
		driver.findElement(By.id("Email")).sendKeys(username, Keys.TAB, password, Keys.TAB, Keys.SPACE, Keys.TAB, Keys.TAB, Keys.ENTER);
		WebElement logout =  driver.findElement(By.xpath("//a[@class='ico-logout']"));
		String logutText = logout.getText();
		Assert.assertTrue(logutText.contains("Log out"));
		Reporter.log("Login is successful", true);
	}
	@AfterMethod(alwaysRun = true)
	public void logout() throws Throwable
	{
		Reporter.log("Logout", true);
		driver.findElement(By.xpath("//a[@class='ico-logout']")).click();
		WebElement login=driver.findElement(By.xpath("//a[@class='ico-login']"));
		String loginText=login.getText();
		Assert.assertTrue(loginText.contains("Log in"));
		Reporter.log("Logout is successful", true);
		Thread.sleep(2000);
	}
	@AfterClass(alwaysRun = true)
	public void closeBrowser()
	{
		Reporter.log("Closing Browser", true);
		driver.quit();
	}
}
