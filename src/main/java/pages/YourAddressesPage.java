package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

public class YourAddressesPage extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Bitcoin\"]")
    private WebElement bitcoinAddress;

    @Step
    public HomePage tapOnBitcoinAddress() {
        waitAndTap(bitcoinAddress);
        return new HomePage();
    }

}
