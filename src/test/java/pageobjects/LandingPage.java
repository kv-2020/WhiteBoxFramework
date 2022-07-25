package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends BaseClass{
	
	@FindBy(xpath="//a[@id='logout']")
	WebElement logout;
	@FindBy(xpath="//h1[@class='heading-title pull-left']")
	WebElement text;
	
	@FindBy(xpath="//table[@id='table']")
	WebElement table;
	
	public LandingPage() {
		PageFactory.initElements(driver, this);
	}
	public String landingpagetitle() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver.getTitle();
	}
	
	public boolean checktable() {
		return table.isDisplayed();
	}

}
