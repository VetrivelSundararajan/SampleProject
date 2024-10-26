package testpackage;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestClass {

	@Test(priority = 3)
	public void login()
	{
		Reporter.log("Login successfully", true);
	}
	
	
	@Test(priority = -1)
	public void openBrowser()
	{
		Reporter.log("Browser opened successfully", true);
	}
	
	@Test
	public void register()
	{
		Reporter.log("Registered successfully", true);
	}
	
}
