package Practice_Scripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.crm.ty.IAutoConstants;
import com.crm.ty.JavaUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC03_javaUtil {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver;
		FileInputStream fis=new FileInputStream(IAutoConstants.propfilepath);
		Properties prop=new Properties();
		prop.load(fis);
		String browser=prop.getProperty("browser");
		if(browser.equalsIgnoreCase("Chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Firefox")) 
		{
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("Edge")) 
		{
			driver=new EdgeDriver();
		}
		else 
		{
			driver=new FirefoxDriver();
		}
		driver.get(prop.getProperty("URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("user_name")).sendKeys(prop.getProperty("UN"));
		driver.findElement(By.name("user_password")).sendKeys(prop.getProperty("PWD"));
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//a[.='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		Thread.sleep(3000);
		
		Select sel=new Select(driver.findElement(By.xpath("//select[@name=\"salutationtype\"]")));

		sel.selectByVisibleText("Dr.");
		FileInputStream fisx=new FileInputStream(IAutoConstants.excelpath);
		String fn=WorkbookFactory.create(fisx).getSheet("Sheet2").getRow(1).getCell(0).getStringCellValue();
		FileInputStream fisx1=new FileInputStream(IAutoConstants.excelpath);
		String ln=WorkbookFactory.create(fisx1).getSheet("Sheet2").getRow(1).getCell(1).getStringCellValue();
		JavaUtil jv=new JavaUtil();
		String orgname = jv.fakeCompanyName();
		int randomnumber=jv.generateRandomNumber();
		driver.findElement(By.name("firstname")).sendKeys(fn);
		driver.findElement(By.name("lastname")).sendKeys(ln);
		JavaUtil jv1=new JavaUtil();
		String firstname=jv.fakefirstName();
		String lastname=jv.fakelastName();
		
		driver.findElement(By.xpath("//input[@name='account_name']/../img")).click(); 
		Set<String> gw = driver.getWindowHandles();
		  Iterator<String> itr = gw.iterator();
		  String par = itr.next();
		  String chil = itr.next();
		  driver.switchTo().window(chil);
		  driver.findElement(By.id("search_txt")).sendKeys(orgname);
		  Select sel2=new Select(driver.findElement(By.name("search_field")));
		  sel2.selectByVisibleText("Organization Name");
		  driver.findElement(By.name("search")).click();
		  driver.findElement(By.id("1")).click();
		  driver.switchTo().window(par);
		  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click(); 
		  driver.findElement(By.xpath("//a[.='Contacts']")).click();
		  driver.findElement(By.xpath("//input[@name=\"search_text\"]")).sendKeys(fn);
		Select sel3=new Select(driver.findElement(By.xpath("//select[@id='bas_searchfield']")));
		sel3.selectByVisibleText("Organization Name");
		driver.findElement(By.xpath("//input[@name=\"submit\"]")).click();
		String value = driver.findElement(By.xpath("//a[@title=\"Organizations\"]")).getText();
		if(value.equalsIgnoreCase(orgname)) 
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
