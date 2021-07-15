package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseTest 
{

	public WebDriver driver;
	public Properties prop;
	public String url;
	public int waitTime;
	public String browser;
	
//*************************Initialize Browser*************************
	public WebDriver initializeDriver() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir") + "/src/main/java/resources/data.properties");
		
		prop.load(fis);
		browser = prop.getProperty("browser");
		url = prop.getProperty("url");
		waitTime=Integer.parseInt(prop.getProperty("waitTime"));
		System.out.println("Browser selects is: "+browser);
		
		
		if(browser.equals("chrome"))
		{
			//WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
			driver=new ChromeDriver();
			
		}
		else if (browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();			
		}
		else if(browser.equals("IE"))
		{
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
		return driver;
	}
	
	
//*************************Screenshot Capture *************************	
	public String takeScreenshot(String testMethodName, WebDriver driver)
	{
		String screenName= testMethodName+"_"+System.currentTimeMillis()+ ".png";
		String destinationFile = System.getProperty("user.dir")+"/target/Screenshots/"+screenName;
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try
		{
			FileHandler.copy(src, new File(destinationFile));
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
		
		return destinationFile;

	}
}
