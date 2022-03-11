package campaign;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC14_firstDD {

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
		Actions ac=new Actions(driver);
		ac.moveToElement(mor).build().perform();
		driver.findElement(By.name("Campaigns")).click();
		driver.findElement(By.xpath("//a[.=\"Go to Advanced Search\"]")).click();
		Select sel= new Select (driver.findElement(By.id("fcol0")));
		List<WebElement> expctd = sel.getOptions();
		List<WebElement> actl = sel.getOptions();
		if(expctd.equals(actl)) 
		{
			System.out.println("TC Pass");
			System.out.println(actl);
		}
		else 
		{
			System.out.println("TC Fail");
		}
		WebElement image=driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		Actions ac1=new Actions(driver);
		ac1.moveToElement(image).build().perform();
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		driver.close();
	}
}
