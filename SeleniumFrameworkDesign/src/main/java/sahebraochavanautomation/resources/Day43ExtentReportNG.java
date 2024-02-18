package sahebraochavanautomation.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Day43ExtentReportNG {
	
	public static ExtentReports getReportObject()
	{
		String path = System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Sahe Web Automation Results");
		reporter.config().setDocumentTitle("Test Result");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Saheb");
		return extent;
	}

}
