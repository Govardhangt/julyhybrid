package com.empire.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.empire.qa.utils.EventListner_Test;

public class BaseTest {

	 public static Properties prop;
	 public static WebDriver driver;
	 public static EventListner_Test eventlistnertest;
	 public static EventFiringWebDriver efw_driver;
	 
	 public BaseTest() throws Throwable {
			try {
				prop = new Properties();
				FileInputStream file = new FileInputStream("D:\\KCSM14\\julyhybrid\\src\\main\\java\\com\\eh\\qa\\config\\config.properties");
				prop.load(file);
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
	 }
	 
	 public static void initialization() throws Throwable {
		 String BrowserName = prop.getProperty("browser");
		 if(BrowserName.equals("chrome")) {
			 driver = new ChromeDriver();
		 }
		 else if(BrowserName.equals("firefox")) {
			 driver = new FirefoxDriver();
		 }
		 else if(BrowserName.equals("safari")) {
			 driver = new SafariDriver();
		 }
		 else if(BrowserName.equals("edge")) {
			 driver = new EdgeDriver();
		 }  
		 else {
			 System.out.println("Dabba fellow enter proper browser value");
		 }
		 eventlistnertest = new EventListner_Test();
		 efw_driver = new EventFiringWebDriver(driver);
		 efw_driver.register(eventlistnertest);
		 driver = efw_driver;
		 
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 driver.get(prop.getProperty("url"));
	 }
}


