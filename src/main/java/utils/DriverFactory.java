package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class DriverFactory {
    protected static ThreadLocal<ChromeDriver> driver = new ThreadLocal<>();

    public static void initDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver.set(new ChromeDriver(chromeOptions));
        driver.get().manage().window().maximize();
    }


    public static ChromeDriver getDriver() {
        return driver.get();
    }

    public static void quiteDriver() {
        getDriver().quit();
    }

    public static void setImplicitWait(int second) {
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(second));

    }

    public static void setPageLoadTimeout(int second) {
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(second));
    }

    public static void goToUrl(String url) {
        getDriver().get(url);
    }
}