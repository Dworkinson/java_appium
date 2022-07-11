package pageobject.accessibility;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import pageobject.BaseScreen;

public class AccessibilityScreen extends BaseScreen {
    public AccessibilityScreen(AndroidDriver driver) {
        super(driver);
    }

    private WebElement nodeProvider() {
        return buildUiSelector("Accessibility Node Provider", "description");
    }

    private WebElement nodeQuerying() {
        return buildUiSelector("Accessibility Node Querying", "description");
    }

    private WebElement service() {
        return buildUiSelector("Accessibility Service", "description");
    }

    private WebElement customView() {
        return buildUiSelector("Custom View", "description");
    }

    public void clickNodeProvider() {
        nodeProvider().click();
    }

    public void clickNodeQuerying() {
        nodeQuerying().click();
    }

    public void clickCustomView() {
        customView().click();
    }
}
