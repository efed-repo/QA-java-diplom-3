package PageObject;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private WebDriver driver;

    // поле Имя
    private final By nameField = By.xpath("//label[.='Имя']/../input");
    // поле email
    private final By emailField = By.xpath("//label[.='Email']/../input");
    // поле Пароль
    private final By passwordField = By.name("Пароль");
    // кнопка Зарегистрироваться
    private final By regButton = By.xpath("//button[text() ='Зарегистрироваться']");
    // кнопка Войти
    private final By loginLink = By.xpath("//a[text() ='Войти']");
    // Ошибка Некорректный пароль
    private final By passwordError = By.xpath("//p[text()='Некорректный пароль']");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step
    @DisplayName("Зарегистрировать пользователя")
    public LoginPage userRegistration(String name, String email, String password) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(regButton).click();
        return new LoginPage(driver);
    }

    @Step
    @DisplayName("Проверить, отображение ошибки о некорректном пароле")
    public RegistrationPage checkPasswordError() {
        driver.findElement(passwordError).isDisplayed();
        return this;
    }

    @Step
    @DisplayName("Перейти в регистрации через страницу логина")
    public LoginPage clickLoginLink() {
        driver.findElement(loginLink).click();
        return new LoginPage(driver);
    }
}
