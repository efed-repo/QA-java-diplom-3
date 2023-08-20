import PageObject.LoginPage;
import PageObject.RegistrationPage;
import com.github.javafaker.Faker;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;

import static Helpers.Urls.*;
import static Helpers.User.USER_NAME;
import static Helpers.User.USER_PASSWORD;

public class RegistrationTests extends BaseTest {

    private RegistrationPage regPage;
    private LoginPage loginPage;
    private static final Faker faker = new Faker();
    private final String RandomUserEmail = faker.letterify("????????????@yandex.ru");;

    @Before
    public void registrationTestsSetUp() {
        driver.get(REGISTRATION_PAGE);
        regPage = new RegistrationPage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test
    @DisplayName("Регистрация пользователя, позитивный сценарий")
    public void registrationOfNewUserTest() {
        regPage.userRegistration(USER_NAME, RandomUserEmail, USER_PASSWORD);
        loginPage.checkVisibilityOfLoginButton();
    }

    @Test
    @DisplayName("Регистрация пользователя, негативный сценарий - короткий пароль")
    public void registrationOfNewUserErrorTest() {
        regPage.userRegistration(USER_NAME, RandomUserEmail, "123");
        regPage.checkPasswordError();
    }
}
