package pageobject.accessibility;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobject.BaseScreen;

public class NodeQueryingScreen extends BaseScreen {
    public NodeQueryingScreen(AndroidDriver driver) {
        super(driver);
    }

    private WebElement takeOutTrashCheckbox() {
        return driver.findElement(new By.ByXPath("//*[@content-desc='Task Take out Trash']/../*[contains(@class, 'CheckBox')]"));
    }

    private WebElement doLaundryCheckbox() {
        return driver.findElement(new By.ByXPath("//*[@content-desc='Task Do Laundry']/../*[contains(@class, 'CheckBox')]"));
    }

    private WebElement conquerWorldCheckbox() {
        return driver.findElement(new By.ByXPath("//*[@content-desc='Task Conquer World']/../*[contains(@class, 'CheckBox')]"));
    }

    private WebElement napCheckBox() {
        return driver.findElement(new By.ByXPath("//*[@content-desc='Task Nap']/../*[contains(@class, 'CheckBox')]"));
    }

    private WebElement doTaxesCheckbox() {
        return driver.findElement(new By.ByXPath("//*[@content-desc='Task Do Taxes']/../*[contains(@class, 'CheckBox')]"));
    }

    private WebElement abolishIRSCheckbox() {
        return driver.findElement(new By.ByXPath("//*[@content-desc='Task Abolish IRS']/../*[contains(@class, 'CheckBox')]"));
    }

    private WebElement teaWithAuntSharonCheckbox() {
        return driver.findElement(new By.ByXPath("//*[@content-desc='Task Tea with Aunt Sharon']/../*[contains(@class, 'CheckBox')]"));
    }

    public void takeOutTrash() {
        takeOutTrashCheckbox().click();
    }

    public void doLaundry() {
        doLaundryCheckbox().click();
    }

    public void conquerWorld() {
        conquerWorldCheckbox().click();
    }

    public void nap() {
        napCheckBox().click();
    }

    public void doTaxes() {
        doTaxesCheckbox().click();
    }

    public void abolishIRS() {
        abolishIRSCheckbox().click();
    }

    public void teaWithAuntSharon() {
        teaWithAuntSharonCheckbox().click();
    }
}
