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

public class TC15_SecndDD {

	public static void main(String[] args) throws InterruptedException {
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
		driver.findElement(By.xpath("//a[.='Go to Advanced Search']"));
		Select sel =new Select (driver.findElement(By.name("fop0")));
		List<WebElement> all = sel.getOptions();
		System.out.println(all);
		Thread.sleep(2000);
		WebElement img =driver.findElement(By.xpath("//img[@src='\"themes/softed/images/user.PNG']"));
		Actions ac1=new Actions(driver);
		ac1.moveToElement(img).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		Thread.sleep(3000);
		driver.close();
	}

}
