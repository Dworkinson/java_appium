package pageobject;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;


public class MainScreen extends BaseScreen {

    public MainScreen(AndroidDriver driver) {
        super(driver);
    }

    private WebElement title() {
        return buildUiSelector("android.widget.TextView", "className");
    }
    private WebElement accessibility() {
        return buildUiSelector("Accessibility", "description");
    }

    private WebElement animations() {
        return buildUiSelector("Animation", "description");
    }

    private WebElement app() {
        return buildUiSelector("App", "description");
    }

    private WebElement content() {
        return buildUiSelector("Content", "description");
    }

    private WebElement graphics() {
        return buildUiSelector("Graphics", "description");
    }

    private WebElement media() {
        return buildUiSelector("Media", "description");
    }

    private WebElement nfc() {
        return buildUiSelector("NFC", "description");
    }

    private WebElement os() {
        return buildUiSelector("OS", "description");
    }

    private WebElement preference() {
        return buildUiSelector("Preference", "description");
    }

    private WebElement text() {
        return buildUiSelector("Text", "description");
    }

    private WebElement views() {
        return buildUiSelector("Views", "description");
    }

    public String getTitle() {
        return title().getText();
    }

    public void clickAccessibility() {
        accessibility().click();
    }

    public void clickAnimations() {
        animations().click();
    }

    public void clickApp() {
        app().click();
    }

    public void clickContent() {
        content().click();
    }

    public void clickGraphics() {
        graphics().click();
    }

    public void clickMedia() {
        media().click();
    }

    public void clickNfc() {
        nfc().click();
    }

    public void clickOs() {
        os().click();
    }

    public void clickText() {
        text().click();
    }

    public void clickViews() {
        views().click();
    }
}
