package com.crm.geneics;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.crm.ty.FileLibrary;
import com.crm.ty.WebDriverUtil;

import io.github.bonigarcia.wdm.WebDriverManager;
import pom.Login_Page;

public class Base_class_Test {

	public WebDriver driver;
	public FileLibrary fl=new FileLibrary();
	public WebDriverUtil webutil=new WebDriverUtil();

	@BeforeSuite
	public void makeConnections()
	{
		System.out.println("==BeforeSuite==");
		System.out.println("==DB Connection==");
	}
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("==BeforeTest==");
	}
	//@Parameters("browser")
	@BeforeClass
	public void launchbrowser() throws IOException
	{
		
		System.out.println("==launchBrowser==");

		String browser=fl.readPropertyData("browser");
		if(browser.equalsIgnoreCase("Chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) 
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();	
		}
		else if(browser.equalsIgnoreCase("edge"))
		{

			driver=new EdgeDriver();
		} 
		else 
		{
			driver=new ChromeDriver();
		}
	}
	@BeforeMethod
	public void loginToApp() throws IOException {
		driver.get(fl.readPropertyData("URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Login_Page login=new Login_Page(driver);
		login.getUsertxtbx().sendKeys(fl.readPropertyData("UN"));
		login.getPwdtxtbx().sendKeys(fl.readPropertyData("PWD"));
		login.getLoginbtn().click();

	}
	@AfterMethod
	public void logout()
	{
		WebElement element=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));


		webutil.movetoElement(driver,element);

		driver.findElement(By.xpath("//a[.='Sign Out']")).click();

	}
	@AfterClass
	public void closebrowser() 
	{
		driver.close();
	}
	@AfterTest
	public void aftertest() {
		System.out.println("==AfterTest==");
	}	
	@AfterSuite
	public void aftersuite() {
		System.out.println("==AfterSuite==");
	}

}


