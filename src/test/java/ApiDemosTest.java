import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.junit.*;
import pageobject.AnimationsScreen;
import pageobject.MainScreen;

public class ApiDemosTest {
    public static final int PORT = 4723;

    private static AppiumDriverLocalService service;
    public static AndroidDriver driver;

    public static MainScreen mainScreen;
    public static AnimationsScreen animationsScreen;

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

        mainScreen = new MainScreen(driver);
        animationsScreen = new AnimationsScreen(driver);
    }

    @Test
    public void doNothing() {
        Assert.assertEquals(mainScreen.getTitle(), "API Demos");
        mainScreen.clickAnimations();
        animationsScreen.clickSeeking();
        animationsScreen.moveBar();
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