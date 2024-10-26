package testscript;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import basepackage.BaseClasss;

public class AddAdress extends BaseClasss
{
	@Test(groups = "Regression")
	public void addressPageTest() throws Throwable
	{
		//Clicking addAddress page
		driver.findElement(By.xpath("//a[normalize-space()='Addresses']")).click();
		String addressPage=driver.getCurrentUrl();
		Assert.assertTrue(addressPage.contains("addresses"));
		Reporter.log("Address page is displyed successfully", true);
		
		//adding new address
		driver.findElement(By.xpath("//input[@value='Add new']")).click();
		Thread.sleep(2000);
		String addressAdd=driver.getCurrentUrl();
		Assert.assertTrue(addressAdd.contains("addressadd"));
		Reporter.log("Add new Address page is dispalyed successfully", true);
		driver.findElement(By.xpath("//input[@id='Address_FirstName']")).sendKeys("Dhoni", Keys.TAB, "MS", Keys.TAB, "CSK07@gmail.com", Keys.TAB, "CSK", Keys.TAB, "Chennai", Keys.TAB, Keys.TAB, "TN", Keys.TAB, "Chennai", Keys.TAB, "TamilNadu", Keys.TAB, "600078", Keys.TAB, "9777777777", Keys.TAB, Keys.TAB, Keys.ENTER);
		
		WebElement savedAddressPage=driver.findElement(By.xpath("//div[@class='page-title']//h1"));
		String savedAddressText= savedAddressPage.getText();
		Assert.assertTrue(savedAddressText.contains("My account"));
		Reporter.log("Address page dispalyed after new address adding", true);
		Thread.sleep(3000);
//		driver.findElement(By.xpath("//li[@id='topcartlink']//a[@class='ico-cart']")).click();
//		Thread.sleep(3000);
//		System.out.println(driver.getTitle());
		
	}
}
