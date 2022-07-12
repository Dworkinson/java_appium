import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.junit.*;
import pageobject.AllScreens;

public class ApiDemosTest {
    public static final int PORT = 4723;

    private static AppiumDriverLocalService service;
    public static AndroidDriver driver;

    public static AllScreens allScreens;
    @BeforeClass
    public static void start() {
        service = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                .usingPort(PORT)
                .withArgument(GeneralServerFlag.BASEPATH, "/wd/hub")
                .build();
        service.start();

        UiAutomator2Options options = new UiAutomator2Options()
                .setDeviceName("android")
                .setApp("D:/andrew/java/untitled1/src/test/resources/ApiDemos-debug.apk")
                .eventTimings();
        driver = new AndroidDriver(service.getUrl(), options);

        allScreens = new AllScreens(driver);
    }

    @Test
    public void checkBoxes() {
        Assert.assertEquals(allScreens.mainScreen.getTitle(), "API Demos");
        allScreens.mainScreen.clickAccessibility();
//        allScreens.accessibilityScreen.clickNodeQuerying();

//        allScreens.nodeQueryingScreen.takeOutTrash();
//        allScreens.nodeQueryingScreen.doLaundry();
//        allScreens.nodeQueryingScreen.conquerWorld();
//        allScreens.nodeQueryingScreen.nap();
//        allScreens.nodeQueryingScreen.doTaxes();
//        allScreens.nodeQueryingScreen.abolishIRS();
//        allScreens.nodeQueryingScreen.teaWithAuntSharon();
//
//        allScreens.nodeQueryingScreen.back();
//        allScreens.accessibilityScreen.clickCustomView();
    }

    @Test
    public void add_deleteButton() {
        driver.resetApp();
        allScreens.mainScreen.clickAnimations();
        allScreens.animationsScreen.clickDefaultLayoutAnimations();
        allScreens.defaultLayoutAnimationScreen.addButton();
        allScreens.defaultLayoutAnimationScreen.addButton();
        allScreens.defaultLayoutAnimationScreen.addButton();

        Assert.assertTrue(allScreens.defaultLayoutAnimationScreen.isAddedButtonDisplayed(1));
        Assert.assertTrue(allScreens.defaultLayoutAnimationScreen.isAddedButtonDisplayed(2));
        Assert.assertTrue(allScreens.defaultLayoutAnimationScreen.isAddedButtonDisplayed(3));

        allScreens.defaultLayoutAnimationScreen.removeButton(1);
        allScreens.defaultLayoutAnimationScreen.removeButton(2);
        allScreens.defaultLayoutAnimationScreen.removeButton(3);

        Assert.assertFalse(allScreens.defaultLayoutAnimationScreen.isAddedButtonDisplayed(1));
        Assert.assertFalse(allScreens.defaultLayoutAnimationScreen.isAddedButtonDisplayed(2));
        Assert.assertFalse(allScreens.defaultLayoutAnimationScreen.isAddedButtonDisplayed(3));
    }

    @AfterClass
    public static void end() {
        if(driver != null) {
            driver.quit();
        }
        if(service != null) {
            service.stop();
        }
    }
}