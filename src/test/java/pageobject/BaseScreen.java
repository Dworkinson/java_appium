package pageobject;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;

public class BaseScreen {
    public AndroidDriver driver;
    public Actions actions;
    PointerInput finger;

    public BaseScreen(AndroidDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
        this.finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
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
