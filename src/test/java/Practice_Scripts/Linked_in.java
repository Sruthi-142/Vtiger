package Practice_Scripts;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Linked_in {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://business.linkedin.com/marketing-solutions");
		driver.findElement(By.xpath("//a[contains(text(),'About')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Cookie Policy')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Privacy Policy')]")).click();
		driver.findElement(By.xpath("//a[contains(text(), 'User Agreement')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Accessibility')]")).click();
		Set<String> all = driver.getWindowHandles();
		String titles;
		for(String singlewin:all) {
			 titles = driver.switchTo().window(singlewin).getTitle();
			if(titles.equals("About LinkedIn")) 
			{
		System.out.println(titles);
		break;
		
		}
			
	}
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.xpath("//p[contains(text(),'About LinkedIn')]")).getText());
	

}
}
