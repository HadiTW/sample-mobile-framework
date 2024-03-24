package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import popUps.StartUsingTrustWalletPopUp;

public class PasscodePage extends BasePage{

    private void typePasscode(int passcode) {
        for (char ch : String.valueOf(passcode).toCharArray()) {
            waitAndTap(driver.findElement(By.xpath("//android.widget.TextView[@text=\"" + ch + "\"]")));
        }
    }

    @Step
    public PasscodePage enterNewPasscode(int passcode) {
        typePasscode(passcode);
        return this;
    }

    @Step
    public StartUsingTrustWalletPopUp confirmNewPasscode(int passcode) {
        typePasscode(passcode);
        return new StartUsingTrustWalletPopUp();
    }

}
