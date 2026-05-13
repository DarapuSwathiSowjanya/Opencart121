package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.baseClass;
import utilities.DataProviders;

/*
 * Data is valid- login success- test pass  -logout
 * Data is valid- login failed- test fail  
 * 
 * Data is Invalid- login success- test fail  -logout
 * Data is Invalid- login failed- test pass  
 */
public class TC003_LoginDDT extends baseClass{

	
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class,groups="Datadriven")//getting data provider in different class
	public void verify_loginDDT(String email, String pwd, String exp) {
		
		
		logger.info("**********starting  TC003_LoginDDT************");
		//HomePage
		try {
		HomePage hp= new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//login
		LoginPage lp= new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		
		//Myaccount
		MyAccountPage macc= new MyAccountPage(driver);
		boolean targetPage=macc.isMyAccountPageExists();
		
		//positive condition 
		if(exp.equalsIgnoreCase("Valid")) {
			if(targetPage==true) {
				macc.clickLogout();
				Assert.assertTrue(true);
				
			}else {
				Assert.assertTrue(false);
			}
		}
		
		//negatve case
		if(exp.equalsIgnoreCase("Invalid")) {
			if(targetPage==true) {
				macc.clickLogout();
				Assert.assertTrue(false);
				
			}else {
				Assert.assertTrue(true);
			}
		}
		}catch(Exception e) {
			Assert.fail();
		}
		logger.info("**********finished TC003_LoginDDT************");

	}
}
