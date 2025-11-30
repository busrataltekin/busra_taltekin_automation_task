package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverFactory;

public class BaseTest {

    @BeforeMethod
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser) {
        DriverFactory.initDriver(browser);
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }

    protected void openBaseUrl() {
        openBaseUrl("");
    }

    protected void openBaseUrl(String path) {
        String baseUrl = ConfigReader.get("baseUrl");

        if (!path.isEmpty()) {
            if (!baseUrl.endsWith("/") && !path.startsWith("/")) {
                baseUrl += "/";
            }
            baseUrl += path;
        }

        openUrl(baseUrl);
    }

    protected void openUrl(String url) {
        WebDriver driver = DriverFactory.getDriver();
        driver.get(url);
    }

}
