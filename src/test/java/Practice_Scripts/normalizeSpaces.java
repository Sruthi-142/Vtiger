package Practice_Scripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class normalizeSpaces {

	public static void main(String[] args) throws InterruptedException
	{
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.icc-cricket.com");
	driver.findElement(By.xpath("//ul//div[normalize-space()=\"ICC Events\"]")).click();
	String Text=driver.findElement(By.xpath("//ul//a[.='ICC Cricket World Cup']")).getText();
	System.out.println(Text);
	if (Text.equalsIgnoreCase("ICC Cricket World Cup"))
			{
		System.out.println("TC PASS");
			}
	else 
	{
		System.out.println("TC FAIL");
	}
	
	driver.close();
	}

}
