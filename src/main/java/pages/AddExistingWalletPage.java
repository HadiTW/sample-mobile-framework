package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

public class AddExistingWalletPage extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"View-only wallet\"]")
    private WebElement viewOnlyWalletBox;

    @Step
    public SelectNetworkPage tapOnViewOnlyWallet() {
        waitAndTap(viewOnlyWalletBox);
        return new SelectNetworkPage();
    }

}
