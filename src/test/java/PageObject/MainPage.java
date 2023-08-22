package PageObject;

import static org.junit.Assert.assertEquals;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private WebDriver driver;
    //кнопка Личный кабинет
    private final By personalAccount = By.xpath("//p[text()='Личный Кабинет']");
    //кнопка Войти в аккаунт
    private final By loginButton = By.xpath("//button[text()='Войти в аккаунт']");
    //Конструктор - Булки
    private final By buns = By.xpath("//div/span[text()='Булки']");
    //Конструктор - Соусы
    private final By sauces = By.xpath("//span[text() = 'Соусы']");
    //Конструктор - Начинки
    private final By filling = By.xpath("//span[text() = 'Начинки']");
    //Кнопка Сделать заказ
    private final By makeOrderButton = By.xpath("//button[text()='Оформить заказ']");
    //Активный раздел в конструкторе
    private final By activeSection = By.className("tab_tab_type_current__2BEPc");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step
    @DisplayName("Кликнуть по кнопке Войти в аккаунт")
    public LoginPage clickLoginButton() {
        driver.findElement(loginButton).click();
        return new LoginPage(driver);
    }

    @Step
    @DisplayName("Кликнуть по кнопке Личный кабинет")
    public LoginPage clickPersonalAccountButton() {
        driver.findElement(personalAccount).click();
        return new LoginPage(driver);
    }

    @Step
    @DisplayName("Кликнуть по разделу Булки в Конструкторе")
    public MainPage clickOnBuns() {
        driver.findElement(buns).click();
        return this;
    }

    @Step
    @DisplayName("Кликнуть по разделу Соусы в Конструкторе")
    public MainPage clickOnSauces() {
        driver.findElement(sauces).click();
        return this;
    }

    @Step
    @DisplayName("Кликнуть по разделу Начинки в Конструкторе")
    public MainPage clickOnFilling() {
        driver.findElement(filling).click();
        return this;
    }

    @Step
    @DisplayName("Сравнить актуальное и ожидаемое название активного раздела")
    public void checkActiveBuilderSection(String section) {
        String actual = driver.findElement(activeSection).getText();
        assertEquals(section,actual);
    }

    @Step
    @DisplayName("Проверить, что пользователь залогинен - видна кнопка Сделать заказ")
    public MainPage checkUserIsLogin() {
        driver.findElement(makeOrderButton).isDisplayed();
        return this;
    }
}