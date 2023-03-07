package ru.praktikum.diplom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {

    private final By signInButton =
            By.xpath(".//a[text()='Войти']");

    private final WebDriver driver;

    public ForgotPasswordPage(WebDriver driver){

        this.driver = driver;
    }
    public void clickSignInButton(){
        driver.findElement(signInButton).click();
    }
}