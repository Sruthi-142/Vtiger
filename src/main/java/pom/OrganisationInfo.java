package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationInfo {
	WebDriver driver;
	
	@FindBy(name="accountname")
	private WebElement OrganisationName;
	
	@FindBy(name="industry")
	private WebElement IndustryDD;
	
	@FindBy(name="accounttype")
	private WebElement TypeDD;
	
	@FindBy(name="rating")
	private WebElement RatingDD;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	public WebElement getOrganisationName() {
		return OrganisationName;
	}

	public WebElement getIndustryDD() {
		return IndustryDD;
	}

	public WebElement getTypeDD() {
		return TypeDD;
	}

	public WebElement getRatingDD() {
		return RatingDD;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	

	public OrganisationInfo(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	

}
