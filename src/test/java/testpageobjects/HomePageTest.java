package testpageobjects;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjects.BaseClass;
import pageobjects.HomePage;
import pageobjects.LoginPage;

public class HomePageTest extends BaseClass  {
	HomePage hp;
	LoginPage lp;
	
	HomePageTest(){
		super();
	}
	@BeforeMethod
	public void setup() {
	
		initialization();
		hp=new HomePage(driver);
		
	}
	@AfterMethod
	
	public void teardown() {
		
		driver.close();
		logger.info("browser is closed");
	}
			
	@Test
	public void homepagetitletest() {
		
		String actualtitle=hp.checkhomepagetitle();
		String expectedtitle="QA/QE/SDET Training.";
		logger.info("checking for correct title");
		Assert.assertEquals(expectedtitle, actualtitle);
		logger.info("Test passed");
	}
	@Test
	public void logotest() {
		boolean logo=hp.checklogo();
		logger.info("checking if logo is present or not");
		Assert.assertTrue(logo);
	}
	@Test
	public void checkstudentaccesstest() {
		boolean sa=hp.checkstudentaccess();
		logger.info("checking if student access text  is present or not");
		Assert.assertTrue(sa);
	}
	@Test
	public void signintest() {
		lp=hp.clicklb();
		logger.info("click login button");
	}
	

}
