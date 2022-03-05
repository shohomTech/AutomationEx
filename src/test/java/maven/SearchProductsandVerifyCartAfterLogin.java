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



public class SearchProductsandVerifyCartAfterLogin extends baseClass {
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
	public void searchProductsandAddtoCart() throws InterruptedException{
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 ProductsPage c=new ProductsPage(driver);
		 c.validateText();
		 log.info("Text validated");
		 c.Search("jeans");
		 c.clickSearch();
		 c.addAllProducts();
		 cp=c.clickCart();
		 log.debug("All products are added");
	}
		
	  @Test
	  public void validateCartPageafterLogin() throws InterruptedException { 
		  
		  LoginPage l=cp.clickLogin();
		  log.info("Login page opened");
		  l.LoginEmail("hritik.y@yahoo.com");
		  l.getPassword("65345");
		  Thread.sleep(2000);
		  l.Loginbutton();
		  log.info("User successfully loggedin");
		  cp=l.Cart();
		  log.info("Cart Page opened");
		  Assert.assertTrue(cp.validateProductcount().contains("3"));
		  
		
	}
		
	
	
	
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
	
	

}
