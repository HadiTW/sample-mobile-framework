package tests;

import org.testng.annotations.Test;
import pages.BasePage;
import pages.StartPage;

public class SampleTest extends BaseTest {

    @Test(description = "Sample description")
    public void sampleTest() {

        new StartPage()
                .tapOnGetStartedButton()
                .tapOnCreateNewWallet();

    }

}