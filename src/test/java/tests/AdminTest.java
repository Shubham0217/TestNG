package tests;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
//import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import base.BaseTest;
import pages.AdminPage;
import pages.LoginPage;


public class AdminTest extends BaseTest{

	@BeforeTest()
	public void setupTest() {
		setUp();
	}

	
	@Test(priority = 1)
	public void login() {
		
		LoginPage login = new LoginPage(driver);
		
		Assert.assertEquals(driver.getTitle(), "OrangeHRM", "Title does not match");
		
		login.enterUsername("Admin");
		login.enterPassword("admin123");
		login.clickLogin();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement dashboard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Dashboard']")));
		
		Assert.assertTrue(dashboard.isDisplayed(), "Dashboard is not displayed after login.");
		
	}
	
	@Test(priority = 2)
	public void AdminSettings() throws InterruptedException {
		AdminPage admin = new AdminPage(driver);
		
		WebElement admintext = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(.,'Admin')]")));
		Assert.assertTrue(admintext.isDisplayed(), "Text not displayed");
		
		admin.adminClick();
		
		WebElement admintitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-level']")));
		Assert.assertTrue(admintitle.isDisplayed(), "Text not displayed");
		
		admin.addButton();
		
		WebElement addtitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title']")));
		Assert.assertTrue(addtitle.isDisplayed(), "Text not displayed");
		
		admin.userRole();
		
		admin.employeeName();
		
		admin.userStatus();
		
		admin.userName();
		
		admin.userPassword();
		
		admin.userPasswordConfirm();
		
		admin.saveButton();
		
		//WebElement SaveText = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("")));
			
		//Alert alert = driver.switchTo().alert();
		//String savemessage = alert.getText();
		//System.out.println(savemessage);
		
	//	Assert.assertEquals(savemessage, "Expected Alert Text", "Alert text did not match");
	
	
	}
	
	
	@AfterTest()
	public void TearDown() {
		tearDown();
	}
	
}
