package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	@FindBy(xpath="//a[contains(.,'New Account')]")
	WebElement newAccount;
	
	@FindBy(name="cusid")
	WebElement custID;
	
	@FindBy(name="inideposit")
	WebElement iniDeposit;
	
	@FindBy(name="button2")
	WebElement submit;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String title()
	{
		String titl = driver.getTitle();
		return titl;
	}
	
	public void createAccount(String cusID, String iniDep)
	{
		newAccount.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		custID.sendKeys(cusID);
		iniDeposit.sendKeys(iniDep);
		submit.click();
	}

}
