package testpageobjects;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjects.BaseClass;
import pageobjects.HomePage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;

public class LandingPageTest extends BaseClass {
	HomePage hp;
	LoginPage lp;
	LandingPage landpage;
	
	public LandingPageTest(){
		super();
	}
	@BeforeMethod
	public void setup() {
		initialization();
		hp=new HomePage(driver);
		lp=new LoginPage(driver);
		lp=hp.clicklb();
		landpage=lp.checksignin();
	}
	@AfterMethod
	public void teardown() {
		driver.close();
	}
	@Test
	public void landingpagetitletest() {
		
		String title=landpage.landingpagetitle();
		logger.info("check to see if page title is correct");

		Assert.assertEquals(title, "QA/QE/SDET Training.");
	}

}
