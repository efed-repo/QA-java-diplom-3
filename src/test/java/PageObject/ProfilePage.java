package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {

    private WebDriver driver;

    //лого Stellar Burgers
    private final By headerBurgerLogo = By.xpath("//div[@class='AppHeader_header__logo__2D0X2']");
    //Кнопка Конструктор
    public final By builderButton = By.xpath("//p[text()='Конструктор']");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    private MainPage clickOnSiteLogo() {
        driver.findElement(headerBurgerLogo).click();
        return new MainPage(driver);
    }

    private MainPage clickOnBuilderButton() {
        driver.findElement(builderButton).click();
        return new MainPage(driver);
    }
}
