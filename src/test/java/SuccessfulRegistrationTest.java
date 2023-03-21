import com.github.javafaker.Faker;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;
import ru.praktikum.diplom.*;

public class SuccessfulRegistrationTest extends BaseTest {

    UserClient client = new UserClient();
    Faker faker = new Faker();
    String name = faker.name().firstName();
    String email = faker.internet().emailAddress();
    String password = faker.internet().password(6, 9);

    @Test
    @DisplayName("Успешная регистрация")
    public void successfulRegistration() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        mainPage.clickAccountButton();
        loginPage.clickRegisterButton();
        registerPage.inputName(name);
        registerPage.inputEmail(email);
        registerPage.inputPassword(password);
        registerPage.clickFinallyRegisterButton();
        loginPage.checkRegistrationIsSuccessfully();

        ValidatableResponse response = client.loginUser(new User(email, password));
        String accessToken = client.getToken(response);
        ValidatableResponse deleteResponse = client.deleteUser(accessToken);
        client.userDeleted(deleteResponse);
    }
}