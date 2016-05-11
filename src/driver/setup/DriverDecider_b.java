package driver.setup;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import launchBrowser.LavaAnalyticsReport;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;

@Listeners({ATUReportsListener.class,ConfigurationListener.class,MethodListener.class})

public class DriverDecider_b {
	{
		File file = new File("atu.properties");
		System.setProperty("atu.reporter.config", file.getAbsolutePath());
	}
	private static DriverDecider_b wd = null;
	public static RemoteWebDriver driver;


	public static synchronized DriverDecider_b getWebDriverInstance() throws MalformedURLException{
		if(wd==null){
			wd = new DriverDecider_b();
		}
		return wd;	
	}

	@BeforeSuite
	public  void SetWebDriver() throws IOException, InterruptedException{
		LavaAnalyticsReport report = new LavaAnalyticsReport();
		report.LaunchWebBrowser();
		String udid = getUDIDOfTheDevice();
	  //	File classpathroot = new File(System.getProperty("user.dir"));
	
		//File file = new File(classpathroot,"/app/DemoAppv1.ipa");
		DesiredCapabilities capablities = new DesiredCapabilities();
		//capablities.setCapability(CapabilityType.BROWSER_NAME, "iOS");
		capablities.setCapability("deviceName","CC iPhone 6");
		capablities.setCapability("platformName", "iOS");
		System.out.println("device name and version");
	//	capablities.setCapability("app", file.getCanonicalPath());
		capablities.setCapability("bundleId","com.codecraft.vspinkipad");
		capablities.setCapability("udid",udid);
		//capablities.setCapability("udid","cbb49b4e933a679113b5b19308d3aba235ceb988");
		System.out.println("UDID of the device" +udid);
		capablities.setCapability("autoAcceptAlerts", true);
		capablities.setCapability("waitForAppScript", true);
		driver =new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capablities);
		
		System.out.println("App Successfully connected to Appium");
		Assert.assertTrue(true);
		Thread.sleep(5000);
	}
	public RemoteWebDriver getDriver(){
		return driver;
	}
	
	public String getUDIDOfTheDevice() throws IOException, InterruptedException{
		//finding UDID of the device
		String value=null;
		String line = null;
		File filepath = new File(System.getProperty("user.dir"));
		File shellScriptToRun = new File(filepath,"/getUDID.sh");
		Process proc = Runtime.getRuntime().exec(shellScriptToRun.toString());
		InputStream stdin = proc.getInputStream();
		InputStreamReader isr = new InputStreamReader(stdin);
		BufferedReader br = new BufferedReader(isr);
		while ( (line = br.readLine()) != null){
			  value = line;
		}   
		String udid = "\""+value+"\"";
		return udid;
	}

}
