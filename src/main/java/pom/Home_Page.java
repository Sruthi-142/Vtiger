package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {
	
	WebDriver driver;
	
	@FindBy(xpath="//a[.='Leads']")
	private WebElement leadslink;
	
	@FindBy(xpath="//a[.='Organizations']")
	private WebElement Organisationlink;
	
	@FindBy(xpath="//a[.='Contacts']")
	private WebElement Contactslink;
	
	@FindBy (xpath="//a[.='Opportunities']")
	private WebElement Opportunitieslink;
	
	

	public WebElement getLeadslink() {
		return leadslink;
	}

	public WebElement getOrganisationlink() {
		return Organisationlink;
	}

	public WebElement getContactslink() {
		return Contactslink;
	}

	public WebElement getOpportunitieslink() {
		return Opportunitieslink;
	}
	
	public Home_Page( WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
}
