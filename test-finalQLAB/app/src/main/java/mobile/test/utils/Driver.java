package mobile.test.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

public class Driver {
    private static AndroidDriver<AndroidElement> driver;

    public static AndroidDriver<AndroidElement> getDriver() throws MalformedURLException {
        if (driver == null) {
            driver = initializeDriver();
        }
        return driver;
    }

    private static AndroidDriver<AndroidElement> initializeDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = setCapabilities();
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        return new AndroidDriver<>(url, capabilities);
    }

    private static DesiredCapabilities setCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android Emulator");

        // Actualización de la ruta del APK
        String apkPath = Paths.get(System.getProperty("user.dir"), "app", "saucelabs-app.apk").toString();
        capabilities.setCapability("app", apkPath);

        capabilities.setCapability("automationName", "UiAutomator2");
        return capabilities;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}