
import com.github.javafaker.Faker;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.praktikum.diplom.*;


public class PasswordErrorTest extends BaseTest{

    Faker faker = new Faker();

    @Test
    @DisplayName("Отображение ошибки для некорректного пароля. Минимальный пароль — шесть символов.")
    public void shortPasswordError(){
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        mainPage.clickAccountButton();
        loginPage.clickRegisterButton();
        registerPage.inputName(faker.name().firstName());
        registerPage.inputEmail(faker.internet().emailAddress());
        registerPage.inputPassword(faker.internet().password(3, 5));
        registerPage.clickFinallyRegisterButton();
        registerPage.checkShortPasswordError();
    }

}