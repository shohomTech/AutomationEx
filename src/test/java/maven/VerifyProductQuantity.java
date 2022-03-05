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
import pageObjectRepository.CheckOutPage;
import pageObjectRepository.ContactPage;
import pageObjectRepository.LandingPage;
import pageObjectRepository.LoginPage;
import pageObjectRepository.ProductsPage;
import pageObjectRepository.baseClass;



public class VerifyProductQuantity extends baseClass {
	public WebDriver driver;
	//public String ID;
	private ProductsPage c;
	
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
	public void validateQuantity() throws InterruptedException {
		
		 ProductsPage c=new ProductsPage(driver);
		 c.validateText();
		 log.info("Text validated");
		 c.viewProducts("men tshirt");
		 log.debug("Products page opened");
		 Assert.assertTrue(c.ProductName().equalsIgnoreCase("Men Tshirt"));
		 c.setQuantity("4");
		 log.debug("Quantity added");
		 c.addtocartbutton();
		 c.viewCartbutton();
		 Assert.assertTrue(c.getQuantity().contains("4"));
		 log.debug("Validation successful");
		 
	}
	
	
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	

	
	

}
