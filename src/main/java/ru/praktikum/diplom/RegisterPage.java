package ru.praktikum.diplom;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.core.StringStartsWith.startsWith;

public class RegisterPage {

    private final By nameField = //поле ввода логина в окне регистрации
            By.xpath(".//label[text()='Имя']/following-sibling::input");
    private final By emailField = //поле ввода Email в окне регистрации
            By.xpath(".//label[text()='Email']/following-sibling::input");
    private final By passwordField = //поле ввода пароля в окне регистрации
            By.xpath(".//*[text()='Пароль']/following-sibling::input");
    private final By registerButton = //большая кнопка Зарегистрироваться под окном пароля
            By.xpath(".//button[text()='Зарегистрироваться']");
    private final By shortPasswordError = //сообщение о некорректном пароле при вводе менее 6 символов
            By.xpath(".//p[text()='Некорректный пароль']");
    private final By signInButton = //кнопка Войти в меню регистрации внизу страницы
            By.xpath(".//a[text()='Войти']");

    private final WebDriver driver;

    public RegisterPage(WebDriver driver){

        this.driver = driver;
    }

    public void inputName(String text){ //ввод имени в поле имени
        driver.findElement(nameField).sendKeys(text);
    }
    public void inputEmail(String text){//ввод email в поле email
        driver.findElement(emailField).sendKeys(text);
    }
    public void inputPassword(String text){//ввод пароля в поле пароля
        driver.findElement(passwordField).sendKeys(text);
    }
    public void clickFinallyRegisterButton(){//клик на кнопку Регистрация
        driver.findElement(registerButton).click();
    }
    public void checkShortPasswordError(){ //проверка наличия сообщения об ошибке
        String textOfError = driver.findElement(shortPasswordError).getText();
        MatcherAssert.assertThat("Некорректный пароль", textOfError, startsWith("Некорректный пароль"));
    }
    public void clickSignInButton(){
        driver.findElement(signInButton).click();
    }
}
