import java.io.*;
import java.util.*;

import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;	
import org.testng.annotations.Test;	
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;	
import org.testng.annotations.AfterTest;	
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
public class SeleniumLogin {		
	    // WebDriver driver= new HtmlUnitDriver();

	WebElement username, password, Login_button;
    String baseURL, userName, passWord, loginBtn, logoutURL;
	public WebDriver driver;
	
	
	 
		@Test				
		public void testEasy() {	
			Properties configFile = new Properties();
			try {
				configFile.load(SeleniumLogin.class.getClassLoader().getResourceAsStream("config.properties"));
				 baseURL = configFile.getProperty("baseURL");
				System.out.println("baseURL is --> " +baseURL);
				
				 userName = configFile.getProperty("userName");
				System.out.println("userName is --> " +userName);
				
				 passWord = configFile.getProperty("passWord");
				System.out.println("passWord is --> " +passWord);
				
				 loginBtn = configFile.getProperty("loginBtn");
				System.out.println("loginBtn is --> " +loginBtn);
				
				 logoutURL = configFile.getProperty("logoutURL");
				System.out.println("logoutURL is --> " +logoutURL);
				
			} catch (IOException e) {
	 
				e.printStackTrace();
			}
			
			driver.get("https://dev32539.service-now.com/welcome.do");  
			String title = driver.getTitle();	
			System.out.println("Title of page -- " + title);
			//Assert.assertTrue(title.contains("Demo Guru99 Page")); 	
			username = driver.findElement(By.id("user_name"));
			// enter username
			username.sendKeys(userName);

			// find the password field
			password = driver.findElement(By.id("user_password"));
            password.sendKeys(passWord);
			
			// Click the loginbutton
			Login_button = driver.findElement(By.id(loginBtn));
			Login_button.click();
		}	
		@BeforeTest
		public void beforeTest() {	
			 driver = new HtmlUnitDriver(); 
		}	
		@AfterTest
		public void afterTest() {
			driver.get(logoutURL);
			
			driver.quit();			
		}		
}	

