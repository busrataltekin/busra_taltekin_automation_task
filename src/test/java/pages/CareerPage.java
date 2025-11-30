package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Set;

public class CareerPage extends BasePage {

    public CareerPage() {
        super();
    }

    private By teamsSection = By.xpath("//a[normalize-space()='See all teams']");
    private By locationsSection = By.xpath("//h3[normalize-space()='Our Locations']");
    private By lifeAtInsider = By.xpath("//h2[normalize-space()='Life at Insider']");
    private By seeAllQAJobsButton = By.cssSelector(".btn.btn-outline-secondary");
    private By qaDepartmentText = By.xpath("//span[@id='select2-filter-by-department-container']");
    private By locationSelection = By.cssSelector("#select2-filter-by-location-container");
    private By departmentsSelection = By.cssSelector("#select2-filter-by-department-container");
    private By locationDropdownItems = By.cssSelector("#select2-filter-by-location-results > li");
    private By jobInformationBlock = By.cssSelector(".position-list-item.col-12.col-lg-4");
    private By jobInformationBlockText = By.cssSelector("div.position-list-item-wrapper.bg-light");
    private By departmentDropdown = By.xpath("//span[@class='select2-results']");
    private By positionBlock = By.xpath("//div[contains(@class,'position-list-item-wrapper')]");
    private By positionDepartment = By.xpath(".//span[contains(@class,'position-department')]");
    private By positionLocation = By.xpath(".//div[contains(@class,'position-location')]");
    private By viewRoleButton = By.xpath("//a[contains(@class,'btn-navy') and text()='View Role']");


    public void scrollToTeamsSection() {
        scrollToElement(teamsSection);
    }

    public void scrollToLocationsSection() {
        scrollToElement(locationsSection);
    }

    public void scrollToLifeAtInsider() {
        scrollToElement(lifeAtInsider);
    }

    public boolean isTeamsSectionDisplayed() {
        return waitForVisibility(teamsSection).isDisplayed();
    }

    public boolean isLocationsSectionDisplayed() {
        return waitForVisibility(locationsSection).isDisplayed();
    }

    public boolean isLifeAtInsiderDisplayed() {
        return waitForVisibility(lifeAtInsider).isDisplayed();
    }

    public boolean isAt() {
        return getCurrentUrl().contains("careers");
    }

    public boolean isQualityAssurancePage() {
        return getCurrentUrl().contains("quality-assurance");
    }

    public void clickSeeAllQAJobs() {
        click(seeAllQAJobsButton);
    }

    public boolean isOpenPositionsPage() {
        return getCurrentUrl().contains("open-positions");
    }

    public void selectLocationOption(String location) {
        By locator = By.xpath("//li[contains(@class,'select2-results__option') and text()='" + location + "']");
        scrollToElement(locator);
        click(locator);
    }

    public void openLocationDropdownWhenReady() {
        waitForPageToLoad();
        click(locationSelection);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locationDropdownItems));

    }

    public String getDropdownContext(){

        return getElementText(qaDepartmentText, "×");
    }

    public boolean checkJobBlockDisplayed(){
        return waitForVisibility(jobInformationBlock).isDisplayed();
    }

    public String getJobBlockContext(){
        return getElementText(jobInformationBlockText, "Apply");
    }

    private By getDepartmentOption(String departmentName) {
        return By.xpath("//li[contains(@class,'select2-results__option')][text()='" + departmentName + "']");
    }

    public void openDepartmentDropdown() {
        click(departmentsSelection);
        waitForVisibility(departmentDropdown);
    }

    public void selectDepartment(String departmentName) {
        openDepartmentDropdown();

        By optionLocator = getDepartmentOption(departmentName);
        waitForVisibility(optionLocator);
        click(optionLocator);
    }

    public boolean checkJobRoleAndLocation (String roleName, String city) {

        String department = getElementText(positionDepartment);
        String location = getElementText(positionLocation);

        return department.equals(roleName) && location.contains(city);

    }

    public void hoverOverTheRole() {
        hover(positionBlock);
    }

    public void scrollToJobBlock() {
        scrollToElement(positionBlock);
    }

    public boolean checkRoleButtonDisplayed() {
        return waitForVisibility(viewRoleButton).isDisplayed();
    }

    public String clickViewRoleAndSwitchToNewTab() {
        String mainWindow = driver.getWindowHandle();

        click(viewRoleButton);

        Set<String> allWindows = driver.getWindowHandles();
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(mainWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        return getCurrentUrl();
    }



}
