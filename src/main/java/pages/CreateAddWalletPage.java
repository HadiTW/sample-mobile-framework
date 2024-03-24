package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateAddWalletPage extends BasePage {


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Create new wallet']")
    private WebElement createNewWalletBox;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Add existing wallet']")
    private WebElement addExistingWalletBox;


    @Step
    public BackUpSecretPhrasePage tapOnCreateNewWallet() {
        waitAndTap(createNewWalletBox);
        return new BackUpSecretPhrasePage();
    }

    @Step
    public AddExistingWalletPage tapOnAddExistingWallet() {
        waitAndTap(addExistingWalletBox);
        return new AddExistingWalletPage();
    }

}
