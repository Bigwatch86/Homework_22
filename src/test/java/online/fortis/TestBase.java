package online.fortis;

import com.codeborne.selenide.Configuration;
import drivers.EmulatorMobileDriver;
import drivers.RealDeviceDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

public class TestBase {
    private static final String deviceHost = System.getProperty("deviceHost");

    @BeforeAll
    public static void setup() {
        addListener("AllureSelenide", new AllureSelenide());

        Configuration.browser = getDeviceDriver(deviceHost);
        Configuration.browserSize = null;
    }

    @BeforeEach
    public void startDriver() {

        open();
    }

    @AfterEach
    public void afterEach() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();

        closeWebDriver();
    }

    public static String getDeviceDriver(String deviceHost) {
        switch (deviceHost) {
            case "emulator":
                return EmulatorMobileDriver.class.getName();
            case "realDevice":
                return RealDeviceDriver.class.getName();
        }
        return null;
    }
}
