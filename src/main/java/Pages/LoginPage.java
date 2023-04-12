package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage
{
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public String LoginPageURL = "http://magento-demo.lexiconn.com/";

    @FindBy(xpath = "//*[@id=\"header\"]/div/div[2]/a[3]/span[2]")
    WebElement AccountBTN;

    @FindBy(xpath = "//*[@id=\"header-account\"]/div/ul/li[5]/a")
    WebElement RegisterBTN;

    public void Register_Navigation() throws InterruptedException {
        AccountBTN.click();
      //  Thread.sleep(2000);
        RegisterBTN.click();
    }



}
