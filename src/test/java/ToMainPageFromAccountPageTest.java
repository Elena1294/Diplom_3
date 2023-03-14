import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.praktikum.diplom.*;

import java.time.Duration;

public class ToMainPageFromAccountPageTest extends BaseTest{
    private User user;
    public UserClient userClient;
    private String accessToken;
    private ValidatableResponse response;

    @Before
    public void setUp() {
        user = User.getRandomUser();
        response = userClient.createUser(user);
        accessToken = response.extract().path("accessToken");
    }

    @Test
    @DisplayName("Проверь переход из личного кабинета в конструктор по клику на логотип Stellar Burgers")
    public void toMainPageFromAccountPageWithLogoButton(){
        MainPage mainPage = new MainPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage.clickAccountButton();
        loginPage.enterEmailAndPassword(user);
        loginPage.clickSignInButton();
        mainPage.clickAccountButton();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Конструктор']")));
        profilePage.clickLogoButton();
        mainPage.checkOrderButton();
    }

    @Test
    @DisplayName("Проверь переход из личного кабинета в конструктор по клику на «Конструктор»")
    public void toMainPageFromAccountPageWithConstructorButton(){
        MainPage mainPage = new MainPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage.clickAccountButton();
        loginPage.enterEmailAndPassword(user);
        loginPage.clickSignInButton();
        mainPage.clickAccountButton();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Конструктор']")));
        profilePage.clickConstructorButton();
        mainPage.checkOrderButton();
    }

}