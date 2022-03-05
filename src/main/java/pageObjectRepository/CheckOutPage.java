package pageObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage{
	
	
	public  WebDriver driver;
	
public CheckOutPage(WebDriver driver) {
		
		this.driver=driver;
	}
	
     private By productdetails=By.xpath("//td[@class='cart_description']/h4/a");
     private By price=By.xpath("parent::h4/parent::td/following-sibling::td[1]/p");
     private By quantity=By.xpath("parent::h4/parent::td/following-sibling::td[2]/button");
     private By total=By.xpath("parent::h4/parent::td/following-sibling::td[3]/p");
     private By Message=By.xpath("//div[@id='ordermsg']/label/following-sibling::textarea");
     private By PlaceOrder=By.cssSelector("a[href*='payment']");
     
     private By validateDAName=By.cssSelector("ul[id='address_delivery'] li[class*='address_lastname']");
     private By validateDAAddress=By.cssSelector("ul[id='address_delivery'] li:nth-child(4)");
     
     private By validateDACountry=By.cssSelector("ul[id='address_delivery'] li[class='address_country_name']");
     private By validateDAContactNo=By.cssSelector("ul[id='address_delivery'] li[class='address_phone']");
    
     private By validateBAName=By.cssSelector("ul[id='address_invoice'] li[class*='address_firstname']");
     private By validateBAAddress=By.cssSelector("ul[id='address_invoice'] li:nth-child(4)");
     private By validateBACountry=By.cssSelector("ul[id='address_invoice'] li[class='address_country_name']");
     private By validateBAContactNo=By.cssSelector("ul[id='address_invoice'] li[class='address_phone']");
    
     
 public  String validateProductPrice(String name){
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,500)");
	
    	String temp="0";
	   List<WebElement> products=driver.findElements(productdetails);
	   for(WebElement item:products ) {
		   if(item.getText().equalsIgnoreCase(name)) {
			   
			  String p=item.findElement(price).getText();
			  temp=p;
			   break;
		   }
	
	   }
	   return temp;
    	 }
   
 
 public  String validateProductQuantity(String name){
 	
	 String temp="0";
	 List<WebElement> products=driver.findElements(productdetails);
	 for(WebElement item:products ) {
		   if(item.getText().equalsIgnoreCase(name)) {
			   
			   String p=item.findElement(quantity).getText();
			   temp=p;
			   break;
		   }
	
	   }
	   
	 return temp;
  	 }
 
 public void setMessage() {
	 
	 driver.findElement(Message).sendKeys("Test");
 }
 
 public void ClickPlaceOrder() {
	 
	 driver.findElement(PlaceOrder).click();
	 
 }
 public  String validateProductTotal(String name){
	 
	 
	 String temp="0";
	 List<WebElement> products=driver.findElements(productdetails);
	 for(WebElement item:products ) {
		   if(item.getText().equalsIgnoreCase(name)) {
			   
			   String p=item.findElement(total).getText();
			   temp=p;
			   break;
		   }
	
	   }
	   
	 return  temp;
 }
 
 public WebElement getDAName() {
	 
	 return driver.findElement(validateDAName);
 }
public WebElement getDAAddress() {
	 
	 return driver.findElement(validateDAAddress);
 }

public WebElement getDACountry() {
	 
	 return driver.findElement(validateDACountry);
}
public WebElement getDANcontactNo() {
	 
	 return driver.findElement(validateDAContactNo);
	 
	 
}



public WebElement getBAName() {
	 
	 return driver.findElement(validateBAName);
}
public WebElement getBAAddress() {
	 
	 return driver.findElement(validateBAAddress);
}

public WebElement getBACountry() {
	 
	 return driver.findElement(validateBACountry);
}
public WebElement getBANcontactNo() {
	 
	 return driver.findElement(validateBAContactNo);
	 
	 
}


}
   