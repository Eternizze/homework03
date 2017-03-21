package homeworks.homework03;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TryChrome {
	WebDriver driver;
	
	@Before
		public void init(){
			System.setProperty("webdriver.chrome.driver",
								 "D:/QA Pragmatic/QA Complete 7/Selenium/Selenium Drivers/chromedriver.exe");
//			ChromeOptions options = new ChromeOptions();
//			options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
//			options.addArguments("--start-maximized", "--disable-extensions");
//			options.addArguments("--disable-extensions");
//			driver = new ChromeDriver(options);
			driver = new ChromeDriver();
			System.out.println("test1");
		}
	@Test
		public void chromeOpen() throws InterruptedException{
		System.out.println("in test");
		driver.get("http://google.com");
		System.out.println("test2");
		WebElement element = driver.findElement(By.id("lst-ib"));
		System.out.println("test3");
		element.sendKeys("neshto tyrsq");
		System.out.println("test4");
		Thread.sleep(3000);
	}
	@After
		public void tearDown(){
			driver.quit();
	}
}
