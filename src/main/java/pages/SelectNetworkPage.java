package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SelectNetworkPage extends BasePage {

    @Step
    public ViewOnlyWalletAddingPage tapOnNetworkBox(String network) {
        driver.findElement(By.xpath("//android.widget.TextView[@text=\"" + network + "\"]")).click();
        return new ViewOnlyWalletAddingPage();
    }

}
