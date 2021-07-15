package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ResetPasswordPage 
{

	public WebDriver driver;
	
	public ResetPasswordPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//**************************************Elements**************************************	
	
	By SectionHeader = By.xpath("//h1[normalize-space()='Reset Password']");
	
	
	
	//**************************************Methods**************************************
	
	public void verifySectionheader()
	{
		Assert.assertEquals(driver.findElement(SectionHeader).getText(), "Reset Password");
	}
}
