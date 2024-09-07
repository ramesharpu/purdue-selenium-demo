package test;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BasicTest {
	public static WebDriver driver;
	public String appUrl = "https://www.facebook.com";

	@BeforeTest
	public void setup() {
		//open the browser
		driver = new ChromeDriver();

		//open the url
		driver.get(appUrl);
	}

	@AfterTest
	public void tearDown() {
		//quit the browser instance
		driver.quit();
	}

	@Test
	public void urlValidation() {
		String expetedResult = "https://www.facebook.com/";
		String actualResult = driver.getCurrentUrl();

		Reporter.log("Expected Result = " + expetedResult);
		Reporter.log("Actual Result = " + actualResult);

		assertTrue(actualResult.equals(expetedResult), "Mismatch in the application url,");
	}

	@Test
	public void titleValidation() {
		String expetedResult = "Facebook – log in or sign up";
		String actualResult = driver.getTitle();

		Reporter.log("Expected Result = " + expetedResult);
		Reporter.log("Actual Result = " + actualResult);

		assertTrue(actualResult.equals(expetedResult), "Mismatch in the page title,");
	}

	@Test
	public void welcomeMessageValidation() {
		WebElement welMsg = driver.findElement(By.xpath("//h2[@class='_8eso']"));
		String expetedResult = "Facebook helps you connect and share with the people in your life.";
		String actualResult = welMsg.getText();

		Reporter.log("Expected Result = " + expetedResult);
		Reporter.log("Actual Result = " + actualResult);

		assertTrue(actualResult.equals(expetedResult), "Mismatch in the welcome message,");
	}


}
