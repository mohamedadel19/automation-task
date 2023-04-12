package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.time.Duration;
import java.util.UUID;

public class RegisterPage extends BasePage
{
    public RegisterPage(WebDriver driver) {
        super(driver);
    }
//////////////////////////Locators
    @FindBy(id = "firstname")
    WebElement FirstName;

    @FindBy(id="lastname")
    WebElement LastName;

    @FindBy(id = "email_address")
    WebElement EmailAdress;

    @FindBy(id = "password")
    WebElement Password;

    @FindBy(id = "confirmation")
    WebElement ConfirmPassword;

    @FindBy(xpath = "//*[@id=\"form-validate\"]/div[2]/button/span/span")
    WebElement RegisterBTN;

    @FindBy(xpath = "//*[@id=\"top\"]/body/div/div[2]/div[2]/div/div[2]/div/div/div[2]/p[1]/strong")
    WebElement WelcomeText;
//////////////////////////////////////////////////DATA
    public String firstName = "Mohammed";
    public String lastName = "Adel";
    public String pass = "Adel123456";
    public String passConfirm = "Adel123456";
    public String email = "Adel@gmail.com";

    public String HomePageURL= "http://magento-demo.lexiconn.com/customer/account/index/";
/////////////////////////////////////////////////////
    public String Unige_Email() {
        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();
        String RemoveChar = uuidAsString.replaceAll("[-+.^:,]", "");
        StringBuilder sb = new StringBuilder(RemoveChar);
        sb.delete(0, 25);
        String NewUniqueMail = sb + email;
        return NewUniqueMail;
    }


    public void Valid_Register() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        FirstName.sendKeys(firstName);
        LastName.sendKeys(lastName);
        EmailAdress.sendKeys(Unige_Email());
        Password.sendKeys(pass);
        ConfirmPassword.sendKeys(passConfirm);
       // Thread.sleep(2000);
        RegisterBTN.click();
        ///////////////Asserion/////////////////////////////////
        System.out.println(WelcomeText.getText());
        Assert.assertEquals(driver.getCurrentUrl(),HomePageURL);
        Assert.assertTrue(WelcomeText.getText().contains(firstName+" "+lastName));
    }
}
