package pageobject;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Collections;

public class AnimationsScreen extends BaseScreen {
    public AnimationsScreen(AndroidDriver driver) {
        super(driver);
    }

    private WebElement seeking() {
        return buildUiSelector("Seeking", "description");
    }

    private WebElement seekBar() {
//        return buildUiSelector("io.appium.android.apis:id/seekBar", "resourceId");
        return driver.findElement(new By.ById("io.appium.android.apis:id/seekBar"));
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
