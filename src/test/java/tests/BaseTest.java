package tests;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.DriverManager;
import utils.DriverUtils;

public class BaseTest {

    @BeforeMethod
    @Parameters({"platformName"})
    public void setUp(@Optional("Android") String platformName) {

        DriverUtils.initializeDriver(platformName);

    //   driver = DriverManager.getDriver();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        DriverUtils.quitDriver();
  //      DriverManager.removeDriver();
    }

}
