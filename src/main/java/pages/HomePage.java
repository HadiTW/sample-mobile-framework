package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Main Wallet 1\"]/../following-sibling::android.view.View[1]")
    private WebElement yourAddressesSmallIcon;

    @AndroidFindBy(xpath = "//*[@resource-id=\"main_balance\"]")
    private WebElement mainBalanceText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"main_balance\"]/..//following-sibling::android.view.View/*")
    private WebElement viewOnlyWallerNotificationBox;


    @Step
    public YourAddressesPage tapOnYourAddressesSmallIcon() {
        waitAndTap(yourAddressesSmallIcon);
        return new YourAddressesPage();
    }

    @Step
    public String getMainBalanceText() {
        return waitAndGetText(mainBalanceText);
    }

    @Step
    public String getTextFormClipboardOnHomePage() {
       return getTextFormClipboard();
    }

    @Step
    public String getViewOnlyWallerNotificationBoxText() {
        return waitAndGetText(viewOnlyWallerNotificationBox);
    }

}
