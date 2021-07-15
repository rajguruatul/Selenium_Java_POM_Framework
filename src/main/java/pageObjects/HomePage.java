package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage
{

	public WebDriver driver;	
	
	public HomePage(WebDriver driver) 
	{
	
		this.driver=driver;
	}
	
//**************************************Elements**************************************	
	By loginLink =      By.xpath("//span[normalize-space()='Login']");
	By title=           By.xpath("//title");
	By featureTitle =   By.xpath("//h2[normalize-space()='Featured Courses']");
	By navigationBar =  By.xpath("//nav[@class='navbar-collapse collapse']/ul/li/a");
	



//**************************************Methods**************************************

	
	public LoginPage getLogin()
	{
		driver.findElement(loginLink).click();
		return new LoginPage(driver);
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	
	public WebElement getFeatureTitle()
	{
		return driver.findElement(featureTitle);
	}
	
	public WebElement getNavigationBar()
	{
		return driver.findElement(navigationBar);
	}
	
	
}
