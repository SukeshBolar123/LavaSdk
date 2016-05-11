package launchBrowser;

import org.apache.xml.utils.URI.MalformedURIException;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserWebDriverWaitDecider {
	private static BrowserWebDriverWaitDecider bwdw = null;
	private static WebDriverWait wait;
	public static synchronized BrowserWebDriverWaitDecider getWebDriverInstance(){
		if(bwdw==null){
			bwdw = new BrowserWebDriverWaitDecider();
		}
		return bwdw;
	}
	public void setWebDriverWait() throws MalformedURIException{
		wait = new WebDriverWait(SelectBrowserToRun.getInstance().getDriver(), 90);
	}
	public WebDriverWait getDriverWait(){
		return wait;
	}
	
}
