import PageObject.LoginPage;
import org.junit.Test;

public class LoginTests extends BaseTest {

    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.userLogin("tesr@yandex.ru", "password");
    }

}
