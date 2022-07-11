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
    public void doNothing() {
        Assert.assertEquals(allScreens.mainScreen.getTitle(), "API Demos");
        allScreens.mainScreen.clickAccessibility();
        allScreens.accessibilityScreen.clickNodeQuerying();
        allScreens.nodeQueryingScreen.clickTakeOutTrash();
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