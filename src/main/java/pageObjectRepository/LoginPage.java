package pageObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage{
	
	
	public WebDriver driver;
	
public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="login1")
	private WebElement username;
	
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement mailSignIn;
	
	
	@FindBy(css=".rd_logout")
	private WebElement logOut;
	
	@FindBy(xpath="//*[text()='New User Signup!']")
	private WebElement SignUpText;
	
	@FindBy(xpath="//*[@type='text']")
	private WebElement name;
	
	@FindBy(xpath="//*[@data-qa='signup-email']")
	private WebElement signupemail;
	
	@FindBy(xpath="//*[@data-qa='signup-name']")
	private WebElement signupname;
	
	@FindBy(xpath="//*[@data-qa='login-email']")
	private WebElement loginemail;
	
	@FindBy(xpath="//*[@data-qa='signup-button']")
	private WebElement signup;
	
	@FindBy(xpath="//*[text()='Login to your account']")
	private WebElement LoginText;
	
	
	@FindBy(xpath="//*[text()='Login']")
	private WebElement Loginbutton;
	
	@FindBy(xpath="//*[@data-qa='login-password']")
	private WebElement Password;
	
	
	@FindBy(xpath="//*[text()='Your email or password is incorrect!']")
	private WebElement ErrorMsg;
	
	@FindBy(xpath="//*[text()='Email Address already exist!']")
	private WebElement errormsg;
	
	@FindBy(css="a[href*='cart']")
	private WebElement CartLink;
	
	
	
	
	public WebElement ExistinguserErrmsg() 
	{
		
		return errormsg;
		
	}
	
	public CartPage Cart() 
	{
		
		CartLink.click();
		 
		 return new CartPage(driver);
		 }
	
	public void SignUpName(String name) {
		
		 signupname.sendKeys(name);
	}
	
	public WebElement username() 
	{
		
		return username;
		
	}
	
	
	public WebElement getMessage() 
	{
		
		return ErrorMsg;
		
	}
	
	public void Name(String Name) 
	{
		
		 name.sendKeys(Name,Keys.ENTER);
		
	}
	
	public void SignUpEmail(String email) 
	{
		
		signupemail.sendKeys(email);
		
	}
	
	public void LoginEmail(String email) 
	{
		
		loginemail.sendKeys(email,Keys.ENTER);
		
	}
	
	public void SignIn() 
	{
		
		  signup.click();;
		
	}
	
	public WebElement LoginText() 
	{
		
		return LoginText;
		
	}
	
	public void Loginbutton()
	{
		Loginbutton.click();
		
	}
	
	public WebElement VisibleText() 
	{
		
		return SignUpText;
		
	}
	public WebElement password() 
	{
		
		return password;
		
	}
	public void getPassword(String password) 
	{
		
		 Password.sendKeys(password);
		
	}
	
	public void mailSignIn()
	{
		 mailSignIn.click();
		
	}
	public WebElement logOut()
	{
		return logOut;
		
	}
	

}
