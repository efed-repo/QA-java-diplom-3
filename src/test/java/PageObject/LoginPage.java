package PageObject;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;

    //поле Email
    private final By emailField = By.xpath("//label[.='Email']/../input");
    // поле Пароль
    private final By passwordField = By.xpath("//label[.='Пароль']/../input");
    //кнопка Войти
    private final By loginButton = By.xpath("//button[text()='Войти']");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step
    @DisplayName("Залогиниться пользователем")
    public void userLogin(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
        new MainPage(driver);
    }

    @Step
    @DisplayName("Проверить видимость кнопки Войти на странице логина")
    public LoginPage checkVisibilityOfLoginButton() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(loginButton));
        driver.findElement(loginButton).isDisplayed();
        return this;
    }

}
