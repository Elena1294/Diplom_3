package ru.praktikum.diplom;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.StringStartsWith.startsWith;

public class MainPage {

    private final By personalAccountButton =     //кнопка "Личный кабинет":
            By.xpath(".//p[text()='Личный Кабинет']");

    private final By signInButton = //кнопка Войти в аккаунт
            By.xpath(".//button[text()='Войти в аккаунт']");

    private final By makeOrderButton = //кнопка Оформить заказ
            By.xpath(".//button[contains(text(),'Оформить заказ')]");

    private final By bunsButton = //кнопка Булки
            By.xpath(".//div[span[text()='Булки']]");

    private final By saucesButton = //кнопка Соусы
            By.xpath(".//div[span[text()='Соусы']]");

    private final By fillingsButton = //кнопка Начинки
            By.xpath(".//*[text()='Начинки']");

    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {         //открыть сайт
        driver.get(URLS.BASE_URI);
    }

    public void clickAccountButton() { //клик на кнопку Личный кабинет
        driver.findElement(personalAccountButton).click();
    }
    public void clickSignInButton() { //клик на кнопку Войти в аккаунт
        driver.findElement(signInButton).click();
    }
    public void checkOrderButton() { //проверка наличия кнопки заказа
        String textOrderButton = driver.findElement(makeOrderButton).getText();
        MatcherAssert.assertThat(textOrderButton, startsWith("Оформить заказ"));
    }
    public void clickBunsButton() { //клик на кнопку Булки
        driver.findElement(bunsButton).click();
    }
    public void clickSaucesButton() { //клик на кнопку Соусы
        driver.findElement(saucesButton).click();
    }
    public void clickFillingsButton() { //клик на кнопку Начинки
        driver.findElement(fillingsButton).click();
    }
    public void checkGoToTheBunsSection(){
        String text = driver.findElement(By.xpath(".//div[@style]/div[1]")).getAttribute("class");
        MatcherAssert.assertThat(text, containsString("current"));
    }
    public void checkGoToTheSaucesSection(){
        String text = driver.findElement(By.xpath(".//div[@style]/div[2]")).getAttribute("class");
        MatcherAssert.assertThat(text, containsString("current"));
    }
    public void checkGoToTheFillingsSection(){
        String text = driver.findElement(By.xpath(".//div[@style]/div[3]")).getAttribute("class");
        MatcherAssert.assertThat(text, containsString("current"));
    }
}
