package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;
    //кнопка Личный кабинет
    private final By personalAccount = By.xpath("//p[text()='Личный Кабинет']");
    //кнопка Войти в аккаунт
    private final By loginButton = By.xpath("//button[text()='Войти в аккаунт']");

    //Булки
    private final By buns = By.xpath("//span[text() = 'Булки']");
    //Соусы
    private final By sauces = By.xpath("//span[text() = 'Соусы']");
    //Начинки
    private final By filling = By.xpath("//span[text() = 'Начинки']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage clickLoginButton() {
        driver.findElement(loginButton).click();
        return new LoginPage(driver);
    }

    public LoginPage clickPersonalAccountButton() {
        driver.findElement(personalAccount).click();
        return new LoginPage(driver);
    }

    public ProfilePage clickPersonalAccountButtonForRegistratedUser() {
        driver.findElement(personalAccount).click();
        return new ProfilePage(driver);
    }

    public MainPage clickOnBuns (){
        driver.findElement(buns).click();
        return this;
    }

    public MainPage clickOnSauces (){
        driver.findElement(sauces).click();
        return this;
    }

    public MainPage clickOnFilling (){
        driver.findElement(filling).click();
        return this;
    }
}
