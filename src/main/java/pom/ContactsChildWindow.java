package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsChildWindow 
{
    WebDriver driver;
	@FindBy(name="search_text") private WebElement SearchTxtBx;

	@FindBy(name="search_field") private WebElement InDD;
	@FindBy(xpath="//a[@id=\"1\"]") private WebElement selectognName;
	
	public WebElement getSelectognName() {
		return selectognName;
	}

	@FindBy (name="search") private WebElement SearchNowBtn;
	@FindBy(xpath="//a[.='Organization Name']") private WebElement Orgname;

	public WebElement getSearchTxtBx() {
		return SearchTxtBx;
	}

	public WebElement getInDD() {
		return InDD;
	}

	public WebElement getSearchNowBtn() {
		return SearchNowBtn;
	}
	

	public WebElement getOrgname() {
		return Orgname;
	}

	public ContactsChildWindow(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
}
