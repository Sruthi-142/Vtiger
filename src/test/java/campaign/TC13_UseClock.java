package campaign;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC13_UseClock {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		WebElement mor=driver.findElement(By.xpath("//a[.='More']"));
		Actions ac= new Actions(driver);
		ac.moveToElement(mor).build().perform();
		driver.findElement(By.name("Campaigns")).click();
		driver.findElement(By.xpath("//img[@alt=\"Show World Clock...\"]")).click();
		WebElement WCAct=driver.findElement(By.id("theClockLayer"));
		WebElement WCExp=driver.findElement(By.id("theClockLayer"));
		if(WCExp.equals(WCAct))
		{
			System.out.println("TC Pass");
		}
		else 
		{
			System.out.println("TC Fail");
		}
		driver.close();
		
		
		
		
		 


	}

}
