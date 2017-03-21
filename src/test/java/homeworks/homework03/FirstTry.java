package homeworks.homework03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;


public class FirstTry {
		
	WebDriver driver;

@Before
	public void setUp(){	
		System.setProperty("webdriver.gecko.driver", "D:/QA Pragmatic/QA Complete 7/Selenium/Selenium Drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		//driver.get(url);
	}
	
	@Test
	public void mySecondTest() throws InterruptedException{
		driver.get("http://google.com");
		WebElement element = driver.findElement(By.id("gs_htif0"));
		element.sendKeys("neshto tyrsq");
		Thread.sleep(2000);
	}
	
	@After
	public void tearDown(){
		driver.quit();
	}
		
}
