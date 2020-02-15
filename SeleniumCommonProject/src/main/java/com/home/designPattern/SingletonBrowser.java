/**
 * 
 */
package com.home.designPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.home.base.TestBase;

/**
 * @author ashwini
 *
 */
public class SingletonBrowser extends TestBase {
	
	public static SingletonBrowser instance = null;	
	
	private SingletonBrowser() {	

		if(envProp.getProperty("browser").equalsIgnoreCase("Chrome")) {
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/resources/executables/chromedriver.exe");
			driver = new ChromeDriver();
			logger.info("Chrome driver loaded.");
			
		} else if(envProp.getProperty("browser").equalsIgnoreCase("Firefox")) {
			
			System.setProperty("webdriver.gecko.driver", "./src/main/resources/executables/geckodriver.exe");
			driver = new FirefoxDriver();
			logger.info("FireFox driver loaded.");
			
		} else if(envProp.getProperty("browser").equalsIgnoreCase("IE")) {
			
			System.setProperty("webdriver.ie.driver", "./src/main/resources/executables/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			logger.info("InterExplorer driver loaded.");
			
		} else if(envProp.getProperty("browser").equalsIgnoreCase("Edge")) {
			
			System.setProperty("webdriver.edge.driver", "./src/main/resources/executables/msedgedriver.exe");
			driver = new EdgeDriver();
			logger.info("Edge driver loaded.");
			
		} else if(null == envProp.getProperty("browser") || envProp.getProperty("browser") == "" ) {
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/resources/executables/chromedriver.exe");
			driver = new ChromeDriver();
			logger.info("Chrome driver loaded.");
			
		}
	}
	
	public static SingletonBrowser getInstance(WebDriver driver) {
		
		//if(instance == null) {
			
			instance = new SingletonBrowser();
		//}
		
		return instance;
	}

}
