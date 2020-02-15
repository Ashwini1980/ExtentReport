/**
 * 
 */
package com.home.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.home.designPattern.SingletonBrowser;

/**
 * @author ashwini
 *
 */

/*
 * WebDriver initialization 
 * load properties class
 * Initialize of log4j file, log4j.jar, *.log file, log4j.properties, Logger class
 * DB connection details
 * Excel sheet load
 * Mail
 * ReportNG and Extent Report
 */

public class TestBase {
	
	public static WebDriver driver;
	public static Properties envProp = new Properties();
	public static Properties testDataProp = new Properties();
	public static FileInputStream fis1=null;
	public static FileInputStream fis2=null;
	public static Logger logger = Logger.getLogger(TestBase.class);
	
    public WebDriver getDriver() {
        return driver;
    }        

	public static void loadProperties(String envFile, String testDataFile) {
    
		try {
			
			fis1 = new FileInputStream(envFile);
			envProp.load(fis1);
			
			fis2 = new FileInputStream(testDataFile);
			testDataProp.load(fis2);
			
			logger.info("Both Properties file loaded.");
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public void initBrowser() {
		
		logger.info("Loading the base class destination.");
		
		if (driver == null) {
			
			SingletonBrowser.getInstance(driver);
			driver.manage().window().maximize();						
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(envProp.getProperty("implicit.wait")), TimeUnit.SECONDS);
		}

	}
	
    public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
    	  String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
    	  TakesScreenshot ts = (TakesScreenshot) driver;
    	  File source = ts.getScreenshotAs(OutputType.FILE);
    	  
    	  // after execution, you could see a folder "FailedTestsScreenshots" under src folder
    	  String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
    	  File finalDestination = new File(destination);
    	  FileUtils.copyFile(source, finalDestination);
    	  
    	  logger.info("Returned the File path as: "+destination);
    	  return destination;
    }

	
	

}
