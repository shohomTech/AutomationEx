package pageObjectRepository;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage{
	
	
	public WebDriver driver;
	
public ContactPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//*[@data-qa='name']")
	private WebElement Namebox;
	
	@FindBy(xpath="//*[@data-qa='email']")
	private WebElement Emailbox;
	
	@FindBy(xpath="//*[text()='Get In Touch']")
	private WebElement Textmsg;
	
	
	@FindBy(xpath="//*[@data-qa='subject']")
	private WebElement subject;
	
	
	@FindBy(xpath="//*[@type='file']")
	private WebElement File;
	
	@FindBy(id="message")
	private WebElement Messagebody;
	
	
	
	@FindBy(xpath="//*[@data-qa='submit-button']")
	private WebElement submit;
	
	
	
	@FindBy(xpath="//*[@class='contact-form']/div[2]")
	private WebElement SuccessMsg;
	
	
	
	@FindBy(xpath="//div[@id='form-section']//*[text()=' Home']")
	private WebElement Homebutton;
	
    public WebElement validateText(){
    	
    	return Textmsg;
    	}
    
   public void navigateToHome(){
    	
    	Homebutton.click();    	
    	} 
   
   public WebElement validateSuccessMsg(){
    	
    	return SuccessMsg;
    	}
    
    
   public void Submit(){
    	
	   submit.click();
    	}
    

    public void uploadFile(){
    	
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].style.display='block';", File);
    	
    	File.sendKeys("D:\\CV.docx");;
    	}
    
   public void Name(String name){
    	
    	 Namebox.sendKeys(name);
    	}
   public void Email(String email){
   	
	   Emailbox.sendKeys(email);
  	}
  
   public void setSubject(String sub){
	   	
	   subject.sendKeys(sub);
  	}
   public void setMessage(String body){
	   	
	   Messagebody.sendKeys(body);
  	}
    
}
