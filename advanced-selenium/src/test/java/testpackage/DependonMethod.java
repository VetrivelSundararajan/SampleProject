package testpackage;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class DependonMethod {
	@Test(dependsOnMethods = "register", priority = 2)
	public void login()
	{
		Reporter.log("Login successfully", true);
	}
	
	
	@Test(invocationCount = 2)
	public void openBrowser()
	{
		Reporter.log("Browser opened successfully", true);
	}
	
	@Test
	public void register()
	{
		Reporter.log("Registered successfully", true);
	}
	
	@Test(dependsOnMethods = "register", priority = 1)
	public void action()
	{
		Reporter.log("WebElement actions", true);
	}
	
	@Test(priority = 2)
	public void atest()
	{
		Reporter.log("Tested successfully", true);
	}
	
	@Test(enabled = false)
	public void btest()
	{
		Reporter.log("Skipped successfully", true);
	}
}
