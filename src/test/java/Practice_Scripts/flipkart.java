package Practice_Scripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class flipkart {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		driver.findElement(By.name("q")).sendKeys("lg 55 led smart tv",Keys.ENTER);
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[@class='_2kHMtA' and @data-tkid='cc7d6875-c2d3-4d8f-8313-a19ff7b1cddb.TVSFUMW3HNWQ3UKE.SEARCH']//descendant::div[@class='_24_Dny']")).click();
		driver.findElement(By.name("q")).sendKeys("sony 55 led smart tv",Keys.ENTER);
		driver.findElement(By.xpath("//div[@class='_2kHMtA' and @data-tkid='6a44dccb-f072-4ffe-a94a-176dbea708f8.TVSG4CNBA5Z4TQNS.SEARCH']//descendant::div[@class='_24_Dny']")).click();
		driver.findElement(By.xpath("//span[@class='_3hShhO']")).click();

	}

}
