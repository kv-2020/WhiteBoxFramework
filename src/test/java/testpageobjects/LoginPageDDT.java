package testpageobjects;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.BaseClass;
import pageobjects.HomePage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import utilities.ReadXL;

public class LoginPageDDT extends BaseClass  {
	HomePage hp;
	LoginPage lp;
	LandingPage landpage;
	
	LoginPageDDT(){
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
	@Test(dataProvider="logindata")
	public void loginddt(String user,String pwd) throws InterruptedException {
		lp.setusername(user);
		logger.info("sending user name from excel");
		lp.setpassword(pwd);
		logger.info("sending password from excel");
		lp.clickSubmit();
		
		landpage=new LandingPage();

		Thread.sleep(3000);	
		try {
	if(landpage.checktable()) {
		System.out.println("successful login");
		logger.info("check to see if login is successful");
	}
		}
	catch(Exception e) {
		System.out.println("login failed");
		logger.info("check to see if login is unsuccessful");
		try {
			hp.captureScreen(driver,"whiteboxtest");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Assert.assertFalse(true);
	}
	}
	
	@DataProvider(name="logindata")
	String [][]getdata() throws IOException{
		String path="C:\\Users\\kittu\\WhiteboxAutomation\\WhiteBox\\src\\test\\resources\\WhiteBox.xlsx";
		int rownum=ReadXL.getRowCount(path, "Sheet1");
		int colcount=ReadXL.getCellCount(path, "Sheet1", 1);
		String logindata[][]=new String[rownum][colcount]; 
		//0 is for header..column is 0
		for(int i=1;i<=rownum;i++) {
			for(int j=0;j<colcount;j++ ) {
				logindata[i-1][j]=ReadXL.getCellData(path, "Sheet1", i, j);//1  0
			}
		}
		return logindata;
	}
	



}
