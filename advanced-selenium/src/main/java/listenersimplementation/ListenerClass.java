package listenersimplementation;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import basepackage.BaseClasss;

public class ListenerClass extends BaseClasss implements ISuiteListener, ITestListener
{

	@Override
	public void onStart(ISuite suite) 
	{
		Reporter.log(suite.getName()+" is Started", true);
	}
	
	@Override
	public void onFinish(ISuite suite) 
	{
		Reporter.log(suite.getName()+" is Finished", true);
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		Reporter.log(result.getName()+" is Started Execution", true);
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log(result.getName()+" is Successfully Executed", true);
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		Reporter.log(result.getName()+" is Skipped", true);
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File path = new File("./FailedScreenshots/"+result.getName()+".png");
		File ss = ts.getScreenshotAs(OutputType.FILE);
		try 
			{
				FileHandler.copy(ss, path);
			} 
		catch (IOException e)
			{
				e.printStackTrace();
			}
		Reporter.log(result.getName()+" is Failed in Execution and Screenshot Captured", true);
	}
}
