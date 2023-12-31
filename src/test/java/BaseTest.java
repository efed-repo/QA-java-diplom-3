import static Helpers.Urls.AUTH_USER_API;
import static Helpers.Urls.CREATE_USER_API;
import static Helpers.Urls.LOGIN_USER_API;
import static Helpers.Urls.MAIN_PAGE;
import static io.restassured.RestAssured.given;

import Helpers.CreateUserByApiRequestModel;
import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    WebDriver driver;
    private static final Faker faker = new Faker();

    @Before
    @DisplayName("Подготовить браузер")
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    @DisplayName("Закрыть браузер")
    public void teardown() {
        driver.quit();
    }

    @Step
    @DisplayName("Создать тестового пользователя")
    public Response createTestUserByApi() {
        RestAssured.baseURI = MAIN_PAGE;
        String email = faker.letterify("????????????@yandex.ru");
        CreateUserByApiRequestModel userApiModel = new CreateUserByApiRequestModel(email, "12345678", "name");
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(userApiModel)
                .when()
                .post(CREATE_USER_API);
    }

    @Step
    @DisplayName("Получить email пользователя, созданного через API")
    public String getTestUserEmail(Response response) {
        return response.then().extract().path("user.email");
    }

    @Step
    @DisplayName("Получить accessToken пользователя, созданного через API")
    public String getTestUserAccessToken(Response response) {
        return response.then().extract().path("accessToken");
    }

    @Step
    @DisplayName("Удалить пользователя, созданного через API")
    public void deleteTestUserFromApi(Response response) {
        String accessToken = getTestUserAccessToken(response);
        given()
                .header("Authorization", accessToken)
                .when()
                .delete(AUTH_USER_API);
    }

    @Step
    @DisplayName("")
    public void deleteUserCreatedByUi(String email, String password) {
        RestAssured.baseURI = MAIN_PAGE;
        String requestBody = "{\"email\": \"" + email + "\",\"password\": \"" + password + "\"}";
        System.out.println(requestBody);
        Response response = given()
                .header("Content-type", "application/json")
                .body(requestBody)
                .when()
                .post(LOGIN_USER_API);
        deleteTestUserFromApi(response);
    }
}


