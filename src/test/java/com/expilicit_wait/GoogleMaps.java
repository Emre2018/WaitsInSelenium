package com.expilicit_wait;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleMaps {
	WebDriver driver;
	String url = "https://www.google.com/maps/";
	WebDriverWait wait;

	@BeforeClass
	public void setUP() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@Test

	public void searchGoogleMaps() throws InterruptedException {
		driver.get(url);

		driver.findElement(By.xpath("//input[@id='searchboxinput']")).sendKeys("Cybertek" + Keys.ENTER);
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//div[contains(@class,'directions')])[4]")).click();
		String from = "//input[@placeholder='Choose starting point, or click on the map...']";
		Thread.sleep(3000);
		driver.findElement(By.xpath(from)).sendKeys("Walmart" + Keys.ENTER);

		wait = new WebDriverWait(driver, 10);
		WebElement flight = driver.findElement(By.xpath("//div[@aria-label='Flights']"));
		wait.until(ExpectedConditions.elementToBeClickable(flight));

		driver.findElement(By.xpath("//a[.='Sign in']")).click();
	}
}
