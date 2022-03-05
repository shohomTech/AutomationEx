package pageObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AccountCreationPage{
	
	
	public WebDriver driver;
	private Select s;
	private JavascriptExecutor js;
	
	
	
public AccountCreationPage(WebDriver driver) {
		
		this.driver=driver;
		
	}
	
	
	 private By text=By.xpath("//*[text()='Enter Account Information']");
	 private By radiobutton=By.xpath("//*[@value='Mr']");
	 private By name=By.xpath("//*[@data-qa='name']");
	 private By email=By.xpath("//*[@data-qa='signup-email']");
	 private By password=By.cssSelector("#password");
	 private By checkbox1=By.cssSelector("#newsletter");
	 private By checkbox2=By.cssSelector("#optin");
	 private By Firstname=By.cssSelector("#first_name");
	 private By Lastname=By.cssSelector("#last_name");
	 private By company=By.cssSelector("#company");
	 private By address=By.xpath("//*[@data-qa='address']");
	 private By state=By.cssSelector("#state");
	 private By city=By.cssSelector("#city");
	 private By zipcode=By.cssSelector("#zipcode");
	 private By mobileno=By.cssSelector("#mobile_number");
	 private By button=By.xpath("//*[@data-qa='create-account']");
	 private By date=By.cssSelector("#days");
	 private By month=By.cssSelector("#months");
	 private By year=By.cssSelector("#years");
	 private By country=By.cssSelector("#country");
	 private By message=By.xpath("//*[text()='Account Created!']");
	 private By continuebutton=By.xpath("//*[@data-qa='continue-button']");
	 private By usernametext=By.xpath("//*[@class='fa fa-user']/following-sibling::b");
	 private By logout=By.cssSelector("[href*='logout']");
	 private By Productslink=By.xpath("//*[text()=' Products']");
	 
	 
     public void Logout() {
		 
		 driver.findElement(logout).click();
	 }
	 
     public WebElement Usernametext() {
		 
		 return driver.findElement(usernametext);
	 }
	 
	 
	 public void Continuebutton() {
		 
		 driver.findElement(continuebutton).click();
	 }
	
	
	public WebElement validateText() {
		
		return driver.findElement(text);
	}
	
	public void successMessage() {
		
		driver.findElement(message);
	}

	public void buttonclick() {
		
		driver.findElement(button).click();
		
	}
	public WebElement checkradiobutton() {
		return driver.findElement(radiobutton);
		
	}
	
	public void Products() 
	{
		driver.findElement(Productslink).click();
		 }
	
    public void radiobutton(){
		
		
		driver.findElement(radiobutton).click();
	}
    public void password(String Password){
		
		
	 driver.findElement(password).sendKeys(Password);
	 js= (JavascriptExecutor)driver;
	 js.executeScript("window.scrollBy(0,500)");
	 
	}
    public void Checkbox(){
	
	
    	driver.findElement(checkbox1).click();
    	driver.findElement(checkbox2).click();
}
   
    public void FirstName(String FirstName){
	
    	driver.findElement(Firstname).sendKeys(FirstName);
}
    public void LastName(String LastName){
	
    	driver.findElement(Lastname).sendKeys(LastName);
    	js.executeScript("window.scrollBy(0,500)");
}
    public void Company(String Company){
	
    	driver.findElement(company).sendKeys(Company);
}
    public void Address(){
	
    	driver.findElement(address).sendKeys("23/8 RT Lane,P.O RP,ABC");
}
    public void State(String State){
	
    	driver.findElement(state).sendKeys(State);
    	js.executeScript("window.scrollBy(0,500)");
}
    public void City(String City){
	
    	driver.findElement(city).sendKeys(City);
}
    public void Zipcode(String Zipcode){
	
    	driver.findElement(zipcode).sendKeys(Zipcode);
}
    public void Mobile(String Mobile ){
	
    	driver.findElement(mobileno).sendKeys(Mobile);
}


	
	public void name(String Name){
		
		 driver.findElement(name).clear();
		 driver.findElement(name).sendKeys(Name,Keys.ENTER);
		 
		
	}
	public String email() {
		
		String ae=driver.findElement(email).getText();
		return ae;
	}
	
	
	public void date(String Date) {
		
		
		WebElement dates=driver.findElement(date);
		
		s= new Select(dates);
		s.selectByValue(Date);
	}
		
   public void month(String Month) {
	   
	   WebElement months=driver.findElement(month);
	   
	    s= new Select(months);
		s.selectByVisibleText(Month);
   }
	
	public void year(String Year) {
		WebElement years=driver.findElement(year);
		
		s= new Select(years);
		 s.selectByValue(Year);
		
	}
	
	public void country(String Country) {
		
		WebElement countrylist=driver.findElement(country);
		
		s=new Select(countrylist);
		s.selectByValue(Country);
		
	}
	
}
