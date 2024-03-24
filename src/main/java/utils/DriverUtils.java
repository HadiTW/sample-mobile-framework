package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverUtils {

    private static AppiumDriver driver;

    public static void initializeDriver(String platformName) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", System.getProperty("user.dir") + "/src/apps/android/androidAPP.apk");
        capabilities.setCapability("platformName", platformName);
   //     capabilities.setCapability("deviceName", "Pixel3A");
        capabilities.setCapability("automationName", "UiAutomator2");

        try {
            URL url = new URL("http://127.0.0.1:4725/wd/hub");
            switch (platformName) {
                case "Android":  driver = new AndroidDriver(url, capabilities);
                break;
                default: throw new RuntimeException("Only Android platformName is supported");
            }

        } catch (MalformedURLException e) {
            throw new RuntimeException("Appium server URL is invalid", e);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
    }

    public static AppiumDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("Driver not initialized. Please call initializeDriver first.");
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
