package com.vtiger.Tc;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC002_CreateOrganisation {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[.='Organizations']")).click();
		String orgN = "LT5";
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgN);
		Select sel = new Select(driver.findElement(By.name("industry")));
		sel.selectByValue("Engineering");
		Select sel1=new Select(driver.findElement(By.name("accounttype")));
		sel1.selectByIndex(6);
		Select sel2=new Select (driver.findElement(By.name("rating")));
		sel2.selectByVisibleText("Active");
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[.='Organizations']")).click();
		driver.findElement(By.name("search_text")).sendKeys(orgN);
		Select sel3=new Select(driver.findElement(By.id("bas_searchfield"))); 
		sel3.selectByVisibleText("Organization Name");
		Thread.sleep(2000);
		driver.findElement(By.name("submit")).click();
		Thread.sleep(3000);
		String val = driver.findElement(By.xpath("//a[@title='Organizations']")).getText();
		if(val.equals(orgN))
		{

			System.out.println("TC Pass");
		}
		else 
		{

			System.out.println("TC Fail");
		}
		WebElement image=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(image).build().perform();
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		driver.close();
	}
}
