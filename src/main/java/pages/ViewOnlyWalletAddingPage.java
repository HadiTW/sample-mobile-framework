package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

public class ViewOnlyWalletAddingPage extends BasePage {

    @AndroidFindBy(xpath = "//*[@text=\"Wallet name\"]//following-sibling::android.widget.EditText[1]")
    private WebElement walletNameTextBox;

    @AndroidFindBy(xpath = "//*[@text=\"Address or Domain Name\"]//following-sibling::android.widget.EditText")
    private WebElement addressOrDomainNameTextBox;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Confirm\"]")
    private WebElement confirmButton;

    @Step
    public ViewOnlyWalletAddingPage typeIntoWalletNameTextBox(String walletName) {
        waitAndTypeText(walletNameTextBox, walletName);
        return this;
    }

    @Step
    public ViewOnlyWalletAddingPage typeIntoAddressOrDomainNameTextBox(String addressOrDomainName) {
        waitAndTypeText(addressOrDomainNameTextBox, addressOrDomainName);
        return this;
    }

    @Step
    public PasscodePage TapOnConfirmButton() {
        waitAndTap(confirmButton);
        return new PasscodePage();
    }

}
