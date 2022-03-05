package pageObjectRepository;

import java.util.Iterator;
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

public class ProductsPage{
	
	
	public WebDriver driver;
	public static int count;
	
	
public ProductsPage(WebDriver driver) {
		
		this.driver=driver;
		
	}
	
    private By text=By.xpath("//*[text()='All Products']");
    private By button=By.cssSelector("a[href*='product_details']");
    private By ViewProduct=By.xpath("//div[@class='single-products']/following-sibling::div/ul/li/a");
    private By viewProduct=By.xpath("parent::div/parent::div/following-sibling::div/ul/li/a");
    private By productname=By.cssSelector("div[class='product-information'] h2");
    private By productinfo=By.cssSelector("div[class='product-information'] p");
    private By price=By.cssSelector("div[class='product-information'] span span");
    private By quantity=By.id("quantity");
    private By searchbox=By.id("search_product");
    private By searchbutton=By.id("submit_search");
    private By validateproductname=By.xpath("//div[@class='single-products']/div/p");
    private By Products=By.xpath("//div[@class='single-products']/div/p");
    private By continueshopping=By.xpath("//button[text()='Continue Shopping']");
	private By ViewCart=By.cssSelector("div[class='modal-body'] a");
	private By AddToCart=By.cssSelector(".btn.btn-default.cart");
	private By ADDTOCART=By.xpath("following-sibling::a");
	private By validatequantity=By.cssSelector("td[class='cart_quantity'] button");
	private By Cartbutton=By.cssSelector("ul[class*='navbar-nav'] a[href*='view_cart']");
	private By Brands=By.tagName("a");
	private By listofpdts=By.xpath("//div[@class='single-products']/div/a");
	private By reviewName=By.id("name");
	private By reviewEmail=By.id("email");
	private By inputReview=By.id("review");
	private By reviewButton=By.id("button-review");
	private By reviewmsg=By.cssSelector("div[class*='alert-success'] span");
	
	
    public WebElement validateText(){
    	
    	return driver.findElement(text);
    	}
    
    public void addAllProducts() throws InterruptedException {
    	
    	List<WebElement> lists=driver.findElements(listofpdts);
    	
    		
    		for(WebElement item:lists) {
    			
    			item.click();
    			Thread.sleep(2000);
    			driver.findElement(continueshopping).click();
    			
    		}
    	
    	
    }
   
    public void setName(String Name) {
    	
    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,500)");
    	
    	driver.findElement(reviewName).sendKeys(Name,Keys.ENTER);
    }
    
   public void setEmail(String Email) {
    	
    	driver.findElement(reviewEmail).sendKeys(Email,Keys.ENTER);
    	
    }
   
   public void setreviewComments(String Comments) {
   	
   	driver.findElement(inputReview).sendKeys(Comments);
   	
   }
    
   
   public void clickreviewButton() {
	   	
	   	driver.findElement(reviewButton).click();;
	   	
	   }
   
   public WebElement validateReviewMsg() {
	   
	   return driver.findElement(reviewmsg);
   }
    public CartPage clickCart() {
    	
    	driver.findElement(Cartbutton).click();
    	return new CartPage(driver);
    }
    
    public void selectBrands(String name) {
    	
    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,400)");
    	
    	List<WebElement> lists=driver.findElements(Brands);
    	
    	for(WebElement item:lists) {
    		
    		if(item.getAttribute("href").contains(name)) {
    			
    			item.click();
    			break;
    		}
    		
    	}
    }
    
    public void viewProducts(String product) {
    	
    	List<WebElement> lists=driver.findElements(Products);
    	
    	for(WebElement item:lists) {
    		
    		if(item.getText().equalsIgnoreCase(product)) {
    			
    			
    			item.findElement(viewProduct).click();
    			break;
    		}
    	}
    	
    }
    public void selectProduct() {
    	
    	driver.findElements(ViewProduct).get(3).click();
    	
    	
    }
    
    public void continueShopping() {
    	
    	driver.findElement(continueshopping).click();
    }
    
    
    public void addToCartButton(String name) {
    	
    	List<WebElement> lists=driver.findElements(validateproductname);
    	
    	for(WebElement item: lists) {
    		
    		if(item.getText().equalsIgnoreCase(name)) {
    			
    			item.findElement(ADDTOCART).click();
    			break;
    			
    		}
    	}
    	
    }
    
    public String getQuantity() {
    	
    	return driver.findElement(validatequantity).getText();
    }
    
    public void viewCartbutton() {
    	
    	driver.findElement(ViewCart).click();
    }
   public void addtocartbutton() {
	   
	   driver.findElement(AddToCart).click();
	   
	   
   }
    
    public void clickSearch(){
    	
    	 driver.findElement(searchbutton).click();
    	 JavascriptExecutor js = (JavascriptExecutor) driver;
     	js.executeScript("window.scrollBy(0,600)");
    	}
    
    
   public void Search(String product){
    	
    	 driver.findElement(searchbox).sendKeys(product);
    	}
    
    public void AddProductbutton(){
    	
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,500)");
    	
    	 driver.findElements(button).get(0).click();
    	}
    
   public String ProductName(){
    	
    	  return driver.findElement(productname).getText();
    	}
   
   public WebElement getProductName(){
   	
  	 return driver.findElement(validateproductname);
  	}
   
   public WebElement Category(){
   	
   	 return driver.findElements(productinfo).get(0);
   	}
   
   public WebElement ProductPrice(){
   	
  	 return driver.findElement(price);
  	} 
    
   public WebElement Quantity(){
	   	
	  	 return driver.findElement(quantity);
	  	} 
   
   public void setQuantity(String Quantity){
	   
	   WebDriverWait wait = new WebDriverWait(driver, 10);
	   wait.until(ExpectedConditions.visibilityOfElementLocated(quantity));
	   	
	  	  driver.findElement(quantity).clear();
	  	  driver.findElement(quantity).sendKeys(Quantity);
	  	 
	  	}
   
   public WebElement Availability(){
	   	
	   return driver.findElements(productinfo).get(1);
	   	}
   
   public WebElement Condition(){
	   	
	   	 return driver.findElements(productinfo).get(2);
	   	}
   public WebElement Brand(){
	   	
	   	return driver.findElements(productinfo).get(3);
	   	}   
   
}
