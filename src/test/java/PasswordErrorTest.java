import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.praktikum.diplom.*;

import static org.apache.http.HttpStatus.SC_OK;


public class PasswordErrorTest extends BaseTest {
    private User user;
    private UserClient userClient;
    private String accessToken;
    private ValidatableResponse response;
    @Before
    public void setUp() {
        user = User.getRandomUserShortPassword();
        response = userClient.createUser(user);
        accessToken = response.extract().path("accessToken");
    }

    @Test
    @DisplayName("Отображение ошибки для некорректного пароля. Минимальный пароль — шесть символов.")
    public void shortPasswordError() {

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        mainPage.clickAccountButton();
        loginPage.clickRegisterButton();
        registerPage.inputName(user.getName());
        registerPage.inputEmail(user.getEmail());
        registerPage.inputPassword(user.getPassword());
        registerPage.clickFinallyRegisterButton();
        registerPage.checkShortPasswordError();
    }

    @After
    public void tearDown() {
        boolean isDisplayed = false;
        response =  userClient.loginUser(user);
        int statusCode = response.extract().statusCode();
        if (statusCode == SC_OK) {
            isDisplayed = true;git stat
        }
        if (isDisplayed) {
            accessToken = response.extract().path("accessToken");
            userClient.deleteUser(accessToken);
        }
        driver.quit();
    }
}