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

public class RecommendedItemsPage {
	
	

	
public WebDriver driver;


    private By FooterSection=By.xpath("//div[@class='recommended_items']");
    private By ActiveItems=By.xpath("div/div/div");
    private By products=By.xpath("div/div/div/div/p");
    private By addtocart=By.xpath("following-sibling::a");
    private By ViewCart=By.cssSelector("div[class='modal-body'] a");
	private By rightClick=By.cssSelector("a[class='right recommended-item-control']");

	
	
   public RecommendedItemsPage(WebDriver driver) {
		
		this.driver=driver;
		
		
	}
   
   
   public void selectItemsandAddtoCart(String product) {
	   
	   
	   
	   WebElement footerDriver=driver.findElement(FooterSection);
	   
	   WebElement activeElements=footerDriver.findElement(ActiveItems);
	   
	   if(!activeElements.getAttribute("class").contains("item active")) {
		   
		   driver.findElement(rightClick).click();
	   }
	   
	   List<WebElement> lists=activeElements.findElements(products);
	   
	   for(WebElement item: lists) {
		   
		   if(item.getText().equalsIgnoreCase(product)) {
			   
			   item.findElement(addtocart).click();
			   driver.findElement(ViewCart).click();
			   break;
		   }
	   }
   }
   
   
	
}
	


