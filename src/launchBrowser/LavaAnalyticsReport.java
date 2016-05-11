package launchBrowser;

import org.apache.xml.utils.URI.MalformedURIException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class LavaAnalyticsReport {
  @Test
  public void LaunchWebBrowser() throws MalformedURIException, InterruptedException {
	  SelectBrowserToRun.getInstance().setCurrentDriverToChrome();
	  BrowserWebDriverWaitDecider.getWebDriverInstance().setWebDriverWait();
	  SelectBrowserToRun.getInstance().getDriver().get("http://lava-dev.us-east-1.elasticbeanstalk.com/analyticsDev.html");
	  SelectBrowserToRun.getInstance().getDriver().manage().window().maximize();
	  
	  //Clicking on refresh button
	  SelectBrowserToRun.getInstance().getDriver().findElement(By.xpath("//button[contains(.,'Refresh')]")).click();
	 
	  //Fetching count value of Video1
	  BrowserWebDriverWaitDecider.getWebDriverInstance().getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html//body//table[2]//tbody//tr[7]//td[3]")));
	  String countValueOfVideo1 = SelectBrowserToRun.getInstance().getDriver().findElement(By.xpath("//html//body//table[2]//tbody//tr[7]//td[3]")).getText().toString();
	  System.out.println("Initial count value of Video 1 = "+countValueOfVideo1);
	  
	  //Fetching count value of Video2
	  BrowserWebDriverWaitDecider.getWebDriverInstance().getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html//body//table[2]//tbody//tr[5]//td[3]")));
	  String countValueOfVideo2 = SelectBrowserToRun.getInstance().getDriver().findElement(By.xpath("//html//body//table[2]//tbody//tr[5]//td[3]")).getText().toString();
	  System.out.println("Initial count value of Video 2 = "+countValueOfVideo2);
	  
	  //Fetching count value of Image 1
	  BrowserWebDriverWaitDecider.getWebDriverInstance().getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html//body//table[2]//tbody//tr[10]//td[3]")));
	  String countValueOfImage1 = SelectBrowserToRun.getInstance().getDriver().findElement(By.xpath("//html//body//table[2]//tbody//tr[10]//td[3]")).getText().toString();
	  System.out.println("Initial count value of Image 1 = "+countValueOfImage1);
	  
	  //Fetching count value of Article 1
	  BrowserWebDriverWaitDecider.getWebDriverInstance().getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html//body//table[2]//tbody//tr[6]//td[3]")));
	  String countValueOfArticle1 = SelectBrowserToRun.getInstance().getDriver().findElement(By.xpath("//html//body//table[2]//tbody//tr[6]//td[3]")).getText().toString();
	  System.out.println("Initial count value of Article 1 = "+countValueOfArticle1);
	  
  }
  
  @Test
  public void FinalReport() throws InterruptedException{
	//Clicking on refresh button
	  BrowserWebDriverWaitDecider.getWebDriverInstance().getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(.,'Refresh')]")));
	  SelectBrowserToRun.getInstance().getDriver().findElement(By.xpath("//button[contains(.,'Refresh')]")).click();
	
	  Thread.sleep(10000);
	 
	  //Fetching count value of Video1
	  BrowserWebDriverWaitDecider.getWebDriverInstance().getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html//body//table[2]//tbody//tr[7]//td[3]")));
	  String countValueOfVideo1 = SelectBrowserToRun.getInstance().getDriver().findElement(By.xpath("//html//body//table[2]//tbody//tr[7]//td[3]")).getText().toString();
	  System.out.println("Final count value of Video 1 = "+countValueOfVideo1);
	  
	  //Fetching count value of Video2
	  BrowserWebDriverWaitDecider.getWebDriverInstance().getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html//body//table[2]//tbody//tr[5]//td[3]")));
	  String countValueOfVideo2 = SelectBrowserToRun.getInstance().getDriver().findElement(By.xpath("//html//body//table[2]//tbody//tr[5]//td[3]")).getText().toString();
	  System.out.println("Final count value of Video 2 = "+countValueOfVideo2);
	  
	  //Fetching count value of Image 1
	  BrowserWebDriverWaitDecider.getWebDriverInstance().getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html//body//table[2]//tbody//tr[10]//td[3]")));
	  String countValueOfImage1 = SelectBrowserToRun.getInstance().getDriver().findElement(By.xpath("//html//body//table[2]//tbody//tr[10]//td[3]")).getText().toString();
	  System.out.println("Final count value of Image 1 = "+countValueOfImage1);
	  
	  //Fetching count value of Article 1
	  BrowserWebDriverWaitDecider.getWebDriverInstance().getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html//body//table[2]//tbody//tr[6]//td[3]")));
	  String countValueOfArticle1 = SelectBrowserToRun.getInstance().getDriver().findElement(By.xpath("//html//body//table[2]//tbody//tr[6]//td[3]")).getText().toString();
	  System.out.println("Final count value of Article 1 = "+countValueOfArticle1);
  }
}
