package pageobject;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;


public class MainScreen extends BaseScreen {

    public MainScreen(AndroidDriver driver) {
        super(driver);
    }

    private WebElement app () {
        return buildScrollableUiSelector("App");
    }

    public void clickApp() {
        app().click();
    }
}
