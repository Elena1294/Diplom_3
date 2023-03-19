
import com.github.javafaker.Faker;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.praktikum.diplom.*;

import static org.apache.http.HttpStatus.SC_OK;


public class PasswordErrorTest extends BaseTest {
    User user = new User ("helena@mail.ru","123");
    UserClient userClient = new UserClient();
    private ValidatableResponse response;
    String accessToken;

    @Test
    @DisplayName("Отображение ошибки для некорректного пароля. Минимальный пароль — шесть символов.")
    public void shortPasswordError() {

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        mainPage.clickAccountButton();
        loginPage.clickRegisterButton();
        registerPage.inputName("Name");
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
            isDisplayed = true;
        }
        if (isDisplayed) {
            accessToken = response.extract().path("accessToken");
            userClient.deleteUser(StringUtils.substringAfter(accessToken, " "));
        }
        driver.quit();

    }
}