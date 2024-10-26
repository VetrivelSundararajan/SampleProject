package testscript;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import basepackage.BaseClasss;

public class GettingTitle extends BaseClasss{

	@Test(groups = "Regression", retryAnalyzer = listenersimplementation.RetryListener.class)
	public void getTitleTest()
	{
	 String	data = driver.getTitle();
	 Assert.fail();
	 SoftAssert softAssert = new SoftAssert();
	 softAssert.assertTrue(data.contains("Demo"));
	 Reporter.log("Title has been asserted", true);
	 softAssert.assertAll();
	}
}
