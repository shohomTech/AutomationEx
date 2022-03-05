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
import pageObjectRepository.CartPage;
import pageObjectRepository.ContactPage;
import pageObjectRepository.LandingPage;
import pageObjectRepository.LoginPage;
import pageObjectRepository.ProductsPage;
import pageObjectRepository.baseClass;



public class AddReviewonProducts extends baseClass {
	public WebDriver driver;
	private CartPage cp;
	
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
	public void launchPage(){
		
		
		driver.get(prop.getProperty("URL2"));
		
		log.info("Landing page loaded");
		 LandingPage lp= new LandingPage(driver);
		 lp.Homepage();
		 log.info("Homepage validated");
		 lp.Products();
		 log.debug("Product Page opened");
		 
	}
	
	@Test
	public void viewProductsandAddReviews(){
		
		 ProductsPage c=new ProductsPage(driver);
		 c.validateText();
		 log.info("Text validated");
		 c.viewProducts("blue top");
		 log.debug("Product Detail page opened");
		 c.setName("ABC");
		 c.setEmail("kk@yahoo.com");
		 c.setreviewComments("Test");
		 log.info("All details entered");
		 c.clickreviewButton();
		 Assert.assertTrue(c.validateReviewMsg().getText().contains("Thank you for your review."));
		 
	}
		
	  
		
	
	
	
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
	
	

}
