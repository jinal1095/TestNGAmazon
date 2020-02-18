package TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase1 {
	
	public static WebDriver driver;
	public static Properties prop;



	public TestBase1(){
		try{
			FileInputStream file=new FileInputStream("E:\\Ethans\\JavaDay1\\TestNGAmazon\\config.properties");
			prop=new Properties();
			prop.load(file);
		    
		}
		
	
		catch(FileNotFoundException d)
		{
			d.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}


	public static void initialisation() throws BrowserNotFoundException
	{
		String browsername=prop.getProperty("browser");
		if(browsername.equals("FF"))
		{

			System.setProperty("webdriver.gecko.driver", "E:\\softwares\\SeleniumLatest\\geckodriver-v0.26.0-win32\\geckodriver.exe");
			driver=new FirefoxDriver();

		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));

	}
}