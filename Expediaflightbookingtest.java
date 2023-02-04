package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.Expediaflightbookingpage;

public class Expediaflightbookingtest {

	WebDriver driver;
	String url="https://www.expedia.com/";
	
	@BeforeTest
	public void setup()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@BeforeMethod
	public void url()
	{
		driver.get(url);
	}
	
	@Test
	public void expedia()
	{
		Expediaflightbookingpage ob=new Expediaflightbookingpage(driver);
		ob.source_destination("Brussels", "NewYork");
		ob.from_inputs();
		ob.to_inputs();
		ob.traveller_details();
		ob.seat_details();
	}
}
