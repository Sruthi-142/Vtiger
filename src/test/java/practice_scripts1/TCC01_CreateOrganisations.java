package practice_scripts1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.geneics.Base_class_Test;
import com.crm.ty.Excel_Util;
import com.crm.ty.JavaUtil;
import com.crm.ty.WebDriverUtil;

import pom.Home_Page;
import pom.Organisation;
import pom.OrganisationInfo;

public class TCC01_CreateOrganisations extends Base_class_Test {

	@Test(groups= {"regression"})
	public void create_organisations() throws Exception {



		Home_Page HomePage=new Home_Page(driver);
		HomePage.getOrganisationlink().click();

		Organisation organisation=new Organisation(driver);
		organisation.getAdminimage().click();
		Excel_Util excelutil=new Excel_Util();
		String orgxl=excelutil.read_exceldata("Sheet1", 2, 0);
		JavaUtil jv=new JavaUtil();
		String orgname=orgxl+jv.generateRandomNumber();
		OrganisationInfo organinfo=new OrganisationInfo(driver);
		organinfo.getOrganisationName().sendKeys(orgname);
		organinfo.getSaveBtn().click();
		Thread.sleep(3000);
		HomePage.getOrganisationlink().click();
		organisation.getSearchbox().sendKeys(orgname);
		WebDriverUtil webutil=new WebDriverUtil();

		WebElement element = driver.findElement(By.id("bas_searchfield"));
		webutil.Selectfromdd(element, "Organization Name");
		organisation.getSearchnowbtn().click();
		Thread.sleep(3000);
		String value = organisation.getorganisationname().getText();
		Assert.assertEquals(value, orgname);

	}
	@Test(groups= {"smoke"})
	public void create_emptyorg() throws Throwable, Exception
	{
		Home_Page HomePage=new Home_Page(driver);
		HomePage.getOrganisationlink().click();

		Organisation organisation=new Organisation(driver);
		organisation.getAdminimage().click();
		OrganisationInfo organinfo=new OrganisationInfo(driver);
		organinfo.getSaveBtn().click();
		Thread.sleep(3000);
		HomePage.getOrganisationlink().click();
		String value = organisation.getorganisationname().getText();
		Assert.assertEquals(value,"Organisation Name cannot be empty");
		webutil.alertaccept(driver);
	}
}



