package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AdminPage {

	WebDriver driver;
	
	WebDriverWait wait;
	
	public AdminPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

	
	private By admin = By.xpath("//span[contains(.,'Admin')]");

	
	
	
	
	public void AdminClick() {
		wait.until(ExpectedConditions.elementToBeClickable(admin)).click();
	}
	
	
	
}
