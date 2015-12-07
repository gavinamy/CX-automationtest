package com.cx.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.cx.bean.Config;
import com.cx.util.Log;

import static com.cx.util.KillProcess.*;

public class SeleniumDriver {
	
	private WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}	
	
	public SeleniumDriver() {
		this.initialDriver();
	}
	


	private void initialDriver(){
		if("firefox".equals(Config.browser)){
			killProcess("firefox.exe");
			FirefoxProfile firefoxProfile = new FirefoxProfile();
			firefoxProfile.setPreference("browser.download.folderList",2);
			firefoxProfile.setPreference("browser.download.manager.showWhenStarting",false);
			firefoxProfile.setPreference("browser.download.dir","c:\\downloads");
			firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk","text/csv");
			System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
			ProfilesIni pi = new ProfilesIni();
			FirefoxProfile profile = pi.getProfile("default");
			driver = new FirefoxDriver(profile);
		}else if("ie".equals(Config.browser)){
			killProcess("iexplore.exe");
			System.setProperty("webdriver.ie.driver", "files/IEDriverServer.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
	        capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
	        capabilities.setCapability("ignoreProtectedModeSettings",true);       
			driver = new InternetExplorerDriver(capabilities);
		}else if("chrome".equals(Config.browser)){
			killProcess("chrome.exe");
			System.setProperty("webdriver.chrome.driver", "files/chromedriver.exe");
			System.setProperty("webdriver.chrome.bin", "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
//			ChromeOptions options = new ChromeOptions();
//			options.addArguments("--test-type");
			driver = new ChromeDriver();
		}else{
			Log.logInfo(Config.browser+" 的值不正确，请检查！");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Config.waitTime, TimeUnit.SECONDS);	
	}	
	
	public static void main(String[] args) {
		SeleniumDriver selenium = new SeleniumDriver();
		WebDriver driver = selenium.getDriver();
		driver.navigate().to("http://www.baidu.com");
		driver.close();
		driver.quit();
	}
}
