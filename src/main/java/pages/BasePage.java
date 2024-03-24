package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.DriverUtils;

public class BasePage {

    protected AppiumDriver driver;

    public BasePage() {
        this.driver = DriverUtils.getDriver();
    //    this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    protected void waitAndTap(WebElement element) {
        element.click();
    }

    protected void waitAndTypeText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    protected String waitAndGetText(WebElement element) {
        String text = element.getText();
        Allure.addAttachment("Element contains text", text);
        return text;
    }

    protected String getTextFormClipboard() {
        String text = ((AndroidDriver) driver).getClipboardText();
        Allure.addAttachment("Clipboard text", text);
        return text;
    }

}
