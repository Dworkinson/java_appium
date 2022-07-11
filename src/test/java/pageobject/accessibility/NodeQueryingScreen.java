package pageobject.accessibility;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobject.BaseScreen;

public class NodeQueryingScreen extends BaseScreen {
    public NodeQueryingScreen(AndroidDriver driver) {
        super(driver);
    }

    private WebElement takeOutTrashCheckBox() {
        return driver.findElement(new By.ByXPath("//*[@content-desc, 'Task Take out Trash']/../*[contains(@class, 'CheckBox')]"));
    }

    public void clickTakeOutTrash() {
        takeOutTrashCheckBox().click();
    }
}
