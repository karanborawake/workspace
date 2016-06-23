package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class YoutubeVideo {
	@Test
	public static void demo() throws Exception{
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.youtube.com/watch?v=9s5l6w-35Wc");
		Thread.sleep(5000);
		
		//WebElement obj = driver.findElement(By.xpath(".//*[@id='movie_player']/div[24]/div[2]/div[1]/button"));
		WebElement video = driver.findElement(By.tagName("video"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(5000);
		js.executeScript("arguments[0].volume=1;", video);
		/*obj.click();
		Thread.sleep(5000);
		obj.click();*/
		Thread.sleep(5000);
		driver.quit();
	}

}
