package Practice_Scripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class assert_Class {
	public WebDriver driver;
	@Test
	public void assert_Validation()
	{
		System.out.println("Launch Browser");
		System.out.println("Get URL");
		System.out.println("Login");
		
		SoftAssert assert1=new SoftAssert();
		assert1.assertEquals("AAAA", "RRRR");
		
		
//		Assert.assertEquals("Pavan", "Hyd");
		
		System.out.println("Test step 1");
		System.out.println("Test Step 2");
		System.out.println("Test step 3");
		System.out.println("Test step 4");
		System.out.println("Test step 5");
		System.out.println("Test step 6");
		System.out.println("Logout");
		System.out.println("close Browser");
		assert1.assertEquals("HYSS","HYD");
		
	}
		
	}

