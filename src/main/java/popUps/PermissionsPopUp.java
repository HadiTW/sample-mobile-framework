package popUps;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import pages.HomePage;

public class PermissionsPopUp extends BasePage {

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private WebElement allowPermissionButton;

    public HomePage tapOnAllowPermissionButton() {
        waitAndTap(allowPermissionButton);
        return new HomePage();
    }

}
