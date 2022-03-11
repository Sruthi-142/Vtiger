package practice_scripts1;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.geneics.Base_class_Test;
import com.crm.ty.JavaUtil;
import com.crm.ty.WebDriverUtil;

import pom.Contacts;
import pom.ContactsChildWindow;
import pom.CreateContactsPage;
import pom.Home_Page;

public class TCC03_Contacts extends Base_class_Test {
	@Test(groups= {"smoke"})

	public void create_contact() throws EncryptedDocumentException, IOException, InterruptedException {
		Home_Page homepage=new Home_Page(driver);
		homepage.getContactslink().click();
		Contacts contacts=new Contacts(driver);
		contacts.getPlusImage().click();
		CreateContactsPage createcontactspage=new CreateContactsPage(driver);
		webutil.Selectfromdd(createcontactspage.getFirstNameDD(), 5);
		JavaUtil jv=new JavaUtil();
		String fn=jv.fakefirstName();
		String ln=jv.fakelastName();

		createcontactspage.getFirstnameTxtbx().sendKeys(fn);
		createcontactspage.getLastnametTxtBx().sendKeys(ln);
		createcontactspage.getPlusImgOrgName().click();
		Set<String> gw=driver.getWindowHandles();
		Iterator<String> itrt = gw.iterator();
		String  par = itrt.next();
		String child=itrt.next();
		driver.switchTo().window(child);
		ContactsChildWindow contactschildwindow=new ContactsChildWindow(driver);
		String orgname="vikky";
		contactschildwindow.getSearchTxtBx().sendKeys(orgname);

		webutil.Selectfromdd(contactschildwindow.getInDD(),"Organization Name");
		contactschildwindow.getSelectognName().click();


		driver.switchTo().window(par);
		createcontactspage.getSaveBtn().click();

		homepage.getContactslink().click();

		contacts.getSearchfor().sendKeys(fn);

		webutil.Selectfromdd(contacts.getInDD(), "First Name");
		contacts.getSearchNowBtn().click();




		Thread.sleep(3000);

		String value = driver.findElement(By.xpath("//a[@title=\"Contacts\"]")).getText();
		Assert.assertEquals(value, fn);
	}
	@Test(groups= {"regression"})
	public void createcontactWithouOrg() throws InterruptedException 
	{
		Home_Page homepage=new Home_Page(driver);
		homepage.getContactslink().click();
		Contacts contacts=new Contacts(driver);
		contacts.getPlusImage().click();
		CreateContactsPage createcontactspage=new CreateContactsPage(driver);
		webutil.Selectfromdd(createcontactspage.getFirstNameDD(), 5);
		JavaUtil jv=new JavaUtil();
		String fn=jv.fakefirstName();
		String ln=jv.fakelastName();

		createcontactspage.getFirstnameTxtbx().sendKeys(fn);
		createcontactspage.getLastnametTxtBx().sendKeys(ln);

		createcontactspage.getSaveBtn().click();

		homepage.getContactslink().click();

		contacts.getSearchfor().sendKeys(fn);

		webutil.Selectfromdd(contacts.getInDD(), "First Name");
		contacts.getSearchNowBtn().click();




		Thread.sleep(3000);

		String value = driver.findElement(By.xpath("//a[@title=\"Contacts\"]")).getText();
		Assert.assertEquals(value, fn);


	}
}


