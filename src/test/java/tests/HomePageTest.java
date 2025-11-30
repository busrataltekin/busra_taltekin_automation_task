package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTest extends BaseTest {

    @Test
    public void checkHomePageUrl() {
        openBaseUrl();
        HomePage home = new HomePage();
        Assert.assertEquals(home.getCurrentUrl(), "https://useinsider.com/");
    }

    @Test
    public void checkHeroSectionDisplayed() {
        openBaseUrl();
        HomePage home = new HomePage();
        Assert.assertTrue(home.isHeroSectionDisplayed());
    }
}
