package stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pagefactory.HomePage;
import pagefactory.LoginPage;

public class LoginStep {
	
	WebDriver driver;
	LoginPage login;
	
	@Before
	public void bowserSetup()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		//context.setDriver(driver);
	}
	
	@Given("User is on login page")
	public void user_is_on_login_page() {
	    driver.get("https://www.demo.guru99.com/V4/");
	}

	@When("User enters {string} and {string}")
	public void user_enters_valid_and(String username, String password) {
		login = new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);
	}

	@When("click on login button")
	public void click_on_login_button() {
		login.clickLogin();
	    
	}

	@Then("User is navigated to Home Page")
	public void user_is_navigated_to_home_page() {
	    HomePage home = new HomePage(driver);
	    String title = home.title();
	    Assert.assertEquals(title, "Guru99 Bank Manager HomePage");
	}

	
	@Then("User received error message")
	public void user_received_error_message() {
		String alertText = login.validateErrorMessage();
		Assert.assertEquals(alertText, "User or Password is not valid");
	}
	
	@After
	public void clearDown() {
		driver.close();    
	}

}
