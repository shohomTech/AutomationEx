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



public class ValidLoginUser extends baseClass {
	public WebDriver driver;
	public LandingPage lp;
	public LoginPage p;
	
	
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
	public void getLogin() {
		
		
		
		driver.get(prop.getProperty("URL2"));
		//Thread.sleep(10000);
		log.info("Landing page loaded");
		 lp= new LandingPage(driver);
		 lp.Homepage();
		 log.info("Homepage validated");
		 p=lp.SignUpPage();
		p.LoginText();
		log.info("Text validated");
		
		}
	
	@Test(dataProvider="getData")
	public void userDetails(String email,String password,String name) {
		
		
		p.LoginEmail(email);
		p.getPassword(password);
		p.Loginbutton();
		//Thread.sleep(3000);
		//log.debug("Login successfull");
		AccountCreationPage ap=new AccountCreationPage(driver);
		if(!driver.getTitle().contains("Signup")) {
		Assert.assertTrue(ap.Usernametext().getText().contains(name));
			log.debug("Username matched");
			ap.Logout();
		}
		
		else {
			
			Assert.assertTrue(p.getMessage().getText().contains("Your email or password is incorrect!"));
			log.error("Wrong Username/Password");
		}
		

		
	}
	
	
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
	
	
	@DataProvider
	public Object[][] getData() {
		
		Object[][] b=new Object[][] {{"hritik.y@yahoo.com","65345","Hritik"},{"gautam.g@yahoo.com","55542","Gautam"}};
		
		return b;
	}
	

}
