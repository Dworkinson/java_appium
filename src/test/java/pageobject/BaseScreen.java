package pageobject;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

public class BaseScreen {
    public AndroidDriver driver;

    public BaseScreen(AndroidDriver driver) {
        this.driver = driver;
    }

    protected WebElement buildUiSelector(String text) {
        return buildUiSelector(text, "textContains");
    }

    protected WebElement buildUiSelector(String text, String method) {
        String selectorText = "new UiSelector()." + method + "(\"" + text + "\")";
        return driver.findElement(new AppiumBy.ByAndroidUIAutomator(selectorText));
    }

    protected WebElement buildScrollableUiSelector(String text) {
        return buildScrollableUiSelector(text, "textContains");
    }

    protected WebElement buildScrollableUiSelector(String text, String method) {
        String selectorText = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector()." + method + "(\"" + text + "\"))";
        return driver.findElement(new AppiumBy.ByAndroidUIAutomator(selectorText));
    }
}
