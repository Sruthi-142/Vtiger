package com.crm.ty;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
/*
 * This method is used for code reuseability
 */
public class WebDriverUtil {
	/*
	 * This method is used for Synchronising
	 * @para 
	 */
	public void implicitlywait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}
	/*
	 * this method  is used to select element from a dropdown by visible text
	 * @
	 */
	public void Selectfromdd(WebElement element,String text) 
	{
		Select select =new Select(element);
		select.selectByVisibleText(text);
	}
	/*
	 * this method  is used to select element from a dropdown by index
	 */
	public void Selectfromdd(WebElement element,int index) 
	{
		Select select =new Select(element);
		select.selectByIndex(index);
	}
	/*
	 * This method is use to moveto an element by using actions class
	 * @author                                                                                                                                                                                                                                                                                                                                                       
	 */
	public void movetoElement(WebDriver driver,WebElement element )
	{
		Actions ac=new Actions(driver);
		ac.moveToElement(element).build().perform();
	}
	/*
	 * this method is used to handle the windows by using getWindowHandles()
	 */
	public void windowHandles(WebDriver driver, String title)
	{
		Set<String>all=driver.getWindowHandles();
		for(String singleWindow:all)
		{
			String currenttitl = driver.switchTo().window(singleWindow).getTitle();
			if(currenttitl.contains(title))
			{
				break;
			}
		}
	}
	/*
	 * This method is used to switch your control from one frame to the required frame on the web page
	 * @param driver
	 * @param index
	 * @author Sruthi
	 */
	public void switchframe(WebDriver driver, int index) 
	{
		driver.switchTo().frame(index);
	}
	public void switchframe(WebDriver driver, String nameorid) 
	{
		driver.switchTo().frame(nameorid);
	}
	public void switchframe(WebElement element, WebDriver driver) 
	{
		driver.switchTo().frame(element);
	}
	/*
	 * this method is used to handle for accepting the alert popups
	 * @param driver
	 */
	public void alertaccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/*
	 * this method is used to handle for dismissing the alert popups
	 * @param driver
	 */
	public void alertdismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/*
	 * this method is used to get the text from the alert popup
	 * @param driver
	 * @return
	 */
	public String getalertText(WebDriver driver) {
		return driver.switchTo().alert().getText();

	}
}

