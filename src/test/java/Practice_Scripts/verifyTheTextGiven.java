package Practice_Scripts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class verifyTheTextGiven {
	public static void main(String args[]) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.amazon.in");
    driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus9T");
	WebElement SearchBox=driver.findElement(By.id("twotabsearchtextbox"));
	Thread.sleep(2000);
	String Sent=SearchBox.getAttribute("value");
	System.out.println(Sent);
	driver.close();
    }
	
}
