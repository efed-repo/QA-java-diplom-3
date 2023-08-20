import PageObject.*;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static Helpers.Urls.*;
import static Helpers.User.USER_PASSWORD;

public class LoginTests extends BaseTest {

    private String email;
    Response response;

    @Override
    public void setUp() {
        response = createTestUserByApi();
        email = getTestUserEmail(response);
        super.setUp();
    }

    @Test
    @DisplayName("Логин по кнопке Войти в аккаунт на главной странице")
    public void loginFromLoginButtonTest() {
        driver.get(MAIN_PAGE);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.userLogin(email, USER_PASSWORD);
        mainPage.checkUserIsLogin();
    }

    @Test
    @DisplayName("логина по кнопке Личный кабинет на главной странице")
    public void loginFromPersonalAccountButtonTest() {
        driver.get(MAIN_PAGE);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickPersonalAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.userLogin(email, USER_PASSWORD);
        mainPage.checkUserIsLogin();
    }

    @Test
    @DisplayName("Логина по кнопке Войти на форме регистрации")
    public void loginFromRegistrationFormTest() {
        driver.get(REGISTRATION_PAGE);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        RegistrationPage regPage = new RegistrationPage(driver);
        regPage.clickLoginLink();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.userLogin(email, USER_PASSWORD);
        MainPage mainPage = new MainPage(driver);
        mainPage.checkUserIsLogin();
    }

    @Test
    @DisplayName("Логина по кнопке Войти на странице восстановления пароля")
    public void loginFromResetPasswordPageTest() {
        driver.get(RESET_PASSWORD_PAGE);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        ResetPasswordPage resetPassword = new ResetPasswordPage(driver);
        resetPassword.clickLoginLink();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.userLogin(email, USER_PASSWORD);
        MainPage mainPage = new MainPage(driver);
        mainPage.checkUserIsLogin();
    }

    @Override
    public void teardown() {
        deleteTestUserFromApi(response);
    }
}
