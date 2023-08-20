package PageObject;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    //поле Email
    private final By emailField = By.xpath("//label[.='Email']/../input");
    // поле Пароль
    private final By passwordField = By.xpath("//label[.='Пароль']/../input");
    //кнопка Войти
    private final By loginButton = By.xpath("//button[text()='Войти']");
    // кнопка Зарегистрироваться
    private final By registrationButton = By.xpath("//a[text() ='Зарегистрироваться']");
    //ссылка Восстановить пароль
    private final By resetPasswordLink = By.xpath("//a[text()='Восстановить пароль']");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step
    @DisplayName("Залогиниться потзователем")
    public void userLogin(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
        new MainPage(driver);
    }

    @Step
    @DisplayName("Перейти на страницу регистрации")
    public RegistrationPage goToRegistrationPage() {
        driver.findElement(registrationButton).click();
        return new RegistrationPage(driver);
    }

    @Step
    @DisplayName("Перейти на страницу восстановления пароля")
    public ResetPasswordPage clickResetPasswordLink() {
        driver.findElement(resetPasswordLink).click();
        return new ResetPasswordPage(driver);
    }

    @Step
    @DisplayName("Проверить видимость кнопки Войти на странице логина")
    public LoginPage checkVisibilityOfLoginButton() {
        driver.findElement(loginButton).isDisplayed();
        return this;
    }

}
