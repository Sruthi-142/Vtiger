package com.vtiger.Tc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC001_CreateOrganisation {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		driver.manage().window().maximize();
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[.='Organizations']")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		 String orgname = "Suresh";
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[.='Organizations']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(orgname);
		Select select = new Select(driver.findElement(By.id("bas_searchfield")));
		select.selectByVisibleText("Organization Name");
		
		driver.findElement(By.name("submit")).click();
		
		WebElement value = driver.findElement(By.xpath("//a[@title='Organizations']"));
		if(value.equals(orgname)) 
		{
			System.out.println("TC Pass");
			
		}
		else 
		{
		System.out.println("TC Fail");
	}
		WebElement simage = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions ac=new Actions(driver);
		ac.moveToElement(simage).build().perform();
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		driver.close();
		
		

}
}
