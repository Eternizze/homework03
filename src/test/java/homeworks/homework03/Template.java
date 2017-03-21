package homeworks.homework03;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class Template {
	
	// Test Case Template
		WebDriver driver;

		@Before
			public void setUp() {
			// driver = //we will update this part with each section
			// driver.get("http://pragmatic.bg/automation/");
			}
			@After
			public void tearDown() {
			driver.quit();
			}
			@Test
			public void testExample1() {
			// We will put examples in here
			}
			@Test
			public void testExample2() {
			// We will put examples in here
			}

}
