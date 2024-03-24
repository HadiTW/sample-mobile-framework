package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.StartPage;

@Epic("Customer onboarding flow")
@Feature("Add existing wallet")
public class AddExistingWalletTest extends BaseTest {

    @Story("Add view-only wallet")
    @Severity(SeverityLevel.MINOR)
    @Owner("Andrii N")
    @Test(testName = "Successful view-only Wallet addition",
            description = "Wallet was successfully added (expected balance is visible)")
    public void verifyThatViewOnlyWalletIsAdded() {

        final int PASSCODE = 976679;

        HomePage homePage =
                new StartPage()
                        .tapOnGetStartedButton()
                        .tapOnAddExistingWallet()
                        .tapOnViewOnlyWallet()
                        .tapOnNetworkBox("Ethereum")
                        .typeIntoWalletNameTextBox("Test view-only wallet")
                        .typeIntoAddressOrDomainNameTextBox("0x6fe88f40941AB3880f7A7cf8C326B03491ec0574")
                        .TapOnConfirmButton()
                        .enterNewPasscode(PASSCODE)
                        .confirmNewPasscode(PASSCODE)
                        .tapOnStartUsingTrustWalletButton()
                        .tapOnAllowPermissionButton();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(homePage.getMainBalanceText(), "$0.00", "Balance is not the same as expected");
        softAssert.assertEquals(homePage.getViewOnlyWallerNotificationBoxText(), "View-only wallet",
                "View-only notification section is not present or text is different");
        softAssert.assertAll();
    }

}