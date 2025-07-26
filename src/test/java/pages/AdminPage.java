package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;


public class AdminPage {

	WebDriver driver;

	WebDriverWait wait;

	public AdminPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}


	private By admin = By.xpath("//span[contains(.,'Admin')]");

	private By add_button = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']");

	private By user_role = By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[1]");

	private By employee_name = By.xpath("//input[@placeholder='Type for hints...']");
	
	private By user_status = By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[2]");
	
	private By user_name = By.xpath("//label[text()='Username']/parent::div/following-sibling::div//input");
	
	private By user_password = By.xpath("//label[text()='Password']/parent::div/following-sibling::div//input");
	
	private By user_pssword_confirm = By.xpath("//label[text()='Confirm Password']/parent::div/following-sibling::div//input");
	
	private By save_button = By.xpath("//button[@type='submit']");



	public void adminClick() throws NoSuchElementException {

		WebElement admin_btn=wait.until(ExpectedConditions.elementToBeClickable(admin));

		if(admin_btn.isDisplayed()) {
			admin_btn.click();
		}
		else {
			throw new NoSuchElementException("Admin Button not found");
		}
	}

	public void addButton() throws NoSuchElementException {
		WebElement add_btn = wait.until(ExpectedConditions.presenceOfElementLocated(add_button));


		if (add_btn.isDisplayed()) {
			add_btn.click();
		} else {
			throw new NoSuchElementException("Add button Element not found");
		}
	}

	public void userRole() {

		WebElement userrole = wait.until(ExpectedConditions.presenceOfElementLocated(user_role));

		if(userrole.isDisplayed()) {
			userrole.click();

			WebElement option = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='oxd-select-text-input'])[1]"))); //for another option just select 2 in the index value 
			option.click();
		}
		else {
			System.out.println("Element not found");
		}


	}

	public void employeeName() throws InterruptedException, NoSuchElementException {

		WebElement autocomplete = wait.until(ExpectedConditions.presenceOfElementLocated(employee_name));
		if (autocomplete.isDisplayed()){

			autocomplete.sendKeys("Test");

			Thread.sleep(2000);
			List<WebElement> suggestions = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@role='option']")));

			//ok so here we have to stop the execution for some time as using thrad.sleep as the options will not load until then so to stop the execution of script we have to use thrad.sleep 	

			for (WebElement suggestion : suggestions) {
				String text = suggestion.getText().trim();
				if (text.equalsIgnoreCase("Orange Test")) {  // here we are searching for that specific option
					suggestion.click();
					System.out.println("Option Element found");
					return;
				}
				else {
					System.out.println("Option Element not found");
				}

			}

		}
		else {
	        throw new NoSuchElementException("Employee name element was not found or not displayed.");
	    }
	}
	
	
	public void userStatus() throws NoSuchElementException {
	    WebElement userstatus = wait.until(ExpectedConditions.presenceOfElementLocated(user_status));

	    if (userstatus.isDisplayed()) {
	        userstatus.click();

	        WebElement option = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='oxd-select-text-input'])[1]")));
	        option.click();
	    } else {
	        throw new NoSuchElementException("User status element was not found or not displayed.");
	    }
	}

	
	public void userName() throws NoSuchElementException{
		
		WebElement username = wait.until(ExpectedConditions.presenceOfElementLocated(user_name));
		
		if(username.isDisplayed()) {
			username.sendKeys("Shubham");
		}
		else{
			throw new NoSuchElementException("Username elementn not found"); 
		}
		
	}
	
	public void userPassword() throws NoSuchElementException{
		
		WebElement userpassword = wait.until(ExpectedConditions.presenceOfElementLocated(user_password));
		
		if(userpassword.isDisplayed()) {
			userpassword.sendKeys("123456789*Aa");
		}
		else {
			throw new NoSuchElementException("Password element was not found or not displayed.");
		}
	}
	
	public void userPasswordConfirm() throws NoSuchElementException{
			
			WebElement userpasswordconfirm = wait.until(ExpectedConditions.presenceOfElementLocated(user_pssword_confirm));
			
			if(userpasswordconfirm.isDisplayed()) {
				userpasswordconfirm.sendKeys("123456789*Aa");
			}
			else {
				throw new NoSuchElementException("Password element was not found or not displayed.");
			}
		}
	
	public void saveButton() throws NoSuchElementException {
		
		WebElement savebtn = wait.until(ExpectedConditions.presenceOfElementLocated(save_button));
		
		if(savebtn.isEnabled()) {
			savebtn.click();
		}
		else {
			throw new NoSuchElementException("Save button Element not found");
		}
			
		
	}
	
	
	

}
