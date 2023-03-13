import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.praktikum.diplom.MainPage;

public class NavigationInMenuTest extends BaseTest {

    @Test
    @DisplayName("Работоспособность переходов к разделу:  «Соусы»")
    public void navigationThroughMenu1() {
        MainPage mainPage = new MainPage(driver);

        mainPage.clickFillingsButton();
        mainPage.checkGoToTheFillingsSection();

    }
    @Test
    @DisplayName("Работоспособность переходов к разделу: «Соусы»")
    public void navigationThroughMenu2() {
        MainPage mainPage = new MainPage(driver);

        mainPage.clickSaucesButton();
        mainPage.checkGoToTheSaucesSection();

    }
    @Test
    @DisplayName("Работоспособность переходов к разделу: «Начинки».")
    public void navigationThroughMenu3() {
        MainPage mainPage = new MainPage(driver);

        mainPage.clickBunsButton();
        mainPage.checkGoToTheBunsSection();
    }
}