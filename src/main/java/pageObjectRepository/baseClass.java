package pageObjectRepository;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseClass {
	public  WebDriver driver;
	public Properties prop;
	

	public WebDriver initializeDriver() throws IOException
	{
		
		prop= new Properties();
		
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		
		String browserName=System.getProperty("browser");
		
		//String browserName=prop.getProperty("browser");
		System.out.println(browserName);
		
		
		if(browserName.contains("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			//WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
			ChromeOptions options =new ChromeOptions();
			 if(browserName.contains("headless"))
			 {			
				 options.addArguments("--headless");
				 options.addArguments("--user-agent=Mozilla/5.0 (Windows NT 6.2; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36");
				 
			 }
			 driver= new ChromeDriver(options);
			 driver.manage().deleteAllCookies();
			 
			
		}
		
		
		else if (browserName.contains("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions Options = new FirefoxOptions();
			
			if(browserName.contains("headless"))
			{
				
				Options.addArguments("--headless");
				//Options.addArguments("--user-agent=Mozilla/5.0 (Windows NT 6.2; Win64; x64; rv:94.0) Gecko/20100101 Firefox/94.0");
			}
			driver= new FirefoxDriver(Options);
			driver.manage().deleteAllCookies();
		}
		
		//driver.manage().timeouts().getImplicitWaitTimeout().withSeconds(10);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		return driver;
	}
	
	public String getScreenshots(String testcaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot s=(TakesScreenshot)driver;
		File src=s.getScreenshotAs(OutputType.FILE);
		String dFile=System.getProperty("user.dir")+ "\\reports\\"+testcaseName+".png";
		FileUtils.copyFile(src,new File(dFile));
		
		return dFile;
		
	}

}


