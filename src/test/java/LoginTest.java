import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.praktikum.diplom.*;

public class LoginTest extends BaseTest{
    private User user;
    private UserClient userClient;
    private String accessToken;
    private ValidatableResponse response;
    @Before
    public void setUp() {
        user = User.getRandomUser();
        response = userClient.createUser(user);
        accessToken = response.extract().path("accessToken");
    }
    @Test
    @DisplayName("Успешный вход через кнопку «Личный кабинет»")
    public void loginThroughPersonalAccountButton(){
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage.clickAccountButton();
        loginPage.enterEmailAndPassword(user);
        loginPage.clickSignInButton();
        mainPage.checkOrderButton();
    }

    @Test
    @DisplayName("Успешный вход по кнопке «Войти в аккаунт» на главной")
    public void loginThroughSignInButton(){
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage.clickSignInButton();
        loginPage.enterEmailAndPassword(user);
        loginPage.clickSignInButton();
        mainPage.checkOrderButton();
    }

    @Test
    @DisplayName("Успешный вход через кнопку в форме восстановления пароля")
    public void loginThroughTheButtonInThePasswordRecoveryForm(){
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);

        mainPage.clickSignInButton();
        loginPage.clickRestorePasswordButton();
        forgotPasswordPage.clickSignInButton();
        loginPage.enterEmailAndPassword(user);
        loginPage.clickSignInButton();
        mainPage.checkOrderButton();
    }

    @Test
    @DisplayName("Успешный вход через кнопку в форме регистрации")
    public void loginThroughTheButtonInTheRegistrationForm(){
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        mainPage.clickSignInButton();
        loginPage.clickRegisterButton();
        registerPage.clickSignInButton();
        loginPage.enterEmailAndPassword(user);
        loginPage.clickSignInButton();
        mainPage.checkOrderButton();
    }
    @After
    public void clearState() {
        userClient.deleteUser(StringUtils.substringAfter(accessToken, " "));
    }
}
