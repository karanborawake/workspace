package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;



public class Wellsfargo {
	
	@Test
	public static void demo(){
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.wellsfargo.com/sitemap");
		
		WebElement custmomerServiceObj = driver.findElement(By.linkText("Customer Service"));
		
		String custmomerServiceText = custmomerServiceObj.getText();
		
		System.out.println(custmomerServiceText);
		
		Assert.assertEquals(custmomerServiceText, "Customer Service");
		
		WebElement custmomerServiceMore = driver.findElement(By.xpath(".//*[@id='serviceModule']/div[2]/ul/li[1]/a"));
		
		if(custmomerServiceMore.isDisplayed()){
			custmomerServiceMore.click();
		}
		
		String currentUrl = driver.getCurrentUrl();
		
		Assert.assertEquals(currentUrl, "https://www.wellsfargo.com/help/");
		driver.quit();
		
		
	}

}
