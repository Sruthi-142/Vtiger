

package com.vtiger.Tc;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC003_Contacts {
public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[.='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		Thread.sleep(3000);
		
		Select sel=new Select(driver.findElement(By.xpath("//select[@name=\"salutationtype\"]")));

		sel.selectByVisibleText("Dr.");
		String fn = "Sruti";
		String ln = "R";
		String orgN = "RAMKI";
		driver.findElement(By.name("firstname")).sendKeys(fn);
		driver.findElement(By.name("lastname")).sendKeys(ln);
		
		driver.findElement(By.xpath("//input[@name='account_name']/../img")).click(); 
		Set<String> gw = driver.getWindowHandles();
		  Iterator<String> itr = gw.iterator();
		  String par = itr.next();
		  String chil = itr.next();
		  driver.switchTo().window(chil);
		  driver.findElement(By.id("search_txt")).sendKeys(orgN);
		  Select sel2=new Select(driver.findElement(By.name("search_field")));
		  sel2.selectByVisibleText("Organization Name");
		  driver.findElement(By.name("search")).click();
		  driver.findElement(By.id("1")).click();
		  driver.switchTo().window(par);
		  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click(); 
		  driver.findElement(By.xpath("//a[.='Contacts']")).click();
		  driver.findElement(By.xpath("//input[@name=\"search_text\"]")).sendKeys(fn);
		Select sel3=new Select(driver.findElement(By.xpath("//select[@id='bas_searchfield']")));
		sel3.selectByVisibleText("Organization Name");
		driver.findElement(By.xpath("//input[@name=\"submit\"]")).click();
		String value = driver.findElement(By.xpath("//a[@title=\"Organizations\"]")).getText();
		if(value.equalsIgnoreCase(orgN)) 
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


