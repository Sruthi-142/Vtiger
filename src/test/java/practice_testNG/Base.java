package practice_testNG;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class Base {

	@BeforeSuite
	public void bs()
	{
		System.out.println("BeforeSuite is Executed");
	}
	@AfterSuite
	public void as()
	{
		System.out.println("AfterSuite is Executed");
	}
	@BeforeTest
	public void bt() 
	{
	System.out.println("beforeTest is executed");	
	}
	@AfterTest
	public void at()
	{
		System.out.println("After test is executed");
	}
	@BeforeClass
	public void bc() {
		System.out.println("Before class is executed");
	}
	@AfterClass
	public void ac() {
		System.out.println("After class is eexecuted");
	}
	@BeforeMethod
	public void bm() {
		System.out.println("BeforeMethod is executed");
	}
	@AfterMethod
	public void am() {
		System.out.println("AfterMethod is executed");
	}
}
