package tests;
import base.BaseTest;
import pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @BeforeMethod
    public void setupTest() {
        setUp();
    }

    @Test
    public void loginWithValidCredentials() {
        LoginPage login = new LoginPage(driver);
        Assert.assertEquals(driver.getTitle(), "OrangeHRM", "Title does not match");

        login.enterUsername("Admin");
        login.enterPassword("admin123");
        login.clickLogin();
        
    }

    @AfterMethod
    public void teardownTest() {
    	System.out.println("Browser Bye bye!!! ");
        tearDown();
    }
}
