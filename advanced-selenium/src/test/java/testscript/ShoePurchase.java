package testscript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import basepackage.BaseClasss;

public class ShoePurchase extends BaseClasss
{
@Test(groups = "Regression")
public void purchaseShoe() throws Throwable
	{
	//Clicking the apparels and shoe menu
	driver.findElement(By.xpath("//ul[@class='top-menu']/li[4]")).click();
	String shoePage = driver.getTitle();
	Assert.assertTrue(shoePage.contains("Shoes"));
	Reporter.log("Apparals and Shoe page is displayed", true);
	
	//selecting the product
	Thread.sleep(1000);
	driver.findElement(By.linkText("Blue and green Sneaker")).click();
	String selectShoe = driver.getTitle();
	Assert.assertTrue(selectShoe.contains("Blue"));
	Reporter.log("Blue Shoe is selected and displayed", true);
	
	//choosing the size from drop down
	WebElement size = driver.findElement(By.xpath("//select[@id='product_attribute_28_7_10']")); 
	Thread.sleep(3000);
	Select shoesize = new Select(size);
	shoesize.selectByIndex(1);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[@title='Black']")).click();
	driver.findElement(By.xpath("//input[@value='Add to cart'][1]")).click();
	Thread.sleep(4000);
	WebElement addCart = driver.findElement(By.xpath("//p[@class='content']"));
	String addcartText = addCart.getText();
	Assert.assertTrue(addcartText.contains("The product has been added to your"));
	Reporter.log("Blue Shoe is added to the cart successfully", true);
	}
}
