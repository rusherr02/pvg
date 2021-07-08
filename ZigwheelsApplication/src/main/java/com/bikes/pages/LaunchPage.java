package com.bikes.pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.Status;
import com.bikes.baseClass.TestBase;

public class LaunchPage extends TestBase {

	By newBikes = By.xpath("//*[@id=\"headerNewNavWrap\"]/div[2]/ul/li[3]/a");
	By UpcomingBikes =By.xpath("//header/div[1]/div[2]/div[1]/div[2]/ul[1]/li[3]/ul[1]/li[4]/a[1]");
	By signUp = By.id("forum_login_title_lg");
	By googleSignIn = By.xpath("//span[contains(text(),'Continue with Google')]");

	
	
	/*******************************************************************************
	 * Following code is for click on upcoming bikes in India 
	 *******************************************************************************/
	
	public void clickUpcomingBikes() {
		try {
			Actions actions = new Actions(driver);
			logger.log(Status.INFO, "Mouse is moving towards the 'New Bikes'");
			WebElement nBikes = driver.findElement(newBikes);
			actions.moveToElement(nBikes).perform();
			logger.log(Status.INFO, "'Upcoming Bikes' option is going to be clicked");
			WebElement uBikes = driver.findElement(UpcomingBikes);
			uBikes.click();
		} catch (Exception e) {
			// TODO: handle exception
			reportFail(e.getMessage());
		}
	}


	/*******************************************************************************
	 * Following code is for click on 'Login/SignUp' button on home page
	 *******************************************************************************/
	
	
	
	public void clickLogin() {
		logger.log(Status.INFO, "Mouse is moving towards the 'SignUp/Login' button and click it");
		driver.findElement(signUp).click();
		waitFor(5);

		String parent = driver.getWindowHandle();
		
		logger.log(Status.INFO, "Mouse is clicking on 'continue with Google'"); 
		
		driver.findElement(googleSignIn).click();
		waitFor(3);

		Set<String> allWindows = driver.getWindowHandles();

		for (String child : allWindows) {

			if (!parent.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);
			}
		}
	}

}
