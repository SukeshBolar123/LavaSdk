package analytics;

import java.net.MalformedURLException;

import launchBrowser.LavaAnalyticsReport;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import driver.setup.DriverDecider;
import driver.setup.WebDriverWaitDecider;

public class analytics {
	
	@Test(priority =0)
	public void verify() throws MalformedURLException, InterruptedException {
		
		Thread.sleep(15000);
		System.out.println("Verify if Adv has come or not");
		try
		{
			boolean isAdvEmpty = DriverDecider.getWebDriverInstance().getDriver().findElements(By.name("Video")).isEmpty();
			System.out.println("Checking if the Adv is present or not in Profile page: "+ isAdvEmpty);
			
			if(isAdvEmpty == false){
				System.out.println("Waiting for 90 seconds ");
			try {
				System.out.println("Close the pop up");
				WebDriverWaitDecider.getWebDriverInstance().getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[2]")));
				DriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[2]")).click();
				
				try{
					WebDriverWaitDecider.getWebDriverInstance().getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[2]")));
					DriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[2]")).click();
				}catch(Exception e){
					
				}
				System.out.println("Now Test the Anlaytics");
				analyticsTesting();
			} catch (MalformedURLException e) {
				e.printStackTrace();
				System.out.println("Something went wrong here");
			}
		}else{
			analyticsTesting();
		}
		}
		catch (MalformedURLException e) {
			e.printStackTrace();
			System.out.println("Something went wrong here");
			ATUReports.add("<font color='red'>**** Application did not login ****</font>", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			DriverDecider.getWebDriverInstance().getDriver().quit();
		}
		
		}
 
  
  public void analyticsTesting() throws MalformedURLException, InterruptedException {
	  WebDriverWaitDecider.getWebDriverInstance().getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.name("menuButton")));	
		System.out.println("Logged in successfully");
		ATUReports.add("<font color='green'>**** Application has been successfully logged in ****</font>", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	  LavaAnalyticsReport report= new LavaAnalyticsReport();
	  Reporter.log("<font color='orange'>Test Scenario : Navigating to Analytics screen and tapping on Video 1, Video 2, Image and Article button.</font>");
		Reporter.log("<font color='blue'>-----Test Case 4-----</font>" +"<br> 1. Tap on Menu button"+"<br>2. Tap on Article button."+"<br>3. Tap on Video 1 button." +"<br>3. Tap on Video 2 button."+"<br>3. Tap on Image button."+"<br>3. Tap on Article button.");
		System.out.println("Enter to Analytics");
		
		//Click on Menu button
		WebDriverWaitDecider.getWebDriverInstance().getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.name("menuButton")));	
		DriverDecider.getWebDriverInstance().getDriver().findElement(By.name("menuButton")).click();
		
		//Tap on Analytics button
		WebDriverWaitDecider.getWebDriverInstance().getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]/UIATableView[1]/UIATableCell[7]")));
		DriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]/UIATableView[1]/UIATableCell[7]")).click();

		
		//Tap on Video 1 buton
		WebDriverWaitDecider.getWebDriverInstance().getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[2]")));
		DriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[2]")).click();	
		
		//Tap on Video 2 button
		WebDriverWaitDecider.getWebDriverInstance().getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[3]")));
		DriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[3]")).click();
	
		
		//Tap on image button
		WebDriverWaitDecider.getWebDriverInstance().getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[4]")));
		DriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[4]")).click();
		
		//Tap Article button
		WebDriverWaitDecider.getWebDriverInstance().getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[6]")));
		DriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[6]")).click();

		
		System.out.println("Analytics should be triggered now");
		System.out.println("Application will logout");
		ATUReports.add("<font color='green'>Application has successfully clicked on video 1,Video 2, Image and Article button.</font>", true);
		
		//Click on Menu button
		DriverDecider.getWebDriverInstance().getDriver().findElement(By.name("menuButton")).click();
		
		//Click on Logout button
		Reporter.log("<font color='orange'>Test Scenario : Logout from the application.</font>");
		Reporter.log("<font color='blue'>-----Test Case 4-----</font>" +"<br> 1. Tap on Menu button"+"<br>2. Tap on Logout button.");
		WebDriverWaitDecider.getWebDriverInstance().getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[7]/UIATableView[1]/UIATableCell[8]")));
		DriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[7]/UIATableView[1]/UIATableCell[8]")).click();
		
		report.FinalReport();
  }
}
