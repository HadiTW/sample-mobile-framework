package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StartPage extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Get Started']")
    private WebElement getStartedButton;


    @Step
    public CreateAddWalletPage tapOnGetStartedButton() {
        waitAndTap(getStartedButton);
        return new CreateAddWalletPage();
    }

}
