
package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {
	
	    WebDriver driver;
		@FindBy(name="user_name")
		private WebElement usertxtbx;
		
		@FindBy(name="user_password")
		private WebElement pwdtxtbx;
		
		@FindBy(id="submitButton")
		private WebElement loginbtn;

		public WebElement getUsertxtbx() 
		{
			return usertxtbx;
		}

		public WebElement getPwdtxtbx() 
		{
			return pwdtxtbx;
		}

		public WebElement getLoginbtn()
		{
			return loginbtn;
		}
		public Login_Page(WebDriver driver) 
		{
			this.driver=driver;
		PageFactory.initElements(driver, this);	
		
		}
		
		
		

	

}
