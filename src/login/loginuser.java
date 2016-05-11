package login;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Set;

import org.apache.tools.ant.taskdefs.classloader.ClassloaderContext.Report;
import org.apache.xpath.XPath;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.reports.utils.Utils;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import driver.setup.DriverDecider;
import driver.setup.WebDriverWaitDecider;

public class loginuser {

	


	@Test(priority =0)
	public void verify() throws MalformedURLException, InterruptedException {
		WebDriverWaitDecider.getWebDriverInstance().setWebDriverWait();
		ATUReports.setWebDriver(DriverDecider.getWebDriverInstance().getDriver());
		ATUReports.indexPageDescription = "Lava";
		ATUReports.setAuthorInfo("Sukesh Bolar", Utils.getCurrentTime(), "1.0");
		Reporter.log("<font color='orange'>Test Scenario : Launching the application</font>");
		Reporter.log("<font color='blue'>-----Test Case 1-----</font>" +"<br> 1. Install app and launch it."+"<br>2. Verify whether 'Login' screen is loaded.");
		ATUReports.add("<font color='green'>**** Application has been launched successfully ****</font>", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		System.out.println("Verify if Adv has come or not in Login page");
		Thread.sleep(5000);

		try
		{
			boolean isAdvEmpty = DriverDecider.getWebDriverInstance().getDriver().findElements(By.name("Video")).isEmpty();
			System.out.println("Checking if the Adv is present or not: "+ isAdvEmpty);
			Reporter.log("<font color='orange'>Test Scenario : Launching the application</font>");
			Reporter.log("<font color='blue'>-----Test Case 2-----</font>" +"<br> 1. Launch application."+"<br>2. Verify whether advertisement is shown."+"<br>3. Close the advertisement if it is shown, else continue execution.");
			
			if(isAdvEmpty == false){
				Reporter.log("<font color='black'>Info: Advertisement is shown.</font>");			
				try {
				System.out.println("Close the pop up");
				WebDriverWaitDecider.getWebDriverInstance().getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[6]")));
				DriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[6]")).click();
				//Verifying whether one more add banner is present or not - "You have a gold offer"
				try{
					WebDriverWaitDecider.getWebDriverInstance().getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[7]")));
					DriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[6]")).click();
				}catch(Exception e){
					
				}
				System.out.println("Now Login");
				login();
			} catch (MalformedURLException e) {
				e.printStackTrace();
				System.out.println("Something went wrong here");
				Reporter.log("<font color='red'>Seems like something went wrong :( </font>");
			}
		}else{
			login();
		}
		}
		catch (MalformedURLException e) {
			e.printStackTrace();
			System.out.println("Something went wrong here");
			Reporter.log("<font color='red'>Seems like something went wrong :( </font>");
			login();
		}
		
		}
	
	public void login() throws MalformedURLException, InterruptedException{
		Reporter.log("<font color='orange'>Test Scenario : Login</font>");
		Reporter.log("<font color='blue'>-----Test Case 3-----</font>" +"<br> 1. Enter correct Username"+"<br>2. Enter correct password"+"<br>3. Tap on login button.");
		
		//Enter Username
		DriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATextField[1]")).click();
		DriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATextField[1]")).sendKeys("chethan@codecraft.co.in");

		//Enter Password
		DriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIASecureTextField[1]")).click();
		DriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIASecureTextField[1]")).sendKeys("123456");

		//Tap on Login button
		DriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[2]")).click();
		
		//Verifying whether application has been logged in?
		try{
			
			
		}catch(Exception e){
			
	
		}
		
	}
	
	
	}

