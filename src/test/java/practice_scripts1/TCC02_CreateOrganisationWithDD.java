package practice_scripts1;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.crm.geneics.Base_class_Test;
import com.crm.ty.JavaUtil;
import com.crm.ty.WebDriverUtil;

import pom.Home_Page;
import pom.Organisation;
import pom.OrganisationInfo;

public class TCC02_CreateOrganisationWithDD extends Base_class_Test {
	@Test
	public void createOrgWithDD() throws InterruptedException {


		Home_Page Homepage=new Home_Page(driver);
		Homepage.getOrganisationlink().click();
		Organisation organisation=new Organisation(driver);
		organisation.getAdminimage().click();
		JavaUtil jv=new JavaUtil();
		String orgname=jv.fakeCompanyName();
		OrganisationInfo organisationinfo=new OrganisationInfo(driver);
		organisationinfo.getOrganisationName().sendKeys(orgname);
		WebDriverUtil webdrivreutil=new WebDriverUtil();
		webutil.Selectfromdd(driver.findElement(By.name("industry")),"Construction");
		webutil.Selectfromdd(driver.findElement(By.name("accounttype")), 6);
		webutil.Selectfromdd(driver.findElement(By.name("rating")), "Active");
		Thread.sleep(3000);
		organisationinfo.getSaveBtn().click();
		Thread.sleep(3000);
		Homepage.getOrganisationlink().click();
		organisation.getSearchbox().sendKeys(orgname);
		webutil.Selectfromdd(driver.findElement(By.id("bas_searchfield")), "Organization Name");
		organisation.getSearchnowbtn().click();

		
		Thread.sleep(3000);
		String value = organisation.getorganisationname().getText();
		Assert.assertEquals(value, orgname);
	}


}
