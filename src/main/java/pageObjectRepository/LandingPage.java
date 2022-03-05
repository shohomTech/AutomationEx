package pageObjectRepository;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class LandingPage {
	
	

	
public WebDriver driver;
	
	@FindBy(linkText="Sign in")
	private WebElement signIn;
	
	@FindBy(id="srchword")
	private WebElement searchbox;
	
	@FindBy(css="[alt*='automation practice']")
	private WebElement automationIcon;
	
	@FindBy(css="[href*='login']")
	private WebElement Signupbutton;
	
	@FindBy(css="a[href*='contact_us']")
	private WebElement ContactUsLink;
	
	@FindBy(xpath="//*[text()=' Products']")
	private WebElement ProductLink;
	
	@FindBy(css="a[href*='cart']")
	private WebElement CartLink;
	
	@FindBy(css="a[href*='Women'] span i")
	private WebElement WomenCategory;
	
	@FindBy(xpath="//div[@id='Women']/div/ul/li/a")
	private List<WebElement> WomenCategoryLists;
	
	@FindBy(css="a[href*='Men'] span i")
	private WebElement MenCategory;
	
	@FindBy(xpath="//div[@id='Men']/div/ul/li/a")
	private List<WebElement> MenCategoryLists;
	
	@FindBy(xpath="//*[text()='Subscription']")
	private WebElement text;
	
	@FindBy(css="body")
	private WebElement page;
	
	@FindBy(xpath="//a[@id='scrollUp']")
	private WebElement scrollup;
	
	@FindBy(xpath="//*[text()='Full-Fledged practice website for Automation Engineers']")
	private WebElement headertext;
	
	
	
	
	
	public LandingPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	public WebElement subscriptionText() {
		
		return text;
	}
	
	public void ScrollUp() {
		  
	
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollBy(0, -10000)");
	}
	
	public String getText() {
		
		return headertext.getText();
		
		
	}
	public void pagedown() {
		
		page.sendKeys(Keys.CONTROL,Keys.END);
		/*JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);*/
	}
	public ContactPage ContactUs() 
	{
		
		ContactUsLink.click();
		 
		 return new ContactPage(driver);
		 }
	
	public void Products() 
	{
		ProductLink.click();
		 }
	
	
	public void getWomenCategory(String name) {
		
		
		List<WebElement>lists=WomenCategoryLists;
		
		for(WebElement item: lists) {
			
			if(item.getText().equalsIgnoreCase(name)) {
				
				 item.click();
				 break;
				
			}
			
		}
	}
	
  public void getMenCategory(String name) {
		
		
		
		List<WebElement>lists=MenCategoryLists;
		
		for(WebElement item: lists) {
			
			if(item.getText().equalsIgnoreCase(name)) {
				
				 item.click();
				 break;
				
			}
			
		}
	}


	public void clickOnWomenCategory() throws InterruptedException 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,400)");
		
		WomenCategory.click();
		Thread.sleep(3000);
		 }
	
	public void clickOnMenCategory() throws InterruptedException 
	{
		
		MenCategory.click();
		Thread.sleep(3000);
		 }
	
	public CartPage Cart() 
	{
		
		CartLink.click();
		 
		 return new CartPage(driver);
		 }
	

	public LoginPage SignIn() 
	{
		
		 signIn.click();
		 
		 return new LoginPage(driver);
		 
		
	}
	
	public WebElement Homepage() 
	{
		return automationIcon;
		
		 
	}
	
	public LoginPage SignUpPage() 
	{
		Signupbutton.click();
		return new LoginPage(driver);
		 
	}
	
	
	public void getSearchBox()
	{
		
		searchbox.sendKeys("watch",Keys.ENTER);
		
		
	}
	

}
	
	
	


