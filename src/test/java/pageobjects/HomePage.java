package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass{

	WebDriver driver;
	@FindBy(xpath="//img[@id='logo']")
	WebElement logo;
	
	@FindBy(xpath="//button[@id='headerfblogin']")
	WebElement studentaccess;
	
	@FindBy(xpath="//a[@id='wblhead']")
	WebElement WBL;
	
	@FindBy(id="loginButton")
	WebElement loginbutton;
	
	public HomePage(WebDriver driver) {  //constructor
		this.driver=driver;
		PageFactory.initElements(driver, this); 
      }
	
	public String checkhomepagetitle() {
		return driver.getTitle();
	}
	public boolean checklogo() {
		return logo.isDisplayed();
	}
	public boolean checkstudentaccess() {
		return studentaccess.isDisplayed();
	}
	public LoginPage clicklb() {
		loginbutton.click();
		return new LoginPage(driver);
	}
	
	

	
}