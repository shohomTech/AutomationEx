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



public class RegisterUserAE extends baseClass {
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
	public void Login()throws IOException, InterruptedException {
		
		
		driver.get(prop.getProperty("URL2"));
		//Thread.sleep(10000);
		log.info("Landing page loaded");
		 LandingPage lp= new LandingPage(driver);
		 lp.Homepage();
		 log.info("Homepage validated");
		 LoginPage p=lp.SignUpPage();
		p.VisibleText();
		log.info("Text validated");
		p.Name("Feder");
		p.SignUpEmail("fd.y@yahoo.com");
		//Thread.sleep(3000);
		p.SignIn();
		log.debug("SignIn successfull");
	}
	
	@Test(dependsOnMethods="Login")
	public void validateAccount() throws InterruptedException {
		
		AccountCreationPage ap= new AccountCreationPage(driver);
		
		ap.validateText();
		log.info("Text validated");
		WebDriverWait w=new WebDriverWait(driver,10);
		w.until(ExpectedConditions.elementToBeClickable(ap.checkradiobutton()));
		ap.radiobutton();
		ap.name("Feder");
		//Assert.assertEquals(ap.email(), "george.y@yahoo.com");
		ap.password("65345");
		
		ap.date("14");
		ap.month("January");
		ap.year("2021");
		ap.Checkbox();
		ap.FirstName("Feder");
		ap.LastName("Cooper");
		ap.Company("TRE");
		ap.Address();
		ap.country("India");
		ap.State("CA");
		ap.City("24 Paragans");
		ap.Zipcode("788563");
		ap.Mobile("9087542987");
		log.debug("All information entered successfully");
		ap.buttonclick();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		ap.successMessage();
		log.info("Account created");
		ap.Continuebutton();
		Assert.assertTrue(ap.Usernametext().getText().contains("Feder"));
		log.info("Username matched");
		ap.Logout();
		//Thread.sleep(2000);
		
		}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
	
	

}
