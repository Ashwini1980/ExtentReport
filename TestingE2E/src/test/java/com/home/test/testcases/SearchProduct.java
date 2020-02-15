package com.home.test.testcases;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.home.base.TestBase;
import com.home.extentReport.ExtentManager;
import com.home.extentReport.ExtentTestManager;

public class SearchProduct extends TestBase{
	
	String envFile;
	String testdataFile;
	
	@BeforeSuite
	public void setUp() {
		
		envFile = "D:\\Automation\\workplace\\workingFinal\\TestingE2E\\src\\test\\resources\\properties\\Environment.properties";
		testdataFile = "D:\\Automation\\workplace\\workingFinal\\TestingE2E\\src\\test\\resources\\properties\\TestData.properties";
		loadProperties(envFile, testdataFile);
		
		ExtentManager.getInstance().setSystemInfo("AuthorName", "Ashwin Pattanayak");
		ExtentManager.getInstance().setSystemInfo("Browser Name", envProp.getProperty("browser"));
		ExtentManager.getInstance().setSystemInfo("OS", envProp.getProperty("os.name"));
		
	} 
	
	@BeforeMethod
	public void initMethod() {
		
		initBrowser();
	}
	
	@Test (priority = 0, description = "Search a product from Amazon.")
	public void searchProduct() {
		
		ExtentTestManager.getTest().info("Test Execution started");
		driver.get(envProp.getProperty("baseURL"));
		logger.info("Browser opened successfully.");
		
	}
	
	@Test  (priority = 1, description = "Login to Gmail.")
	public void searchProduct1() {

		ExtentTestManager.getTest().info("Test Execution started");
		driver.get("https://www.gmail.com");
		logger.info("Browser opened successfully.");
		Assert.assertTrue(false);
		
	}
	
	/*
	 * @AfterMethod public void cleanUp() {
	 * 
	 * if(driver != null) {
	 * 
	 * driver.close(); } }
	 */
}
