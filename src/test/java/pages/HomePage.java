package pages;

public class HomePage extends BasePage {

    public HomePage() {
        super(); // Driver otomatik gelir
    }

    private final org.openqa.selenium.By heroSection = org.openqa.selenium.By.className("hp_hero_with_animation");

    public boolean isHeroSectionDisplayed() {
        return waitForVisibility(heroSection).isDisplayed();
    }
}
