package testpageobjects;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjects.BaseClass;
import pageobjects.HomePage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;

public class LoginPageTest extends BaseClass {
	HomePage hp;
	LoginPage lp;
	LandingPage landpage;
	
	LoginPageTest(){
		super();
	}
	@BeforeMethod
	public void setup() {
		initialization();
		hp=new HomePage(driver);
		lp=new LoginPage(driver);
		lp=hp.clicklb();
		
	}
	@AfterMethod
	public void teardown() {
		driver.close();
		logger.info("browser is closed");
	}
	@Test
	public void loginPagetitletest() {
		String title=lp.checkSignInPage1title();
		Assert.assertEquals(title, "QA/QE/SDET Training.");
		logger.info("checking for page title");
	}
	@Test
	public void checksignintest() {
		landpage=lp.checksignin();
		logger.info("check to see if sign button is clicked");
	}

}
