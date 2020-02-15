/**
 * 
 */
package com.home.extentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * @author ashwini
 *
 */

public class ExtentManager {
	
    static ExtentReports extent;
    static ExtentHtmlReporter htmlReporter;
    
    public static ExtentReports getInstance() {
        return extent;
    }
    
    public static ExtentReports createInstance(String fileName) {
    	
        htmlReporter = new ExtentHtmlReporter(fileName);

        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setDocumentTitle(fileName);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName(fileName); 
        
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        
        return extent;
    }

}