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
import pageObjectRepository.LandingPage;
import pageObjectRepository.LoginPage;
import pageObjectRepository.ProductsPage;
import pageObjectRepository.baseClass;



public class VerifyBillingandDeliveryAddress extends baseClass {
	public WebDriver driver;
	private CheckOutPage co;
	
	
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
	public void Login() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(prop.getProperty("URL2"));
		
		log.info("Landing page loaded");
		 LandingPage lp= new LandingPage(driver);
		 lp.Homepage();
		 log.info("Homepage validated");
		 LoginPage p=lp.SignUpPage();
		p.VisibleText();
		log.info("Text validated");
		p.Name("Alex");
		p.SignUpEmail("ax.s@yahoo.com");
		
		p.SignIn();
		log.debug("SignIn successfull");
	}
	
	@Test(dependsOnMethods="Login")
	public void validateAccount() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		AccountCreationPage ap= new AccountCreationPage(driver);
		
		ap.validateText();
		log.info("Text validated");
		WebDriverWait w=new WebDriverWait(driver,10);
		w.until(ExpectedConditions.elementToBeClickable(ap.checkradiobutton()));
		ap.radiobutton();
		ap.name("Alex");
		ap.password("123456");		
		ap.date("17");
		ap.month("January");
		ap.year("2019");
		ap.Checkbox();
		ap.FirstName("Alex");
		ap.LastName("Lara");
		ap.Company("TRE");
		ap.Address();
		ap.country("India");
		ap.State("CA");
		ap.City("24 Paragans");
		ap.Zipcode("788561");
		ap.Mobile("9007542989");
		log.debug("All information entered successfully");
		ap.buttonclick();
		
		ap.successMessage();
		log.info("Account created");
		ap.Continuebutton();
		Assert.assertTrue(ap.Usernametext().getText().contains("Alex"));
		log.info("Username matched");
		ap.Products();
		
		}
	
	
	@Test(dependsOnMethods= {"validateAccount"})
	public void addProducts() throws InterruptedException {
		
		 ProductsPage c=new ProductsPage(driver);
		 c.validateText();
		 log.info("Text validated");
		 c.addToCartButton("men tshirt");
		 c.viewCartbutton();
		 log.debug("Products added");
		 CartPage cp=new CartPage(driver);
		 co=cp.ProceedtoCheckout();
		 
	}
	
	@Test(dependsOnMethods= {"addProducts"})
	public void validateDeliveryAddress() {
		
		
		Assert.assertTrue(co.getDAName().getText().contains("Mr. Alex Lara"));
		Assert.assertEquals(co.getDAAddress().getText(),"23/8 RT Lane,P.O RP,ABC");
		Assert.assertEquals(co.getDACountry().getText(), "India");
		Assert.assertEquals(co.getDANcontactNo().getText(), "9007542989");
		log.info("Assertion successful");
		
	}
	
	@Test(dependsOnMethods= {"validateDeliveryAddress"})
	public void validateBillingAddress() {
		
		Assert.assertTrue(co.getBAName().getText().contains("Mr. Alex Lara"));
		Assert.assertEquals(co.getBAAddress().getText(),"23/8 RT Lane,P.O RP,ABC");
		Assert.assertEquals(co.getBACountry().getText(), "India");
		Assert.assertEquals(co.getBANcontactNo().getText(), "9007542989");
		
		log.info("Assertion successful");
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
	
	

}
