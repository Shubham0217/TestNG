package tests;
import base.BaseTest;
import pages.LoginPage;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

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
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dashboardHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Dashboard']")));

        Assert.assertTrue(dashboardHeader.isDisplayed(), "Dashboard is not displayed after login.");
        System.out.println("Header Matched");
        
    }

    @AfterMethod
    public void teardownTest() {
        tearDown();
    }
}
