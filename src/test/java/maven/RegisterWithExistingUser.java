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
import pageObjectRepository.LandingPage;
import pageObjectRepository.LoginPage;
import pageObjectRepository.baseClass;



public class RegisterWithExistingUser extends baseClass {
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
	public void Login(){
		
		
		driver.get(prop.getProperty("URL2"));
		//Thread.sleep(10000);
		log.info("Landing page loaded");
		 LandingPage lp= new LandingPage(driver);
		 lp.Homepage();
		 log.info("Homepage validated");
		 LoginPage p=lp.SignUpPage();
		p.VisibleText();
		log.info("Text validated");
		p.Name("Hritik");
		p.SignUpEmail("hritik.y@yahoo.com");
		//Thread.sleep(3000);
		p.SignIn();
		Assert.assertEquals(p.ExistinguserErrmsg().getText(),"Email Address already exist!");
		log.error("Error msg validated");
	}
	
	
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
	
	

}
