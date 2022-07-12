package pageobject.animations;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import pageobject.BaseScreen;

public class DefaultLayoutAnimationScreen extends BaseScreen {
    public DefaultLayoutAnimationScreen(AndroidDriver driver) {
        super(driver);
    }

    private WebElement addButtonBtn() {
        return buildUiSelector("Add Button", "description");
    }

    private WebElement addedButton(int number) {
        return buildUiSelector(String.valueOf(number), "text");
    }

    public void addButton() {
        addButtonBtn().click();
    }

    public void removeButton(int number) {
        addedButton(number).click();
    }

    public Boolean isAddedButtonDisplayed(int number) {
        Boolean displayed;
        try {
            displayed = addedButton(number).isDisplayed();
        } catch (NoSuchElementException ignored) {
            displayed = false;
        }
        return displayed;
    }
}
