package Practice_Scripts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class lenskart {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.lenskart.com");
		Thread.sleep(3000);
		driver.findElement(By.name("q")).click();
	 List<WebElement> all = driver.findElements(By.xpath("//ul[@class='trending_list menu-link']/li"));
	 for(WebElement Element:all) 
	 {
	String name=Element.getText();	
	System.out.println(name);
	 }
		driver.close();

	}
	

}
