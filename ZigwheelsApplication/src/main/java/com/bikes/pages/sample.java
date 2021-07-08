package com.bikes.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class sample {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resourses\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		driver.get("https://pratesting.cognizant.com");
		Thread.sleep(8000);
		driver.findElement(By.id("i0116")).sendKeys("srika");
	}

}
