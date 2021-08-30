package util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import page.BasePage;

public class RunningTestNG extends BasePage {

	WebDriver driver;

	@BeforeMethod
	public void init() {

		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://techfios.com/test/101/");
		// return driver;

	}

	@Test
	public void TestNGAutomation() {

		boolean present = driver.findElement(By.linkText("Pickle Rick684")).isDisplayed();
		
		if(present) {
			System.out.println("The category you want to add already exists: <duplicated category name>");
		}else {
			System.out.println("You're good to go/add!");
		}
		
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
	
