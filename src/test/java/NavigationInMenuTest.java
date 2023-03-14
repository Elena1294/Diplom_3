import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.praktikum.diplom.MainPage;

public class NavigationInMenuTest extends BaseTest {

    @Test
    @DisplayName("Работоспособность перехода к разделу:  «Булки»")
    public void navigationThroughMenuBuns() {
        MainPage mainPage = new MainPage(driver);

        mainPage.clickSaucesButton();
        mainPage.clickBunsButton();
        mainPage.checkGoToTheBunsSection();

    }
    @Test
    @DisplayName("Работоспособность перехода к разделу: «Соусы»")
    public void navigationThroughMenuSauces() {
        MainPage mainPage = new MainPage(driver);

        mainPage.clickSaucesButton();
        mainPage.checkGoToTheSaucesSection();

    }
    @Test
    @DisplayName("Работоспособность перехода к разделу: «Начинки».")
    public void navigationThroughMenuFillings () {
        MainPage mainPage = new MainPage(driver);

        mainPage.clickFillingsButton();
        mainPage.checkGoToTheFillingsSection();
    }
}