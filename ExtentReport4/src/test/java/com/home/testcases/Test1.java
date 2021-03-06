package com.home.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.home.common.extent.ExtentService;
import com.home.common.extent.ExtentTestManager;

public class Test1 {
	WebDriver driver;
	
    static {
    	
        System.setProperty("extent.reporter.html.start", "true");
        System.setProperty("extent.reporter.html.config", "./src/main/resources/extentReport/html-config.xml");
        System.setProperty("extent.reporter.html.out", "test-output/ExtentReport/ExtentReport.html");
    }
    
    @BeforeSuite
    public void setUp() {
    	
    	ExtentService.getInstance().setSystemInfo("Dev Name", "Ashwin Pattanayak");
    	ExtentService.getInstance().setSystemInfo("Broser Name", "Chrome");
    	ExtentService.getInstance().setSystemInfo("OS", "WINDOWS 10");
    }

	@Test
	public void searchOrder() {		
		
		ExtentTestManager.getTest().info("Test Case started.");
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/resources/executables/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.gmail.com");
		
	}
	
	@Test
	public void init1() {
		
		ExtentTestManager.getTest().info("Test Case started.");
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/resources/executables/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.gmail.com");
		Assert.assertTrue(false);
		
	}
	
	@Test
	public void init2() {
		
		ExtentTestManager.getTest().info("Test Case started.");
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/resources/executables/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.gmail.com");
		Assert.assertTrue(false);
		
	}
	
	@AfterMethod
	public void quit() {
		
		driver.close();
	}
}
