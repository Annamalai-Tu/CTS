package com.cts.utils;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.cts.base.BaseTest;

public class TestUtils extends BaseTest {

;

    public static void captureScreenshot(String testName) {
       
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File("E:\\CTS\\customer-travel-solution\\cts-screenshots\\" + testName + ".png"));
            System.out.println("Screenshot taken for test case: " + testName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
