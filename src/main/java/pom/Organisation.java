package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organisation {
	WebDriver driver;

	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']") private WebElement adminimage;
	@FindBy(name="search_text") private WebElement searchbox;
	@FindBy(name="submit") private WebElement searchnowbtn;
	@FindBy(id="bas_searchfield") private WebElement Indropdown;
	@FindBy(xpath="//a[@title='Organizations']") private WebElement organisationname;
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getorganisationname() {
		return organisationname;
	}
	public WebElement getAdminimage() {
		return adminimage;
	}
	public WebElement getSearchbox() {
		return searchbox;
	}
	public WebElement getSearchnowbtn() {
		return searchnowbtn;
	}
	public WebElement getIndropdown() {
		return Indropdown;
	}
	public Organisation(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

}
