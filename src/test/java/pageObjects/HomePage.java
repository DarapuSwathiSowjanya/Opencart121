package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    WebDriver driver;

    // Constructor
    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Locators
    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement lnkMyaccount;

    @FindBy(xpath = "//a[normalize-space()='Register']")
    WebElement lnkRegister;
    
    @FindBy(linkText="Login")   //login link added in step5
    WebElement linkLogin;

    // Actions
    public void clickMyAccount() {
        lnkMyaccount.click();
    }

    public void clickRegister() {
        lnkRegister.click();
    }
    
    public void clickLogin() {
    	linkLogin.click();
    }
    
}