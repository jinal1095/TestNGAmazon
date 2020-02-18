package TestAmazon;

import TestBase.BrowserNotFoundException;
import TestBase.TestBase1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.HomePage;

public class Test1 extends TestBase1{
	
	HomePage obj;
	
	@BeforeTest
	public void setup() throws BrowserNotFoundException
	{
		initialisation();
		obj=new HomePage(); 

	}
	
	
	@Test
	public void Test() throws InterruptedException{
		obj.test1();
	}
	

    @AfterTest
    public void closeEnvironmnt()
    {
    	driver.quit();
    }

}
