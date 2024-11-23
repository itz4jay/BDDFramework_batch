package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//td[contains(text(),'UserID')]//parent::tr//td[2]//input")
	WebElement username;
	
	@FindBy(xpath="//td[contains(text(),'Password')]//parent::tr//td[2]//input")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement login;
	
	public void enterUsername(String user)
	{
		username.sendKeys(user);
	}
	
	public void enterPassword(String pass)
	{
		password.sendKeys(pass);
	}
	
	public void clickLogin()
	{
		login.click();
	}
	
	public String validateErrorMessage()
	{
		String alertText = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		return alertText;
	}

}
