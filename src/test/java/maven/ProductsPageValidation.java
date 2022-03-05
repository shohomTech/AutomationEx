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
import pageObjectRepository.ProductsPage;
import pageObjectRepository.baseClass;



public class ProductsPageValidation extends baseClass {
	public WebDriver driver;
	//public String ID;
	
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
	public void validateProducts(){
		
		
		driver.get(prop.getProperty("URL2"));
		//Thread.sleep(10000);
		log.info("Landing page loaded");
		 LandingPage lp= new LandingPage(driver);
		 lp.Homepage();
		 log.info("Homepage validated");
		 lp.Products();
		 ProductsPage c=new ProductsPage(driver);
		 c.validateText();
		 log.info("Text validated");
		 c.viewProducts("blue top");
		 Assert.assertTrue(c.ProductName().equalsIgnoreCase("Blue Top"));
		 log.debug("Product Name matched");
		 Assert.assertTrue(c.Category().getText().contains("Women > Tops"));
		 log.debug("Category matched");
		 Assert.assertTrue(c.ProductPrice().getText().contains("500"));
		 log.debug("Product Price matched");
		 c.Quantity();
		 log.info("Quantity matched");
		 Assert.assertTrue(c.Availability().getText().contains("In Stock"));
		 Assert.assertTrue(c.Condition().getText().contains("New"));
		 Assert.assertTrue(c.Brand().getText().contains("Polo"));
		 log.debug("Brand matched");
		
	}
	
	
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
	
	

}
