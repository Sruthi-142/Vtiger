package practice_testNG;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTripTest {
	public static void main(String args[]) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//body[@class='desktop in webp']")).click();
		
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		
		driver.findElement(By.xpath("//label[@for='fromCity']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@class='react-autosuggest__input react-autosuggest__input--open']")).sendKeys("Hyderabad");
		List<WebElement>fromall=driver.findElements(By.xpath("//ul[@role='listbox']/li"));
		
		
		
		
		for (WebElement fsingle : fromall)
		
		{
			String fact=fsingle.getText();
			System.out.println(fact);
			
			if(fact.contains("Hyderabad"))
			{
			  fsingle.click();
			  break;
			}
		}
		
		driver.findElement(By.xpath("//label[@for='toCity']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder=\"To\"]")).sendKeys("Vijayawada");
		
	List<WebElement>toall=driver.findElements(By.xpath("//ul[@role='listbox']/li"));
		for (WebElement tsingle : toall)
		{
			String tact=tsingle.getText();
			if(tact.contains("Vijayawada")) {
				tsingle.click();
				break;
			}
		}
		
	}

}
