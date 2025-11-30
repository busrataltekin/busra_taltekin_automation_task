package pages;

import org.openqa.selenium.By;

public class NavBarPage extends BasePage {

    private By companySection = By.xpath("(//a[@class='nav-link dropdown-toggle hide-after'])[5]");
    private By careersLink = By.xpath("//a[normalize-space()='Careers']");

    public NavBarPage() {
        super();
    }

    public CareerPage goToCareerPage() {
        hover(companySection);
        click(careersLink);
        return new CareerPage();
    }
}
