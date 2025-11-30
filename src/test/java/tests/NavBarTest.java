package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CareerPage;
import pages.NavBarPage;

public class NavBarTest extends BaseTest {

    @Test
    public void checkCareerPageNavigation() {
        openBaseUrl();
        NavBarPage nav = new NavBarPage();
        CareerPage career = nav.goToCareerPage();
        Assert.assertTrue(career.isAt());
    }
}
