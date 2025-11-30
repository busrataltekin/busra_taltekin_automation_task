package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CareerPage;
import pages.NavBarPage;

public class CareerPageTest extends BaseTest {

    @Test
    public void verifyCareerPageSections() {
        openBaseUrl();
        NavBarPage nav = new NavBarPage();
        CareerPage career = nav.goToCareerPage();

        Assert.assertTrue(career.isAt(), "Career page URL mismatch");

        career.scrollToTeamsSection();
        Assert.assertTrue(career.isTeamsSectionDisplayed());

        career.scrollToLocationsSection();
        Assert.assertTrue(career.isLocationsSectionDisplayed());

        career.scrollToLifeAtInsider();
        Assert.assertTrue(career.isLifeAtInsiderDisplayed());
    }

    @Test
    public void checkQualityAssuranceCareerPage() {
        openBaseUrl("careers/quality-assurance/");
        CareerPage career = new CareerPage();
        Assert.assertTrue(career.isQualityAssurancePage());
        career.clickSeeAllQAJobs();
        Assert.assertTrue(career.isOpenPositionsPage());
        career.openLocationDropdownWhenReady();
        career.selectLocationOption("Istanbul, Turkiye");
        String dropdownContext = career.getDropdownContext();
        Assert.assertTrue(dropdownContext.contains("Quality Assurance"));
        boolean checkJobBlock = career.checkJobBlockDisplayed();
        Assert.assertTrue(checkJobBlock);
        String qaBlockContext = career.getJobBlockContext();
        Assert.assertTrue(qaBlockContext.contains("Quality Assurance"));
    }

    @Test
    public void checkOpenPositionsPage() throws InterruptedException {
        //If I put static waits in this test, it won’t fail,
        // but after the Open Positions dropdown selection,
        // it resets itself and then corrects. I
        // ’m not adding waits so that this bug remains visible.
        openBaseUrl("careers/open-positions/");
        CareerPage career = new CareerPage();
        Assert.assertTrue(career.isOpenPositionsPage());
        career.openLocationDropdownWhenReady();
        career.selectLocationOption("Istanbul, Turkiye");
        career.selectDepartment("Quality Assurance");
        boolean roleResult = career.checkJobRoleAndLocation("Quality Assurance", "Istanbul");
        Assert.assertTrue(roleResult);
    }

    @Test
    public void viewRole() throws InterruptedException {
        openBaseUrl("careers/open-positions/");
        CareerPage career = new CareerPage();
        career.openLocationDropdownWhenReady();
        career.selectLocationOption("Istanbul, Turkiye");
        Thread.sleep(3000);
        career.selectDepartment("Quality Assurance");
        Thread.sleep(3000);
        career.scrollToJobBlock();
        career.hoverOverTheRole();
        boolean checkViewRoleButton = career.checkRoleButtonDisplayed();
        Assert.assertTrue(checkViewRoleButton);
        String newUrl = career.clickViewRoleAndSwitchToNewTab();
        Assert.assertTrue(newUrl.contains("jobs.lever.co"));
    }
}
