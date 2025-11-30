package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    public BasePage() {
        this.driver = utils.DriverFactory.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.actions = new Actions(driver);
    }

    public WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void click(By locator) {
        waitForVisibility(locator).click();
    }

    public void scrollToElement(By locator) {
        int maxScrolls = 12;
        int count = 0;

        while (count < maxScrolls) {
            try {
                WebElement el = driver.findElement(locator);
                if (el.isDisplayed()) {
                    ((JavascriptExecutor) driver).executeScript(
                            "arguments[0].scrollIntoView({behavior:'smooth', block:'center'});",
                            el
                    );
                    pause(400);
                    return;
                }
            } catch (Exception ignored) {}

            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 350);");
            pause(300);
            count++;
        }
    }

    public void hover(By locator) {
        actions.moveToElement(waitForVisibility(locator)).perform();
    }

    public void pause(long ms) {
        try { Thread.sleep(ms); } catch (Exception ignored) {}
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }


    public void waitForPageToLoad() {
        wait.until(d -> ((JavascriptExecutor) driver)
                .executeScript("return document.readyState").equals("complete"));
        try {
            wait.until(d -> (Boolean) ((JavascriptExecutor) driver)
                    .executeScript("return window.jQuery != undefined && jQuery.active === 0"));
        } catch (Exception ignored) {
        }
    }

    public String getElementText(By locator, String... textsToRemove) {
        String text = waitForVisibility(locator).getText().trim();
        if (textsToRemove != null) {
            for (String t : textsToRemove) {
                text = text.replace(t, "").trim();
            }
        }
        return text;
    }


}
