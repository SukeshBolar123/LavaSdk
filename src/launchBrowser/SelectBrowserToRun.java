package launchBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelectBrowserToRun {

	private static SelectBrowserToRun wdd = null;

	private WebDriver fDriver = null;
	private WebDriver cDriver = null;

	private WebDriver currentSelectedDriver = fDriver;

	public static synchronized SelectBrowserToRun getInstance() {
		if (wdd == null) {
			wdd = new SelectBrowserToRun();
		}

		return wdd;
	}

	private SelectBrowserToRun() {

		String ChromePath = System.getProperty("user.dir")+"//Driver//chromedriver";
		System.setProperty("webdriver.chrome.driver",ChromePath);
		cDriver= new ChromeDriver();
		// fDriver= new FirefoxDriver();
		// cDriver.close();
	}

	public WebDriver getDriver() {
		return currentSelectedDriver;
	}

	public void setCurrentDriverToChrome() {
		if (cDriver == null) {
			cDriver = new ChromeDriver();
		}
		currentSelectedDriver = cDriver;
	}

	public void setCurrentDriverToFireFox() {
		if (fDriver == null) {
			fDriver = new FirefoxDriver();
		}
		currentSelectedDriver = fDriver;
	}
}
