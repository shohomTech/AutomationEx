package maven;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjectRepository.AccountCreationPage;
import pageObjectRepository.ContactPage;
import pageObjectRepository.LandingPage;
import pageObjectRepository.LoginPage;
import pageObjectRepository.baseClass;



public class FillContactform extends baseClass {
	public WebDriver driver;
	
	
	public static Logger log=LogManager.getLogger(baseClass.class.getName());
	
	@BeforeTest
	public void getURL() throws IOException
	{
		driver=initializeDriver();
		
		log.info("Driver initialized");
		driver.manage().window().maximize();
		log.info("Window maximized");
		
	}
	
	@Test
	public void ContactForm() throws IOException{
		
		
		driver.get(prop.getProperty("URL2"));
		//Thread.sleep(10000);
		log.info("Landing page loaded");
		 LandingPage lp= new LandingPage(driver);
		 lp.Homepage();
		 log.info("Homepage validated");
		 ContactPage c=lp.ContactUs();
		 c.Name("Rohan");
		 c.Email("xyz@yahoo.com");
		 c.setSubject("Doubt");
		 c.setMessage("Test");
		 c.uploadFile();
		 //Runtime.getRuntime().exec("D:\\fileupload.exe");
		 log.info("File uploaded");
		 c.Submit();
		 driver.switchTo().alert().accept();
		 Assert.assertEquals(c.validateSuccessMsg().getText(),"Success! Your details have been submitted successfully.");
		 
		log.info("Query Submitted successfully");
		c.navigateToHome();
		lp.Homepage();
		log.info("Homepage validated");
	}
	
	
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
	
	

}
