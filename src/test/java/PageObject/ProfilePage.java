package PageObject;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {

    private WebDriver driver;

    //лого Stellar Burgers
    private final By headerBurgerLogo = By.xpath("//div[@class='AppHeader_header__logo__2D0X2']");
    //Кнопка Конструктор
    public final By builderButton = By.xpath("//p[text()='Конструктор']");
    //Кнопка Выход
    public final By LogOutButton = By.xpath("//button[text() = 'Выход']");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step
    @DisplayName("Кликнуть по лготипу сайта - переход на главную страницу")
    public MainPage clickOnSiteLogo() {
        driver.findElement(headerBurgerLogo).click();
        return new MainPage(driver);
    }

    @Step
    @DisplayName("Кликнуть по кнопке Конструктор - переход на главную страницу")
    public MainPage clickOnBuilderButton() {
        driver.findElement(builderButton).click();
        return new MainPage(driver);
    }

    @Step
    @DisplayName("Кликнуть по кнопке Выход в разделе Профиль")
    public RegistrationPage logOut() {
        driver.findElement(LogOutButton).click();
        return new RegistrationPage(driver);
    }

    @Step
    @DisplayName("Проверить, что кнопка Выйти отображается в профиле")
    public ProfilePage checkLogOutButtonIsDisplayed() {
        driver.findElement(LogOutButton).isDisplayed();
        return this;
    }
}
