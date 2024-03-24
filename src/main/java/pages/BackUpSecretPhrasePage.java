package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.clipboard.ClipboardContentType;
import io.appium.java_client.clipboard.HasClipboard;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.datatransfer.Clipboard;

public class BackUpSecretPhrasePage extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"SKIP\"]")
    private WebElement skip;

    @Step
    public PasscodePage tapOnSkipBackUpSecretPhraseLink() {
        waitAndTap(skip);
        return new PasscodePage();
    }

}
