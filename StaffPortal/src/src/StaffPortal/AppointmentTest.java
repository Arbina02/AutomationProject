package src.StaffPortal;

import java.awt.AWTException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class AppointmentTest extends OverviewTest
{
	@Test(priority=24)//, dependsOnMethods={"searchPatient"})
	public void navigateAppointment() throws InterruptedException
	{
		//Navigating to the Appointments page
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='left-panel']/ul[1]/a[2]/li")).click();
		Thread.sleep(5000);
	}

	@Test(priority=25)//, dependsOnMethods={"navigateAppointment"})
	public void upComingAppointment() throws InterruptedException
	{
		//the default tab is Upcoming Appointments
		driver.findElement(By.xpath("//ul[@class='nav nav-tabs appointment-tabs tabs-2']/li[1]")).click();
		Thread.sleep(5000);
	}

	@Test(priority=26)//, dependsOnMethods={"cancel"})
	public void pastAppointement() throws InterruptedException, AWTException 
	{
		//Navigates to past Appointments & checks the listing
		String value="John Doe";
		String data=driver.findElement(By.xpath("//select[@id='switch_specialist_id']/option[1]")).getText();
			if(data.equals(value))
			{	
				driver.findElement(By.xpath("//ul[@class='nav nav-tabs appointment-tabs tabs-2']/li[2]")).click();
				Thread.sleep(5000);
			}
			else 
			{
				Thread.sleep(4000);	
				driver.findElement(By.xpath("//div[@class='main-content']/div[2]/ul/li[2]")).click();
				Thread.sleep(4000);
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("window.scrollBy(0,400)");
				Thread.sleep(5000);
			}
		}
	

	@Test(priority=27)//, dependsOnMethods={"pastAppointement"})
	public void NavigateBack() throws InterruptedException 
	{
		//Navigate back to overview
		driver.findElement(By.xpath("//div[@class='left-panel']/ul[1]/a[2]/li")).click();
		Thread.sleep(5000);
	}

}

