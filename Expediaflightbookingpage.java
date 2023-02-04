package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Expediaflightbookingpage {

/*	1.Navigate to the Expedia Website
	2.Look for flight from brussels to newyork

	Additional data
	1.Website to use www.expedia.com
	2.Travelers -2 adult+1 child(3 years old)
	3.Select first class
	4.Select date 2 months gap */
	
	WebDriver driver;
	By flights=By.xpath("//*[@id='wizardMainRegionV2']/div/div/div/div/ul/li[2]/a/span");
	
	By sources=By.xpath("//*[@id='location-field-leg1-origin-menu']/div[1]/div[1]/button");
	By source_input=By.id("location-field-leg1-origin");
	
	By destinations=By.xpath("//*[@id='location-field-leg1-destination-menu']/div[1]/div[1]/button");
	By destination_input=By.id("location-field-leg1-destination");
	
	By f_button=By.id("d1-btn");
	By f_month=By.xpath("//*[@class='uitk-calendar']/div[2]/div[2]/h2");
	By f_alldate=By.xpath("//*[@id='wizard-flight-tab-roundtrip']/div[2]/div[2]/div/div/div[1]/div/div[2]/div/div[1]/div[2]/div[2]/table/tbody/tr/td/button");
	By f_done=By.xpath("//*[@id='wizard-flight-tab-roundtrip']/div[2]/div[2]/div/div/div[1]/div/div[2]/div/div[2]/div/button");
	
	By next=By.xpath("//*[@class='uitk-calendar']/div[1]/button[2]");
	
	By to_button=By.id("d2-btn");
	By to_month=By.xpath(" //*[@class='uitk-calendar']/div[2]/div[2]/h2");
	By to_alldate=By.xpath("//*[@id='wizard-flight-tab-roundtrip']/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div[2]/div[2]/table/tbody/tr/td/button");
	By to_done=By.xpath("//*[@id='wizard-flight-tab-roundtrip']/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div[2]/div/button");

	By traveller=By.xpath("//*[@id='adaptive-menu']/button");
	By child_number=By.xpath("//*[@id='adaptive-menu']/div/div/div/div[2]/section/div[1]/div[2]/div/button[2]");
	By child_details=By.id("child-age-input-0-0");
	By child_done=By.xpath("//*[@id='adaptive-menu']/div/div/div/div[3]/button");
	
	By seat=By.id("preferred-class-input-trigger");
	By first_class=By.xpath("//*[contains(text(),'First class')]");
	
	By submit=By.xpath("//*[@id='wizard-flight-pwa']/div/form/div[3]/div[2]/button");
	

	public Expediaflightbookingpage(WebDriver driver) 
	{
		this.driver=driver;	
	}
	
	public void source_destination(String source,String destination)
	{
		driver.findElement(flights).click();
		driver.findElement(sources).click();
		driver.findElement(source_input).sendKeys(source, Keys.ENTER);
		driver.findElement(destinations).click();
		driver.findElement(destination_input).sendKeys(destination, Keys.ENTER);
	
	}
	
	public void from_inputs()
	{
		driver.findElement(f_button).click();
		while(true)
		{
			WebElement from_months=driver.findElement(f_month);
			String from_month=from_months.getText();
			if(from_month.equalsIgnoreCase("March 2023"))
			{
				break;
			}
		}
		List<WebElement> from_alldates=driver.findElements(f_alldate);
		for(WebElement from_dates:from_alldates)							
		{
			String from_date=from_dates.getAttribute("data-day");
			if(from_date.equals("11"))
			{
				from_dates.click();
			}
		}
		
		driver.findElement(f_done).click();;
	}
	
	public void to_inputs()
	{
		driver.findElement(to_button).click();
		
		while(true)
		{
			WebElement to_months=driver.findElement(to_month);
			String to_month=to_months.getText();
			if(to_month.equalsIgnoreCase("May 2023"))
			{
				break;
			}
			else
			{
				driver.findElement(next).click();
			}
		}
		
		List<WebElement> t_alldates=driver.findElements(to_alldate);
		for(WebElement to_dates:t_alldates)							
		{
			String to_date=to_dates.getAttribute("data-day");
			if(to_date.equals("11"))
			{
				to_dates.click();
			}
		}
		driver.findElement(to_done).click();
	}
	
	public void traveller_details()
	{
		driver.findElement(traveller).click();
		while(true)
		{
			driver.findElement(child_number).click();
			break;
		}
		
		Select child_age=new Select(driver.findElement(child_details));
		child_age.selectByValue("3");
		driver.findElement(child_done).click();
	
	}
	
	public void seat_details()
	{
		driver.findElement(seat).click();
		driver.findElement(first_class).click();
		driver.findElement(submit).click();
	}
}
	
