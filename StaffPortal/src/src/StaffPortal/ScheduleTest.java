package src.StaffPortal;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ScheduleTest extends AppointmentTest
{

	@Test(priority=28)//, dependsOnMethods={"NavigateBack"})
	public void scheduleNavigation() throws InterruptedException 
	{
		//Navigating to Schedule Page
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='left-panel']/ul[1]/a[3]/li")).click();
		Thread.sleep(5000);
	}
	
	@Test(priority=29)//, dependsOnMethods={"scheduleNavigation"})
	public void scheduleInformation() throws InterruptedException
	{
		//Opens up an Pop-up window
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='side-head-sec margin-t30']/h2/a/i")).click();
		Thread.sleep(7000);
		driver.findElement(By.xpath("//div[@class='jconfirm-box jconfirm-hilight-shake jconfirm-type-default jconfirm-type-animated']/div[1]")).click();
		Thread.sleep(5000);
	}

	@Test(priority=30)//, dependsOnMethods={"scheduleInformation"})
	public void mondaySchedule() throws InterruptedException
	{
		//Scheduled time for Monday
		Thread.sleep(5000);
		Select Start_Morngsession=new Select(driver.findElement(By.xpath("//select[@id='morning_start_1']")));
		Start_Morngsession.selectByIndex(3);
		Thread.sleep(3000);
		Select End_Morngsession=new Select(driver.findElement(By.xpath("//select[@id='morning_end_1']")));
		End_Morngsession.selectByIndex(17);
		Thread.sleep(3000);
		Select Start_Evngsession=new Select(driver.findElement(By.xpath("//select[@id='evening_start_1']")));
		Start_Evngsession.selectByIndex(3);
		Thread.sleep(3000);
		Select End_Evngsession=new Select(driver.findElement(By.xpath("//select[@id='evening_end_1']")));
		End_Evngsession.selectByIndex(15);
	}

	@Test(priority=31)// dependsOnMethods={"mondaySchedule"})
	public void tuesdaySchedule() throws InterruptedException
	{
		//Scheduled time for Tuesday
		Thread.sleep(5000);
		Select Start_Morngsession=new Select(driver.findElement(By.xpath("//select[@id='morning_start_2']")));
		Start_Morngsession.selectByIndex(3);
		Thread.sleep(3000);
		Select End_Morngsession=new Select(driver.findElement(By.xpath("//select[@id='morning_end_2']")));
		End_Morngsession.selectByIndex(17);
		Thread.sleep(3000);
		Select Start_Evngsession=new Select(driver.findElement(By.xpath("//select[@id='evening_start_2']")));
		Start_Evngsession.selectByIndex(3);
		Thread.sleep(3000);
		Select End_Evngsession=new Select(driver.findElement(By.xpath("//select[@id='evening_end_2']")));
		End_Evngsession.selectByIndex(15);
	}
	 
	@Test(priority=32)//, dependsOnMethods={"tuesdaySchedule"})
	public void wednesdaySchedule() throws InterruptedException
	{
		//Scheduled time for Wednesday
		    String value="John Doe";
			String data=driver.findElement(By.xpath("//select[@id='switch_specialist_id']/option[1]")).getText();
			if(data.equals(value))
			{	
				Select Start_Morngsession=new Select(driver.findElement(By.xpath("//select[@id='morning_start_3']")));
				Start_Morngsession.selectByIndex(3);
				Thread.sleep(3000);
				Select End_Morngsession=new Select(driver.findElement(By.xpath("//select[@id='morning_end_3']")));
				End_Morngsession.selectByIndex(17);
				Thread.sleep(3000);
				Select Start_Evngsession=new Select(driver.findElement(By.xpath("//select[@id='evening_start_3']")));
				Start_Evngsession.selectByIndex(3);
				Thread.sleep(3000);
				Select End_Evngsession=new Select(driver.findElement(By.xpath("//select[@id='evening_end_3']")));
				End_Evngsession.selectByIndex(15);
				Thread.sleep(3000);		
			}
			else
			{
				driver.findElement(By.xpath("//tr[@id='tr_3']/td[4]/button")).click();
			}
		
	}
}