package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.baseTest;

public class LoginPage extends baseTest
{

	public WebDriver driver;

	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
//**************************************Elements**************************************		
	By email = By.xpath("//input[@id='user_email']");
	By password = By.xpath("//input[@id='user_password']");
	By loginButton = By.xpath("//input[@name='commit']");
	By forgotPasswordLink = By.xpath("//a[normalize-space()='Forgot Password?']");

	
//**************************************Methods**************************************		
	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement getLoginButton()
	{
		return driver.findElement(loginButton);
	}
	
	public ResetPasswordPage clickOnForgotPasswordLink()
	{
		driver.findElement(forgotPasswordLink).click();
		 return new ResetPasswordPage(driver);
	}
}
