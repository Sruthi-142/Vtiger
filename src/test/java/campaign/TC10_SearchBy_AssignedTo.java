package campaign;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC10_SearchBy_AssignedTo {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		WebElement mor=driver.findElement(By.xpath("//a[.='More']"));
		Actions ac=new Actions(driver);
		ac.moveToElement(mor).build().perform();
		driver.findElement(By.name("Campaigns")).click();
		Select sel=new Select(driver.findElement(By.name("search_field")));
		sel.selectByValue("assigned_user_id");
		driver.findElement(By.name("search_text")).sendKeys("Administrator");
		driver.findElement(By.name("submit")).click();
		WebElement reslt=driver.findElement(By.xpath("//td[contains(text(),'You can Create a')]"));
		WebElement popup=driver.findElement(By.xpath("//td[contains(text(),'You can Create a')]"));
		if(reslt.equals(popup))
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

