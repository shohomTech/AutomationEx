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



public class ViewCartBrandProducts extends baseClass {
	public WebDriver driver;
	private LandingPage lp;
	
	
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
		 lp= new LandingPage(driver);
		 lp.Homepage();
		 log.info("Homepage validated");
		 lp.Products();
		 }
	
	@Test(dependsOnMethods= {"launchPage"})
	public void viewBrands() throws InterruptedException  {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 ProductsPage p= new ProductsPage(driver);
		 p.selectBrands("Madame");
		 log.debug("Brand Category page opened");
		 
		 p.selectBrands("Babyhug");
		 log.debug("Brand Category page opened");
	}
	
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	

	
}
