package Tests;

import Pages.LoginPage;
import Pages.RegisterPage;
import org.testng.annotations.Test;

public class Register extends BaseTest
{
     @Test(priority = 1)
    public void Register_Navigation() throws InterruptedException {
         LBo = new LoginPage(driver);
         LBo.Register_Navigation();
     }

     @Test(priority = 2)
    public void Valid_Registeration() throws InterruptedException {
         RBO = new RegisterPage(driver);
         RBO.Valid_Register();
     }
}
