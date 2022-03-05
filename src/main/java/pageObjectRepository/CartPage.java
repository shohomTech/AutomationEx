package pageObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage{
	
	
	public WebDriver driver;
	
public CartPage(WebDriver driver) {
		
		this.driver=driver;
	}
	
    private By text=By.xpath("//*[text()='Subscription']");
    private By textbox=By.id("susbscribe_email");
    private By button=By.id("subscribe");
    private By successmsg=By.cssSelector("div[class*='alert-success']");
    private By checkout=By.xpath("//*[text()='Proceed To Checkout']");
    private By register=By.cssSelector("div[class='modal-body'] a[href*='login']");
    private By removeProduct=By.cssSelector("a[class='cart_quantity_delete']");
    private By login=By.cssSelector("ul[class*='navbar-nav'] a[href*='login']");
    private By productcount=By.xpath("//td[@class='cart_description']/h4/a");
    
    public WebElement validateText(){
    	
    	return driver.findElement(text);
    	}
    
    public String validateProductcount() {
    	
    	 int count=driver.findElements(productcount).size();
    	 return String.valueOf(count);
    }
    
    public LoginPage clickLogin() {
    	
    	driver.findElement(login).click();
    	return new LoginPage(driver);
    }
    public LoginPage clickCheckout() {
    	
    	driver.findElement(checkout).click();
    	driver.findElement(register).click();
    	return new LoginPage(driver);
    }
    
    public void removeProducts() {
    	
    	
    	driver.findElement(removeProduct).click();
    }
    public CheckOutPage ProceedtoCheckout() {
    	
    	driver.findElement(checkout).click();
    	return new CheckOutPage(driver);
    }
    
   public void setEmail(String email){
    	
    	 driver.findElement(textbox).sendKeys(email);
    	}
   
   public void clickbutton(){
   	
  	 driver.findElement(button).click();
  	}
   public WebElement SuccessMessage(){
	   	
	  	return driver.findElement(successmsg);
	  	}
   
}
   