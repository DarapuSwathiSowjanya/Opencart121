package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.baseClass;

public class TC002_LoginTest extends baseClass {

	@Test(groups={"Sanity","Master"})
	public void verify_login() {
		logger.info("***********Starting TC002-login testcases***************");
		try {
		//home page
		HomePage hp= new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//loginPage
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		//myaccount
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetPage=macc.isMyAccountPageExists();
		
		//Assert.assertEquals(targetPage,true,"Login Failed");
		Assert.assertTrue(targetPage);
		}catch(Exception e) {
			Assert.fail();
		}
		logger.info("***********Finished TC002-login testcases***************");
		
	}
}
