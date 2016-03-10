package com.gale.knewton.StepDefs;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.gale.knewton.base.BaseWebComponent;
import com.gale.knewton.util.YamlReader;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class DriverFactory extends BaseWebComponent {
	public static String env;
	public static PropertiesConfiguration envProperties;

	private static String browser = null;
	private static DesiredCapabilities capabilities = new DesiredCapabilities();
	
	public String browserName;

	public static void setUp(String browserName) {
		System.out.println("Setup is being called");
		setBrowser(browserName);
	}

	public DriverFactory(){
		System.out.println("%&^%&%&@@@@@@@@@@@@Stepdefs consyructor has been called");
	}
	public static void setBrowser(String browserName) {
		
		driver = getDriver(browserName);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//String url=YamlReader.getYamlValue("baseurl");
		//driver.get(YamlReader.getYamlValue("url"));
		
	}
	
	public static void navigateBrowser(String URL){
		driver.get(URL);
	}

	public static WebDriver getDriver(String browserName) {
		//browser = System.getProperty("browser", YamlReader.getYamlValue("browser"));
		browser=browserName;
		String server = YamlReader.getYamlValue("seleniumserver");
		if (server.equalsIgnoreCase("local")) {
			if (browser.equalsIgnoreCase("firefox")) {
				return new FirefoxDriver();
				//return getFirefoxDriver();
			} else if (browser.equalsIgnoreCase("chrome")) {
				return getChromeDriver(YamlReader.getYamlValue("chromeDriverPath"));
			}else if(browser.equalsIgnoreCase("safari")){
				return getSafariDriver();
			}else if(browser.equalsIgnoreCase("IE"))
				return getIEDriver(YamlReader.getYamlValue("IEDriverPath"));
		}
		if (server.equalsIgnoreCase("remote")) {
			return setRemoteDriver();
		}
		return getFirefoxDriver();

	}

	private static WebDriver setRemoteDriver() {
		DesiredCapabilities cap = null;
		browser = YamlReader.getYamlValue("browser");
		if (browser.equalsIgnoreCase("firefox")) {
			cap = DesiredCapabilities.firefox();
		} else if (browser.equalsIgnoreCase("chrome")) {
			cap = DesiredCapabilities.chrome();
		} else if (browser.equalsIgnoreCase("Safari")) {
			cap = DesiredCapabilities.safari();
		} else if ((browser.equalsIgnoreCase("ie"))
				|| (browser.equalsIgnoreCase("internetexplorer"))
				|| (browser.equalsIgnoreCase("internet explorer"))) {
			cap = DesiredCapabilities.internetExplorer();
		}
		String seleniuhubaddress = YamlReader
				.getYamlValue("seleniumserverhost");
		URL selserverhost = null;
		try {
			selserverhost = new URL(seleniuhubaddress);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		cap.setJavascriptEnabled(true);
		return new RemoteWebDriver(selserverhost, cap);
	}

	private static WebDriver getChromeDriver(String driverpath) {
		System.setProperty("webdriver.chrome.driver", driverpath);
		capabilities.setJavascriptEnabled(true);
		return new ChromeDriver(capabilities);
	}
	
	private static WebDriver getIEDriver(String driverpath) {
		System.setProperty("webdriver.ie.driver", driverpath);
		capabilities.setJavascriptEnabled(true);
		capabilities.setCapability("ignoreZoomSetting", true);
		return new InternetExplorerDriver(capabilities);
	}
	
	private static WebDriver getSafariDriver(){
		capabilities.setJavascriptEnabled(true);
		return new SafariDriver();
	}

	private static WebDriver getFirefoxDriver() {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.cache.disk.enable", false);
		return new FirefoxDriver(profile);
	}
/*
	@Before
	public void printClassName() {
		String className = this.getClass().getCanonicalName();
		System.out.println("Running Test:" + className);
	}

	//@Before
	//public void printScenarioName(Scenario scenario) {
		//System.out.println("Running scenario:" + scenario.getName());
	//}

	@After
	public void embedScreenshot(Scenario scenario) {
		System.out.println("scenario===" + scenario.getName());
		if (scenario.isFailed()) {
			System.out.println("embedScreenshot");
			byte[] screenshot = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.BYTES);
			File screenshot1 = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			scenario.embed(screenshot, "image/jpeg");

			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat formater = new SimpleDateFormat(
					"dd_MM_yyyy_hh_mm_ss");
			try {
				FileUtils
						.copyFile(
								screenshot1,
								new File("screenshots/" + scenario.getName()
										+ "_"
										+ formater.format(calendar.getTime())
										+ ".jpg"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
*/
	public static void tearDown() {
		 driver.quit();
       
	}

	static Map<String, String> productName = new HashMap<String, String>();

}
