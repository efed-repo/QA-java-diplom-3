package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResetPasswordPage {

    private WebDriver driver;

    //ссылка Войти
    private final By loginLink = By.xpath("//a[text()='Войти']");


    public ResetPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    private LoginPage clickLoginLink() {
        driver.findElement(loginLink).click();
        return new LoginPage(driver);
    }
}
