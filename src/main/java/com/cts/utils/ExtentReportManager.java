package com.cts.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
	private static ExtentSparkReporter spark;
	private static ExtentReports extent;
	private static ExtentTest test;

	public static ExtentReports getInstance() {
        if (extent == null) {
            String reportPath = "E:\\CTS\\customer-travel-solution\\reports\\report.html";
            spark = new ExtentSparkReporter(reportPath);
            spark.config().setReportName("Automation Test Results");
            spark.config().setDocumentTitle("Test Report");

            extent = new ExtentReports();
            extent.attachReporter(spark);
            extent.setSystemInfo("Tester", "Annamalai");
            extent.setSystemInfo("Environment", "QA");
        }
        return extent;
    }

	public static ExtentTest createTest(String testName) {
		test = getInstance().createTest(testName);
		return test;
	}

	public static ExtentTest getTest() {
		return test;
	}
}
