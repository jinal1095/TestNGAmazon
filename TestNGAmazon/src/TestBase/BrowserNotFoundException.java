package TestBase;

public class BrowserNotFoundException extends Exception {




 

	public BrowserNotFoundException()
	{
		System.out.println("Browser can  only be FF");
	}
	
	public BrowserNotFoundException(String msg)
	{
		System.out.println("Invalid Browser for current Instance");
	}

}
