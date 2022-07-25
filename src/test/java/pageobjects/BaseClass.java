package pageobjects;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.internal.Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ReadConfig;

public class BaseClass {
	
	public static WebDriver driver;
	public static Logger logger;
	ReadConfig readconfig=new ReadConfig();
	Properties pr= readconfig.loadConfig();
	String baseurl=readconfig.getApplicationURL(pr);
	String username=readconfig.getUsername(pr);
	String password=readconfig.getPassword(pr);
	

	public  void initialization() {
		
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		driver.get(baseurl);
		
		driver.manage().window().maximize(); 
		System.out.println("Initialized");
		logger=Logger.getLogger("WhiteBox");
		PropertyConfigurator.configure("C:\\Users\\kittu\\WhiteboxAutomation\\WhiteBox\\src\\test\\resources\\log4j.properties");
		
		logger.info("url is opened");
		}
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		//System.out.println("before taking screenshot in "+tname);
		//TakesScreenshot ts = (TakesScreenshot) driver;
		
		File source = ((TakesScreenshot)(driver)).getScreenshotAs(OutputType.FILE);
		
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + System.currentTimeMillis() + ".png");
		
		FileUtils.copyFile(source, target);
		
		System.out.println("Screenshot taken");
	}

}
