
import com.github.javafaker.Faker;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.praktikum.diplom.*;



public class PasswordErrorTest extends BaseTest{
    private User user;
    private UserClient userClient;
    private ValidatableResponse response;
    String accessToken;
    @Before
    public void setUp() {
        user = User.getRandomUser();
        UserClient userClient = new UserClient();
    }

    @Test
    @DisplayName("Отображение ошибки для некорректного пароля. Минимальный пароль — шесть символов.")
    public void shortPasswordError(){
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        mainPage.clickAccountButton();
        loginPage.clickRegisterButton();
        registerPage.inputName("Name");
        registerPage.inputEmail(user.getEmail());
        registerPage.inputPassword("123");
        registerPage.clickFinallyRegisterButton();
        boolean isDisplayed = registerPage.checkShortPasswordError();

        if(isDisplayed){
        }
        else{
            response =  userClient.loginUser(user);
            accessToken = response.extract().path("accessToken");
            userClient.deleteUser(StringUtils.substringAfter(accessToken, " "));
        }
    }

}