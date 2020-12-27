package com.rediffmail.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.rediffmail.qa.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
    public static Properties prop;
	
			
		public TestBase(){
			try {
				prop = new Properties();
				FileInputStream ip = new FileInputStream("D:\\SELENIUM\\Myworkspace\\RediffmailTest\\src"
						+ "\\main\\java\\com\\rediffmail\\qa\\config\\config.properties");
				prop.load(ip);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
public static void initialization() {
	
	String BrowserName = prop.getProperty("browser");
	
	    prop.getProperty("Browser");
	    if (BrowserName.equals("chrome")) {
	    	System.setProperty("webdriver.chrome.driver", "D:\\SELENIUM\\Driver\\chromedriver");	
			driver = new ChromeDriver(); 
	    } else if(BrowserName.equals("FF")) {
	    	System.setProperty("webdriver.gecko.driver", "D:\\SELENIUM\\Driver\\geckodriver");	
			driver = new FirefoxDriver(); 
	    }
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	    
	    driver.get(prop.getProperty("url"));
	    
	    
	    
}

}
	

