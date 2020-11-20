package com.vtiger.genericLib;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.vtiger.objectRepository.LoginPageMembers;



public class _01_finalVersionOfBaseClass {
	
	
	public static WebDriver driver;
	public DataStorage picker = new DataStorage();
	public SoftAssert soft = new SoftAssert();
	public WebDriverCommonUtils wutils = new WebDriverCommonUtils();
	
	@BeforeSuite
	public void cofigBS()
	{
		System.out.println(" DB connet");
	}
	@BeforeTest
	public void cofigBT()
	{
		System.out.println(" Before test case Dependency");
	}
	@BeforeClass
	public void cofigBC() throws IOException 
	{
//		String browservalue = picker.getDataFromproperty("browser");
//		if (browservalue.equalsIgnoreCase("chrome"))
//		{
//			System.setProperty("webdriver.chrome.driver", "./resourse/driver/chromedriver.exe");
//			driver = new ChromeDriver();
//		}
//		else if(browservalue.equalsIgnoreCase("firefox"))
//		{
//			driver = new FirefoxDriver();
//		}

	System.setProperty("webdriver.chrome.driver", "./src/main/resources/resourse/driver/chromedriver.exe");
	driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(picker.getDataFromproperty("url"));
		System.out.println("Lauch Browser");
	}
	
	
	// for crossBrowser exicution
	
//	@Parameters({"browserValue"})
//	@BeforeClass
//		public void cofigBC(String browserValue) throws IOException 
//	{
//		
//		System.out.println("bc is running");
//		if (browserValue.equalsIgnoreCase("chrome"))
//		{
//			System.setProperty("webdriver.chrome.driver", "./resourse/driver/chromedriver.exe");
//			driver = new ChromeDriver();
//		}
//		else if(browserValue.equalsIgnoreCase("firefox"))
//		{
//
//			System.setProperty("webdriver.gecko.driver", "./resourse/driver/geckodriver.exe");
//			  driver = new FirefoxDriver();
//		}
//
//	
//		
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
//		driver.get(picker.getDataFromproperty("url"));
//		System.out.println("Lauch Browser");
//	}
	@BeforeMethod
	public void cofigBM() throws IOException
	{
		// now not use this object to invoke and construr are not presen
		//LoginPageMembers login = new LoginPageMembers(driver);
		
		LoginPageMembers login = PageFactory.initElements(driver, LoginPageMembers.class);
		
		login.loginToApp(picker.getDataFromproperty("username"), picker.getDataFromproperty("password"));
		
		
//		login.getUsernameField().sendKeys(picker.getDataFromproperty("username"));
//		login.getPasswordField().sendKeys(picker.getDataFromproperty("password"));
//		login.getloginBtn().click();
		
//		driver.findElement(By.name("user_name")).
//		sendKeys(picker.getDataFromproperty("username"));
//		driver.findElement(By.name("user_password")).
//		sendKeys(picker.getDataFromproperty("password"));
//		driver.findElement(By.id("submitButton")).click();
		
		System.out.println(" Login done");
	}

	
	
	
	@AfterMethod
	public void cofigAM()
	{
		
		WebElement signOutDD = driver.findElement
				(By.xpath("//td[@class='genHeaderSmall']/following-sibling::td[1]"));
		Actions act = new  Actions (driver);
		act.moveToElement(signOutDD).perform();driver.findElement(By.linkText("Sign Out")).click();
		
		driver.close();
		System.out.println(" Logout done");
	}
	
	
	@AfterClass
	public void cofigAC()
	{
		System.out.println(" close browser");
		
	}
	
	@AfterTest
	public void cofigAT()//after test
	{
		System.out.println(" After test case dependency");
	}
	@AfterSuite
	public void cofigAS()
	{
		System.out.println(" DB dissconnet ");
	}
	

}
