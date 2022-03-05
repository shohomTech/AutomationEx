package maven;

import java.io.IOException;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjectRepository.LandingPage;
import pageObjectRepository.baseClass;


public class validateSearchBox extends baseClass {
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
	
	
	@Test
	public void validateText() throws IOException, InterruptedException{
		
		
		driver.get(prop.getProperty("URL"));
		
		log.info("Landing page loaded");
		
		LandingPage lp= new LandingPage(driver);
       //Assert.assertEquals(lp.text().getText(), "Create Account");
		lp.getSearchBox();
       log.debug("Results shown");
       
}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
}