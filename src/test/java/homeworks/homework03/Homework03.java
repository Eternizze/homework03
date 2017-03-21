package homeworks.homework03;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Homework03 {

	private final static String USERNAME = "admin";
	private final static String PASSWORD = "parola";
	private final static String PATHFIREFOX = "D:/QA Pragmatic/QA Complete 7/Selenium/Selenium Drivers/geckodriver.exe";
	private final static String PATHCHROME = "D:/QA Pragmatic/QA Complete 7/Selenium/Selenium Drivers/chromedriver.exe";
	WebDriver driver;

	public void login(String userName, String password) {
		driver.get("http://shop.pragmatic.bg/admin");
		WebElement login = driver.findElement(By.name("username"));
		WebElement pass = driver.findElement(By.name("password"));
		WebElement button = driver.findElement(By.className("button"));
		login.sendKeys(userName);
		pass.sendKeys(password);
		button.click();
	}

	@Before
	public void setUp() {
		// System.setProperty("webdriver.gecko.driver", PATHFIREFOX);
		// driver = new FirefoxDriver();

		System.setProperty("webdriver.chrome.driver", PATHCHROME);
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

	@Test
	public void task01LogInBackEnd() {

		login(USERNAME, PASSWORD);

		WebElement element = driver.findElement(By.cssSelector(".div3"));
		String value = element.getText();
		Assert.assertEquals(" You are logged in as admin", value);
	}

	@Test
	public void task02LogInBackEndNegative() {

		login("name", "pass");

		WebElement element = driver.findElement(By.cssSelector(".warning"));
		String value = element.getText();
		Assert.assertEquals("No match for Username and/or Password.", value);
	}

	@Test
	public void task03CheckDropdownValues() {
		login(USERNAME, PASSWORD);

		// Get the Dropdown as a Select using it's name attribute
		Select dropdown = new Select(driver.findElement(By.id("range")));

		// We will verify Dropdown has expected values as listed in a array
		List<String> expOptions = Arrays.asList(new String[] { "Today", "This Week", "This Month", "This Year" });
		List<String> actOptions = new ArrayList<String>();

		// Retrieve the option values from Dropdown using getOptions() method
		for (WebElement option : dropdown.getOptions())
			actOptions.add(option.getText());

		// Verify expected options array and actual options array match
		assertArrayEquals(expOptions.toArray(), actOptions.toArray());

	}

	@Test
	public void task04VerifyCheckedBoxes() throws InterruptedException {
		driver.get("http://pragmatic.bg/automation/lecture13/Config.html");

		WebElement airbag = driver.findElement(By.name("airbags"));
		WebElement parksensor = driver.findElement(By.name("parksensor"));

		Actions builder = new Actions(driver);
		builder.click(airbag).click(parksensor).perform();
		Thread.sleep(2000);

		assertTrue(airbag.isSelected());
		assertTrue(parksensor.isSelected());
	}

}
