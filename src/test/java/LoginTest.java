import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.praktikum.diplom.ForgotPasswordPage;
import ru.praktikum.diplom.LoginPage;
import ru.praktikum.diplom.MainPage;
import ru.praktikum.diplom.RegisterPage;

public class LoginTest extends BaseTest{

    @Test
    @DisplayName("Успешный вход через кнопку «Личный кабинет»")
    public void loginThroughPersonalAccountButton(){
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage.clickAccountButton();
        loginPage.enterEmailAndPassword();
        loginPage.clickSignInButton();
        mainPage.checkOrderButton();
    }

    @Test
    @DisplayName("Успешный вход по кнопке «Войти в аккаунт» на главной")
    public void loginThroughSignInButton(){
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage.clickSignInButton();
        loginPage.enterEmailAndPassword();
        loginPage.clickSignInButton();
        mainPage.checkOrderButton();
    }

    @Test
    @DisplayName("Успешный вход через кнопку в форме восстановления пароля")
    public void LoginThroughTheButtonInThePasswordRecoveryForm(){
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);

        mainPage.clickSignInButton();
        loginPage.clickRestorePasswordButton();
        forgotPasswordPage.clickSignInButton();
        loginPage.enterEmailAndPassword();
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
        loginPage.enterEmailAndPassword();
        loginPage.clickSignInButton();
        mainPage.checkOrderButton();
    }
}
