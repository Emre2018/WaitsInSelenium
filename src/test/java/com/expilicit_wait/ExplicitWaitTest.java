package com.expilicit_wait;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitTest {

	WebDriver driver;
	String URL = "https://www.google.com/maps";
	WebDriverWait wait;

	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test
	public void checkTitle() {
		driver.get(URL);
		String str = driver.getTitle();
		// String currentURL = driver.getCurrentUrl();
		assertTrue(str.contains("Google Maps"));

	}

	@Ignore
	@Test
	public void searchForCybertek() {
		driver.navigate().to(URL);
		WebElement searchBox = driver.findElement(By.id("searchboxinput"));
		searchBox.clear();
		searchBox.sendKeys("CyberTek");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//div[@class='suggest']//*[starts-with (.,'Cybertek School')]")).click();

		// driver.findElement(By.xpath(“//*[contains(@id,’username’)]”)).sendKeys(“username”);
		// driver.findElement(By.xpath(“//*[starts-with(@id,’user’)]”)).sendKeys(“username”);

		// WebDriverWait wait = new WebDriverWait(driver, 10);
		// WebElement locator = driver.findElement(By.xpath(""));

		// wait.until(ExpectedConditions.presenceOfElementLocated(locator));

		// wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		// wait.until(ExpectedConditions.elementToBeClickable(ID));

	}

	@Test
	public void explicitWaitExample() throws InterruptedException {
		wait = new WebDriverWait(driver, 10);
		driver.navigate().to(URL);

		WebElement searchBox = driver.findElement(By.id("searchboxinput"));
		searchBox.clear();
		searchBox.sendKeys("CyberTek");

		String explicit1 = "//button[@id='searchbox-directions']";
		WebElement locator = driver.findElement(By.xpath(explicit1));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(explicit1)));
		locator.click();

		Thread.sleep(5000);

		String explicit2 = "//input[@placeholder='Choose starting point, or click on the map...']";

		WebElement locator2 = driver.findElement(By.xpath(explicit2));

		locator2.sendKeys("Walmart" + Keys.ENTER);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-tooltip='Driving']")));
		driver.findElement(By.xpath("//div[@data-tooltip='Driving']")).click();
		
		//driver.findElement(By.xpath("//a[.='Sign in']")).click();
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[.='Sign in']")));
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='gb_Sc'])[2]")));
		driver.findElement(By.xpath("(//div[@class='gb_Sc'])[2]")).click();
		
		
	}

}
