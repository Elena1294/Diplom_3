package ru.praktikum.diplom;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.core.StringStartsWith.startsWith;
public class LoginPage extends MyValues{
    private final By registerButton = //маленькая кнопка Зарегистрироваться внизу страницы
            By.xpath(".//a[(@class = 'Auth_link__1fOlj' and text()= 'Зарегистрироваться')]");
    private final By restorePasswordButton = //кнопка Восстановить пароль
            By.xpath(".//a[text()='Восстановить пароль']");
    private final By signInButton = //кнопка Войти
            By.xpath(".//button[text()='Войти']");
    private final By emailField = //поле ввода почты в окне входа
            By.xpath(".//label[text()='Email']/following-sibling::input");
    private final By passwordField = //поле ввода пароля в окне входа
            By.xpath(".//*[text()='Пароль']/following-sibling::input");

    private final WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickRegisterButton() { //клик на кнопку Зарегистрироваться
        driver.findElement(registerButton).click();
    }
    public void checkRegistrationIsSuccessfully(){ //проверка на наличие кнопки восстановления пароля
        String textOfRestorePasswordButton = driver.findElement(restorePasswordButton).getText();
        MatcherAssert.assertThat(textOfRestorePasswordButton, startsWith("Восстановить пароль"));
    }
    public void enterEmailAndPassword(){ //ввести почту и пароль в окне авторизации
        driver.findElement(emailField).sendKeys(EMAIL);
        driver.findElement(passwordField).sendKeys(PASSWORD);
    }
    public void clickSignInButton(){ // клик на кнопку Войти
        driver.findElement(signInButton).click();
    }
    public void clickRestorePasswordButton(){ //клик на кнопку Восстановить пароль
        driver.findElement(restorePasswordButton).click();
    }
}
