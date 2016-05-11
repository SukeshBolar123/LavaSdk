package login;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import driver.setup.DriverDecider;
import driver.setup.WebDriverWaitDecider;

public class logout {
  
	@Test
  public void logoutUser() throws MalformedURLException, InterruptedException {
	  
	
		//wait(2000);
			//Click on Menu button
			DriverDecider.getWebDriverInstance().getDriver().findElement(By.name("menubutton")).click();
			
			//Wait for Logout button
			WebDriverWaitDecider.getWebDriverInstance().getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[8]/UIAStaticText[1]")));
			DriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[8]/UIAStaticText[1]")).click();
  
  }
}
