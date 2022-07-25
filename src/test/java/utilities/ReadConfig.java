package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	 
	
	public Properties  loadConfig()
	{
		Properties prop=new Properties();
		File src=new File("C:\\Users\\kittu\\WhiteboxAutomation\\WhiteBox\\src\\test\\resources\\config.propertries");
		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
		return prop;
	}
		public String getApplicationURL( Properties prop)
		{
			String url=prop.getProperty("baseurl");
			return url;
		}
		
		public String getUsername( Properties prop)
		{
		String username=prop.getProperty("username");
		return username;
		}
		
		public String getPassword( Properties prop)
		{
		String password=prop.getProperty("password");
		return password;
		}

		

	}
	


