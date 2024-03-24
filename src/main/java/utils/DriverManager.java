package utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {

    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    public static WebDriver getDriver() {
        WebDriver driver = DRIVER.get();
        if (driver == null) {
            initializeDriver();
            return DRIVER.get();
        }
      return driver;
    }

    public static void removeDriver() {
        WebDriver driver = DRIVER.get();
        if (driver != null) {
            DRIVER.set(driver);
            DRIVER.remove();
        }
    }

    private static void initializeDriver() {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("app", System.getProperty("user.dir") + "/src/apps/android/androidAPP.apk");
            capabilities.setCapability("platformName", "Android");
        //    capabilities.setCapability("deviceName", "Pixel3A");
            capabilities.setCapability("automationName", "UiAutomator2");

        WebDriver driver;
            try {
              driver = new AppiumDriver(new URL("http://127.0.0.1:4725/wd/hub"), capabilities);
            } catch (MalformedURLException e) {
                throw new RuntimeException("Appium server URL is invalid", e);
            }
        DRIVER.set(driver);
    }

}
