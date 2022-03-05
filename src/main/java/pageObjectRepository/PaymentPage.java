package pageObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage{
	
	
	public  WebDriver driver;
	
public PaymentPage(WebDriver driver) {
		
		this.driver=driver;
	}
	
     private By Name=By.cssSelector("input[data-qa='name-on-card']");
     private By CardNo=By.name("card_number");
     private By CVC=By.name("cvc");
     private By Month=By.cssSelector("input[data-qa='expiry-month']");
     private By Year=By.cssSelector("input[data-qa='expiry-year']");
     private By PayButton=By.cssSelector("button[data-qa='pay-button']");
     private By text=By.xpath("//*[text()='Order Placed!']");
     private By invoice=By.xpath("//*[text()='Download Invoice']");
     private By continuebutton=By.xpath("//*[text()='Continue']");
     
     public void setName(String name) {
    	 
    	 driver.findElement(Name).sendKeys(name,Keys.ENTER);
     }
    public void setCardNo(String cardNo) {
    	 
    	 driver.findElement(CardNo).sendKeys(cardNo,Keys.ENTER);
     }
    
    public void downloadInvoice() {
      	 
      	 driver.findElement(invoice).click();
       }
    
    public void clickContinue() {
     	 
     	 driver.findElement(continuebutton).click();
      }
    
    
    public void setCVC(String cvc) {
   	 
   	 driver.findElement(CVC).sendKeys(cvc,Keys.ENTER);
    }
    
    public void setMonth(String month) {
      	 
      	 driver.findElement(Month).sendKeys(month,Keys.ENTER);
       }
    
    public void setYear(String year) {
     	 
     	 driver.findElement(Year).sendKeys(year,Keys.TAB);
      }
    
    public void pay() {
    	
    	driver.findElement(PayButton).click();
    	WebDriverWait w1= new WebDriverWait(driver,10);
		w1.until(ExpectedConditions.visibilityOfElementLocated(text));
    }
    
    public WebElement validateConfirmationMsg()
{
   return driver.findElement(text);
    	
} 
}
     
 