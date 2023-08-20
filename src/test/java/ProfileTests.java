import PageObject.LoginPage;
import PageObject.MainPage;
import PageObject.ProfilePage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static Helpers.Urls.LOGIN_PAGE;

public class ProfileTests extends BaseTest {

    private LoginPage loginPage;
    private MainPage mainPage;
    private ProfilePage profilePage;

    @Before
    @DisplayName("Залогиниться пользователем")
    public void userLoginSetUp() {
        driver.get(LOGIN_PAGE);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        loginPage.userLogin("123433556@yandex.ru", "111111");
        mainPage = new MainPage(driver);
        profilePage = new ProfilePage(driver);
    }

    @Test
    @DisplayName("Переход в Личный кабинет авторизованным пользователем")
    public void goToAccountInfoTest() {
        mainPage.checkUserIsLogin()
                .clickPersonalAccountButton();
        profilePage.checkLogOutButtonIsDisplayed();
    }

    @Test
    @DisplayName("Логаут пользователя")
    public void logOutTest() {
        mainPage.checkUserIsLogin()
                .clickPersonalAccountButton();
        profilePage.checkLogOutButtonIsDisplayed()
                .logOut();
        loginPage.checkVisibilityOfLoginButton();
    }
}
