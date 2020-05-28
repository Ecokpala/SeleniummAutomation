package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestSuite1 {
	
	@Test
	public void negativeLogin () throws InterruptedException {
	WebDriverManager.chromedriver().setup();	
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://magento.com");
		driver.findElement(By.xpath("//*[@id=\"block-header\"]/ul/li[9]/a/span[1]/div")).click();
		driver.findElement(By.id("email")).sendKeys("ecokpala@yahoo.com");
		driver.findElement(By.id("pass")).sendKeys("Emeka@magento");
		driver.findElement(By.id("send2")).click();
	    Thread.sleep(5000);
	    String msg =driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div")).getText();
	    System.out.println(msg);
		Assert.assertEquals(msg, "Invalid login or password.");
		driver.quit();
		
}

}	
		


