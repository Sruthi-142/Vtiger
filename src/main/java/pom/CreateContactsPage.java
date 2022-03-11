package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactsPage
{
	WebDriver driver;
@FindBy(name="salutationtype")
private WebElement FirstNameDD;

@FindBy(name="firstname")
private WebElement FirstnameTxtbx;

@FindBy(name="lastname")
private WebElement LastnametTxtBx;

@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
private WebElement PlusImgOrgName;

@FindBy(xpath="//input[@title='Save [Alt+S]']")
private WebElement SaveBtn;

public WebElement getFirstNameDD() {
	return FirstNameDD;
}

public WebElement getFirstnameTxtbx() {
	return FirstnameTxtbx;
}

public WebElement getLastnametTxtBx() {
	return LastnametTxtBx;
}

public WebElement getPlusImgOrgName() {
	return PlusImgOrgName;
}

public WebElement getSaveBtn() {
	return SaveBtn;
}
public CreateContactsPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}


}
