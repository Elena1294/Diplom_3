import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.praktikum.diplom.MainPage;

public class NavigationInMenuTest extends BaseTest {

    @Test
    @DisplayName("Работоспособность переходов к разделам: «Булки», «Соусы», «Начинки».")
    public void navigationThroughMenu() {
        MainPage mainPage = new MainPage(driver);

        mainPage.clickFillingsButton();
        mainPage.checkGoToTheFillingsSection();
        mainPage.clickSaucesButton();
        mainPage.checkGoToTheSaucesSection();
        mainPage.clickBunsButton();
        mainPage.checkGoToTheBunsSection();
    }
}