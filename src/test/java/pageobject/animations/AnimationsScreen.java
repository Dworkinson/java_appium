package pageobject.animations;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobject.BaseScreen;

public class AnimationsScreen extends BaseScreen {
    public AnimationsScreen(AndroidDriver driver) {
        super(driver);
    }

    private WebElement defaultLayoutAnimations() {
        return buildUiSelector("Default Layout Animations", "description");
    }

    private WebElement seeking() {
        return buildUiSelector("Seeking", "description");
    }

    private WebElement seekBar() {
        return driver.findElement(new By.ById("io.appium.android.apis:id/seekBar"));
    }

    public void clickDefaultLayoutAnimations() {
        defaultLayoutAnimations().click();
    }

    public void moveBar() {
        int xStart = seekBar().getLocation().getX();
        int xEnd = xStart + seekBar().getSize().getWidth();
        int y = seekBar().getLocation().getY();

        // using TouchAction - deprecated
//        TouchAction action = new TouchAction(driver);
//        action.press(new PointOption().withCoordinates(xStart, y)).moveTo(new PointOption().withCoordinates(xEnd, y)).release().perform();

        // using "finger"
//        Sequence sequence = new Sequence(finger, 1);
//        sequence.addAction(finger.createPointerMove(Duration.ofMillis(0),
//                PointerInput.Origin.viewport(), xStart, y));
//
//        sequence.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), xEnd, y));
//
//        driver.perform(Collections.singletonList(sequence));

        // using actions
        actions.dragAndDropBy(seekBar(), xEnd, y).perform();
    }

    public void clickSeeking() {
        seeking().click();
    }
}
