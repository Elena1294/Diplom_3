import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.praktikum.diplom.MainPage;



import java.time.Duration;

import static ru.praktikum.diplom.MyValues.BASE_URI;

public class BaseTest {

    //public WebDriver driver = new ChromeDriver();
    public WebDriver driver;
    @Before
    public void setUpChrome (){

        //WebDriverManager.chromedriver().setup();
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(ops);

        driver.get(BASE_URI);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        MainPage mainPage = new MainPage(driver);
        mainPage.open();



    }

    @After
    public void tearDown(){
        driver.quit();
    }
}