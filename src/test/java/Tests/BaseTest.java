package Tests;

import Pages.LoginPage;
import Pages.RegisterPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class BaseTest
{
    public static WebDriver driver;
    LoginPage LBo;
    RegisterPage RBO;
    ChromeOptions options;

    @BeforeTest
    public void Open_Browser()
    {
        LBo = new LoginPage(driver);
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
        driver.get(LBo.LoginPageURL);
        driver.manage().window().maximize();

    }


    @AfterTest
    public void Close_Browser()
    {
        driver.quit();
    }
}
