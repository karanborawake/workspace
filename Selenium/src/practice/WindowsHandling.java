package practice;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WindowsHandling {
	WebDriver driver;
	@BeforeTest
	public void setup(){
		driver = new FirefoxDriver();
		driver.get("https://www.gmail.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test
	public void testWindowAlert() throws Exception{
		driver.findElement(By.id("Email")).sendKeys("sonalitjadhav@gmail.com");
		driver.findElement(By.xpath(".//*[@id='next']")).click();
		driver.findElement(By.id("Passwd")).sendKeys("Karnu.sonu");
		driver.findElement(By.id("signIn")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id=':hf']/div/div")).click();
		driver.findElement(By.xpath(".//*[@id=':oq']")).click();
		
		Robot rb =new Robot();
		rb.keyPress(KeyEvent.VK_D);
		
		rb.keyRelease(KeyEvent.VK_D);

		Thread.sleep(2000);
		
		rb.keyPress(KeyEvent.VK_SHIFT);
		
		rb.keyPress(KeyEvent.VK_SEMICOLON);
		
		rb.keyRelease(KeyEvent.VK_SEMICOLON);

		rb.keyRelease(KeyEvent.VK_SHIFT);
	
		rb.keyPress(KeyEvent.VK_BACK_SLASH);

		rb.keyRelease(KeyEvent.VK_BACK_SLASH);

		Thread.sleep(2000);
	
		rb.keyPress(KeyEvent.VK_P);

		rb.keyRelease(KeyEvent.VK_P);
	
		rb.keyPress(KeyEvent.VK_I);

		rb.keyRelease(KeyEvent.VK_I);
	
		 
		
		rb.keyPress(KeyEvent.VK_C);
		
		rb.keyRelease(KeyEvent.VK_C);
		
		Thread.sleep(2000);
		
		rb.keyPress(KeyEvent.VK_ENTER);
		
		rb.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(2000);


		
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
}
