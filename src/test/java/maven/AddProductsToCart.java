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



public class AddProductsToCart extends baseClass {
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
	public void addProducts() throws InterruptedException {
		
		 ProductsPage c=new ProductsPage(driver);
		 c.validateText();
		 log.info("Text validated");
		 c.addToCartButton("blue top");
		 c.continueShopping();
		 c.addToCartButton("men tshirt");
		 c.viewCartbutton();
		 log.debug("Products added");
		 
	}
	
	@Test(dataProvider="getData",dependsOnMethods= {"addProducts"})
	public void validatecheckOut(String productname,String Price,String Quantity,String Total) {
		 //c.AddtoCartbutton("Men Tshirt");	 
		 CheckOutPage cp= new CheckOutPage(driver);
		 Assert.assertTrue(cp.validateProductPrice(productname).contains(Price));
		 Assert.assertTrue(cp.validateProductQuantity(productname).contains(Quantity));
		 Assert.assertTrue(cp.validateProductTotal(productname).contains(Total));
		
	}
	

	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	

	@DataProvider
	public Object[][] getData() {
		
		Object[][] data= new Object[][] {{"Blue Top","500","1","500"},{"Men Tshirt","400","1","400"}};
		
		/*data[0][0] ="Blue Top";
		data[0][1]="500";
		data[0][2]="1";
		data[0][3]="500";
		
		data[1][0]="Men Tshirt";
		data[1][1]="400";
		data[1][2]="1";
		data[1][3]="400";*/
		
		return data;
		
		
	}
	

}
