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
import pageObjectRepository.CheckOutPage;
import pageObjectRepository.ContactPage;
import pageObjectRepository.LandingPage;
import pageObjectRepository.LoginPage;
import pageObjectRepository.ProductsPage;
import pageObjectRepository.baseClass;



public class RemoveFromCart extends baseClass {
	public WebDriver driver;
	//public String ID;
	//private ProductsPage c;
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
		 }
	
	@Test(dependsOnMethods= {"launchPage"})
	public void addProducts() throws InterruptedException {
		
		 ProductsPage c=new ProductsPage(driver);
		 c.validateText();
		 log.info("Text validated");
		 c.addToCartButton("men tshirt");
		 log.debug("Products added");
		 c.continueShopping();
		 cp=c.clickCart();
		 
		 
	}
	@Test(dependsOnMethods= {"addProducts"})
	public void validateRemoveProducts()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		cp.removeProducts();
		log.debug("Product removed");
		
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	

	
}
