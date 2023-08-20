package PageObject;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResetPasswordPage {

    private WebDriver driver;

    //ссылка Войти
    private final By loginLink = By.xpath("//a[text()='Войти']");


    public ResetPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step
    @DisplayName("Перейти к страницк Логина через страницу Восстановления пароля")
    public LoginPage clickLoginLink() {
        driver.findElement(loginLink).click();
        return new LoginPage(driver);
    }
}
