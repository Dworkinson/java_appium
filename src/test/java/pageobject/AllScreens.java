package pageobject;

import io.appium.java_client.android.AndroidDriver;
import pageobject.accessibility.AccessibilityScreen;
import pageobject.accessibility.NodeProviderScreen;
import pageobject.accessibility.NodeQueryingScreen;
import pageobject.animations.AnimationsScreen;
import pageobject.animations.DefaultLayoutAnimationScreen;

public class AllScreens {
    public AccessibilityScreen accessibilityScreen;
    public NodeQueryingScreen nodeQueryingScreen;
    public NodeProviderScreen nodeProviderScreen;
    public AnimationsScreen animationsScreen;
    public MainScreen mainScreen;
    public DefaultLayoutAnimationScreen defaultLayoutAnimationScreen;

    public AllScreens(AndroidDriver driver) {
        accessibilityScreen = new AccessibilityScreen(driver);
        nodeProviderScreen = new NodeProviderScreen(driver);
        nodeQueryingScreen = new NodeQueryingScreen(driver);
        animationsScreen = new AnimationsScreen(driver);
        mainScreen = new MainScreen(driver);
        defaultLayoutAnimationScreen = new DefaultLayoutAnimationScreen(driver);
    }
}
