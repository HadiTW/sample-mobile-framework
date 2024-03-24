package popUps;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class StartUsingTrustWalletPopUp extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Start using Trust Wallet\"]")
    private WebElement startUsingTrustWalletButton;

    public PermissionsPopUp tapOnStartUsingTrustWalletButton() {
        waitAndTap(startUsingTrustWalletButton);
        return new PermissionsPopUp();
    }

}
