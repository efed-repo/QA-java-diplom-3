import PageObject.LoginPage;
import PageObject.MainPage;
import PageObject.ProfilePage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;

import static Helpers.Urls.MAIN_PAGE;
import static Helpers.User.USER_EMAIL;
import static Helpers.User.USER_PASSWORD;

public class LoggedUserTests extends BaseTest {

    private MainPage mainPage;
    private LoginPage loginPage;
    private ProfilePage profilePage;

    @Before
    @DisplayName("Логин пользователем и переход в Личный кабинет")
    public void userIsLoginSetUp() {
        driver.get(MAIN_PAGE);
        mainPage = new MainPage(driver);
        mainPage.clickLoginButton();
        loginPage = new LoginPage(driver);
        loginPage.userLogin(USER_EMAIL, USER_PASSWORD);
        profilePage = new ProfilePage(driver);

    }

    @Test
    @DisplayName("Переход на главную страницу через лого сайта")
    public void checkSiteLogoTest() {
        mainPage.clickPersonalAccountButton();
        profilePage.clickOnSiteLogo();
        mainPage.checkUserIsLogin();
    }

    @Test
    @DisplayName("Переход на главную страницу через кнопку Конструктор")
    public void checkBuilderButtonTest() {
        mainPage.clickPersonalAccountButton();
        profilePage.clickOnBuilderButton();
        mainPage.checkUserIsLogin();
    }

    @Test
    @DisplayName("Проверка активного раздела Булки")
    public void selectBunSectionTest() {
        profilePage.clickOnBuilderButton()
                .clickOnBuns()
                .checkActiveBuilderSection("Булки");
    }

    @Test
    @DisplayName("Проверка активного раздела Соусы")
    public void selectSaucesSectionTest() {
        profilePage.clickOnBuilderButton()
                .clickOnSauces()
                .checkActiveBuilderSection("Соусы");
    }

    @Test
    @DisplayName("Проверка активного раздела Начинки")
    public void selectFillingSectionTest() {
        profilePage.clickOnBuilderButton()
                .clickOnFilling()
                .checkActiveBuilderSection("Начинки");
    }

}
