package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.sun.jna.platform.win32.WinNT.HANDLE;

import TestBase.TestBase1;

public class HomePage extends TestBase1{

	@FindBy(xpath="//span[@class='nav-sprite nav-logo-base']")
	WebElement logo;
	
	@FindBy(id="twotabsearchtextbox")
	WebElement searchBox;
	
	@FindBy(xpath="//input[@type='submit' and @value='Go']")
	WebElement GoButton;
	
	@FindBy(xpath="(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")
	WebElement firstEle;
	
	@FindBy(id="add-to-cart-button")
	WebElement addToCart;
	
	@FindBy(id="hlb-ptc-btn-native")
	WebElement proceedToBuy;
	
	@FindBy(id="ap_email")
	WebElement email;
	
	@FindBy(id="ap_password")
	WebElement password;
	
	@FindBy(id="continue")
	WebElement continueButton;
	
	@FindBy(id="signInSubmit")
	WebElement LoginButton;
	
	@FindBy(xpath="(//a[@class='a-declarative a-button-text '])[1]")
	WebElement address;
	
	@FindBy(xpath="//form[@id='shippingOptionFormId']/div[3]/div[1]/div/span[1]/span/input")
	WebElement deliveryOption;
	
	@FindBy(xpath="//h1[@class='a-spacing-base']")
	WebElement verifyPaymentText;
	
	
	public HomePage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void test1() throws InterruptedException{
		logo.click();
		searchBox.sendKeys("xbox");
		//Thread.sleep(10000);
		GoButton.click();
		firstEle.click();
		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();

		// Perform the click operation that opens new window

		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}

		// Perform the actions on new window
		addToCart.click();
		proceedToBuy.click();
		email.sendKeys(prop.getProperty("UserName"));
		continueButton.click();
		password.sendKeys(prop.getProperty("Password"));
		LoginButton.click();
		address.click();
		Thread.sleep(10000);
		deliveryOption.click();
		String paymentText=verifyPaymentText.getText();
		Assert.assertEquals(paymentText, "Select a payment method");

	}
	
	
}
