package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.StartPage;
import utils.BlockchainExplorerVerifier;

import java.util.List;

@Epic("Customer onboarding flow")
@Feature("Create new wallet")
public class CreateNewWalletTest extends BaseTest {

    @Story("Create new wallet without back up secret phase")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Andrii N")
    @Test(testName = "Successful new Wallet creation",
            description = "New wallet was successfully created (wallet BTC address is visible on blockchain explorer)")
    public void verifyThatNewWalletIsCreated() {

        final int PASSCODE = 123321;

        HomePage homePage =
                new StartPage()
                        .tapOnGetStartedButton()
                        .tapOnCreateNewWallet()
                        .tapOnSkipBackUpSecretPhraseLink()
                        .enterNewPasscode(PASSCODE)
                        .confirmNewPasscode(PASSCODE)
                        .tapOnStartUsingTrustWalletButton()
                        .tapOnAllowPermissionButton();

        Assert.assertEquals(homePage.getMainBalanceText(), "$0.00", "Balance for new wallet should be 0");

        String actualAddress =
                homePage
                        .tapOnYourAddressesSmallIcon()
                        .tapOnBitcoinAddress()
                        .getTextFormClipboardOnHomePage();

        List<BlockchainExplorerVerifier.BlockchainExplorerResponse> blockchainExplorerResponse =
                BlockchainExplorerVerifier.getVerifyBlockchainExplorerResponse(actualAddress);

        Assert.assertEquals(blockchainExplorerResponse.size(), 1, "Address was not created or few addresses were created");
        Assert.assertEquals(blockchainExplorerResponse.get(0).getChain(), "BTC", "Chain is not BTC");
    }

}