package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass{
	WebDriver driver;
	@FindBy(id="username")
	WebElement  uname ;
	@FindBy(id="password")
	WebElement  pword ;
	@FindBy(id="login")
	WebElement  login ;
	@FindBy(id="register")
	WebElement  register ;
	public LoginPage(WebDriver driver) {  //constructor
		this.driver=driver;
		PageFactory.initElements(driver, this); 
      }
	
	public String checkSignInPage1title() {
		return driver.getTitle();
	}
	
	public void setusername(String un) {
		
		uname.sendKeys(un);
	}
	public void setpassword(String pd){
		pword.sendKeys(pd);
	}
	public void clickSubmit() {
		login.click();
	}
	
	public LandingPage checksignin() {
		uname.sendKeys(super.username);
		pword.sendKeys(super.password);
		login.click();
		return new LandingPage(); 
	}
	

}
