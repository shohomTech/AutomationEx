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
import pageObjectRepository.PaymentPage;
import pageObjectRepository.ProductsPage;
import pageObjectRepository.baseClass;



public class RegisterWhileCheckout extends baseClass {
	public WebDriver driver;
	//public String ID;
	private ProductsPage c;
	private LoginPage l;
	
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
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 ProductsPage c=new ProductsPage(driver);
		 c.validateText();
		 log.info("Text validated");
		 c.addToCartButton("blue top");
		 log.debug("Product added");
		 c.continueShopping();
		 
	
	
		 CartPage p=c.clickCart();
		 log.debug("Cart Page opened");
		 
		 
		 l=p.clickCheckout();
		 log.debug("login page opened");
	}
	
	@Test(dependsOnMethods= {"validateQuantity"})
	public void accountCreation() { 
		
		 l.VisibleText();
		 log.info("Text validated");
		 l.SignUpName("Charlie");
		 l.SignUpEmail("ct@yahoo.com");
		 l.SignIn();
		 log.debug("A/c creation page opened");
		 
		 AccountCreationPage ap= new AccountCreationPage(driver);
		 ap.validateText();
		 log.info("Text validated");
		 WebDriverWait w=new WebDriverWait(driver,10);
		 w.until(ExpectedConditions.elementToBeClickable(ap.checkradiobutton()));
		 ap.radiobutton();
		 ap.name("Charlie");
			//Assert.assertEquals(ap.email(), "george.y@yahoo.com");
		 ap.password("65341");
			
		 ap.date("14");
		 ap.month("January");
		 ap.year("2021");
		 ap.Checkbox();
		 ap.FirstName("Charlie");
		 ap.LastName("Jorden");
		 ap.Company("TRE");
		 ap.Address();
		 ap.country("India");
		 ap.State("FD");
		 ap.City("24 Paragans");
		 ap.Zipcode("788462");
		 ap.Mobile("9043540967");
		 log.debug("All information entered successfully");
		 ap.buttonclick();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 ap.successMessage();
		 log.info("Account created");
		 ap.Continuebutton();
	}
	
	@Test(dependsOnMethods= {"accountCreation"})
	public void CheckOut() throws InterruptedException {
		
	     LandingPage lp=new LandingPage(driver);
		 CartPage p1=lp.Cart();
		 CheckOutPage cop=p1.ProceedtoCheckout();
		 cop.setMessage();
		 cop.ClickPlaceOrder();
		 PaymentPage pp= new PaymentPage(driver);
		 pp.setName("Charlie Jorden");
		 Thread.sleep(2000);
		 pp.setCardNo("2102 7767 0088 9006");
		 Thread.sleep(2000);
		 pp.setCVC("914");
		 Thread.sleep(2000);
		 pp.setMonth("12");
		 Thread.sleep(2000);
		 pp.setYear("2011");
		 Thread.sleep(2000);
		 log.info("All details entered successfully");
		 pp.pay();
			
		 Assert.assertTrue(pp.validateConfirmationMsg().getText().equalsIgnoreCase("ORDER PLACED!"));
			
		 
	}
	
	
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	

	
	

}
