package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {

    private WebDriver driver;

    //лого Stellar Burgers
    private final By headerBurgerLogo = By.xpath("//div[@class='AppHeader_header__logo__2D0X2']");
    //Кнопка Конструктор
    public final By builderButton = By.xpath("//p[text()='Конструктор']");
    //Выход
    public final By LogOutButton = By.xpath("//button[text() = 'Выход']");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage clickOnSiteLogo() {
        driver.findElement(headerBurgerLogo).click();
        return new MainPage(driver);
    }

    public MainPage clickOnBuilderButton() {
        driver.findElement(builderButton).click();
        return new MainPage(driver);
    }

    public RegistrationPage logOut (){
        driver.findElement(LogOutButton).click();
        return new RegistrationPage(driver);
    }
}
