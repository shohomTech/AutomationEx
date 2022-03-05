package maven;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjectRepository.LandingPage;
import pageObjectRepository.LoginPage;
import pageObjectRepository.baseClass;



public class RediffHomepage extends baseClass {
	public WebDriver driver;
	
	
	public static Logger log=LogManager.getLogger(baseClass.class.getName());
	
	@BeforeTest
	public void getURL() throws IOException
	{
		driver=initializeDriver();
		
		log.info("Driver initialized");
		driver.manage().window().maximize();
		log.info("Window maximized");
		
	}
	
	@Test(dataProvider="getData")
	public void validateLoginPage(String username,String password) throws IOException, InterruptedException {
		
		
		driver.get(prop.getProperty("URL"));
		Thread.sleep(10000);
		log.info("Landing page loaded");
		 LandingPage lp= new LandingPage(driver);
		//lp.SignIn().click();
		 LoginPage p=lp.SignIn();
		 //Thread.sleep(5000);
		log.debug("Sign in successfull");
		p.username().sendKeys(username);
		p.password().sendKeys(password);
		Thread.sleep(3000);
		p.mailSignIn();
		
		log.error("Wrong Username & Password");
		//Thread.sleep(3000);
		//l.logOut().click();
		
		
		
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
	
	@DataProvider
	public Object[][] getData() {
		
		Object[][] data= new Object[2][2];
		
		data[0][0] ="abc@rediffmail.com";
		data[0][1]="12345";
		
		data[1][0]="xyz@rediffmail.com";
		data[1][1]="23456";
		
		return data;
		
		
	}

}
