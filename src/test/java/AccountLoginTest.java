import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.praktikum.diplom.*;

import java.time.Duration;

public class AccountLoginTest extends BaseTest {

    private User user;
    private UserClient userClient;
    private String accessToken;
    private ValidatableResponse response;
    @Before
    public void setUp() {
        user = User.getRandomUser();
        userClient = new UserClient();
        response = userClient.createUser(user);
        accessToken = response.extract().path("accessToken");
    }
    @Test
    @DisplayName("Успешный вход через кнопку «Личный кабинет»")
    public void accountLogin() throws InterruptedException {

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        mainPage.clickAccountButton();
        loginPage.enterEmailAndPassword(user);
        loginPage.clickSignInButton();
        mainPage.clickAccountButton();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(".//p[text()='Конструктор']")));
        profilePage.checkLogoutButton();
    }

    @After
    public void clearState() {
        userClient.deleteUser(accessToken);
    }
}