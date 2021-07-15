package TestFramework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Connection.Base;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ResetPasswordPage;
import resources.baseTest;

public class LoginTest extends baseTest
{

	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		log.info("Driver intialized");
		driver.get(url);
		log.info("Navigated to HomePage : "+ url);
	}

	@Test
	public void EnterLoginDetails() throws IOException
	{
	
		HomePage homePageObj=new HomePage(driver);
		LoginPage loginPageObj = homePageObj.getLogin();
		
		loginPageObj.getEmail().sendKeys("testUser123");
		loginPageObj.getPassword().sendKeys("test password");
		loginPageObj.getLoginButton().click();
	
	}
	
	
	@Test
	public void ClickOnResetPassword() throws IOException
	{
	
		HomePage homePageObj=new HomePage(driver);
		
		LoginPage loginPageObj = homePageObj.getLogin();
		loginPageObj.getEmail().sendKeys("testUser123");
		loginPageObj.getPassword().sendKeys("test password");
		loginPageObj.getLoginButton().click();
		

		ResetPasswordPage resetPasswordPageObj = loginPageObj.clickOnForgotPasswordLink();
		resetPasswordPageObj.verifySectionheader();
	
	}
	

	
	@AfterTest
	public void teardown()
	{
		driver.close();
		log.info("Closing the Browser");
	}
	
}
