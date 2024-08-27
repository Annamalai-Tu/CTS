package com.cts.listeners;


import org.testng.ITestListener;
import org.testng.ITestResult;

import com.cts.utils.ExtentReportManager;
import com.cts.utils.TestUtils;

public class TestListener implements ITestListener {

   
    @Override
    public void onTestFailure(ITestResult result) {
    	 ExtentReportManager.getTest().fail(result.getThrowable());
        System.out.println("Test Failed: " + result.getName());
        // Capture screenshot on failure
        TestUtils.captureScreenshot(result.getName());
    }

    
}
