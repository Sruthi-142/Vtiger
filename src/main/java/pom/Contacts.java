package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contacts {
	WebDriver driver;
	@FindBy(name="search_text") private WebElement SearchForTextBox;
	
	@FindBy(id="bas_searchfield") private WebElement InDD;
	
	@FindBy(name="submit") private WebElement SearchNowBtn;
	
	@FindBy (xpath="//img[@src='themes/softed/images/btnL3Add.gif']") private WebElement PlusImage;
	
	@FindBy(xpath="//input[@class='txtBox']") private WebElement Searchfor;

	public WebElement getSearchForTextBox() {
		return SearchForTextBox;
	}

	public WebElement getInDD() {
		return InDD;
	}

	public WebElement getSearchNowBtn() {
		return SearchNowBtn;
	}

	public WebElement getPlusImage() {
		return PlusImage;
	}
	public WebElement getSearchfor() {
		return Searchfor;
	}

	public Contacts(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	

}
