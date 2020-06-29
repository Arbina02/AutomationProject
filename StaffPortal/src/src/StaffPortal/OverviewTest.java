package src.StaffPortal;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class OverviewTest extends SigninTest {

	@Test(priority=13)//, dependsOnMethods={"signIn"})
	public void switchOption() throws InterruptedException
	{
		//Switching Between Specialist
		Select option=new Select(driver.findElement(By.xpath("//select[@id='switch_specialist_id']")));
		option.selectByIndex(1);
		Thread.sleep(5000);
	}

	@Test(priority=14)//, dependsOnMethods={"switchOption"})
	public void announcement() throws InterruptedException, AWTException 
	{
		//Opens a pop-up window 
		driver.findElement(By.xpath("//div[@id='main_content']/div[2]/div/div/div[1]/div/p[2]/a")).click();
		Thread.sleep(3000);
		for(int i=0;i<=90;i++) 
		{
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_DOWN);
			Thread.sleep(3000);
		}
		Thread.sleep(3000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_HOME);	
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@id='specialistAgreementModal']/div/div/button")).click(); 
		Thread.sleep(3000);

	}

	@Test(priority=15)//, dependsOnMethods={"announcement"})
	public void resources() throws InterruptedException
	{
		//take user to the Resources page
		driver.findElement(By.xpath("//div[@class='announcements']/div/div[2]/div/p[2]/a")).click();
		Thread.sleep(5000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='left-panel']/ul[1]/a[1]/li")).click();
	}

	@Test(priority=16)//, dependsOnMethods={"resources"})
	public void upCommingAppointment() throws InterruptedException
	{
		//Takes to upcommingAppointment
		Thread.sleep(5000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
	}

	@Test(priority=17)//, dependsOnMethods={"upCommingAppointment"})
	public void allAppointments() throws InterruptedException
	{
		//navigate to Appointment Page & navigate back to the current page
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='main-content']/p[1]/a")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='left-panel']/ul[1]/a[1]/li")).click();
	}

	@Test(priority=18)//, dependsOnMethods={"allAppointments"})
	public void statusCheck() throws InterruptedException
	{
		//clicking on a button to check the status
		Thread.sleep(5000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,700)");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@id='1_70']")).click();
		Thread.sleep(5000);
	}

	@Test(priority=19)//, dependsOnMethods={"statusCheck"})
	public void unCheckStatus() throws InterruptedException
	{
		//Changing the state of the same button
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@id='1_72']")).click();
		Thread.sleep(5000);
	}

	@Test(priority=20)//, dependsOnMethods={"unCheckStatus"})
	public void selected() throws InterruptedException
	{
		//Selecting Whole column
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@id='main_content']/div[7]/div/div/table/tbody/tr/td[2]/table/tbody/tr[1]/td/span/a[1]")).click();
		Thread.sleep(5000);
	}

	@Test(priority=21)//, dependsOnMethods={"selected"})
	public void deSelected() throws InterruptedException
	{
		//Deselecting Whole Column
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@id='main_content']/div[7]/div/div/table/tbody/tr/td[4]/table/tbody/tr[1]/td/span/a[2]")).click();
		Thread.sleep(5000);
	}

	@Test(priority=22)//, dependsOnMethods={"deSelected"})
	public void allPatient() throws InterruptedException
	{
		//Navigate to Patient Page & navigate back to the current page
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@id='main_content']/p[2]/a")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("//div[@class='left-panel']/ul[1]/a[1]/li")).click();
	}

	@Test(priority=23)//, dependsOnMethods={"allPatient"})
	public void searchPatient() throws InterruptedException, AWTException
	{
		//Search's for the given text
		String value="John Doe"; 
		String data=driver.findElement(By.xpath("//select[@id='switch_specialist_id']/option[1]")).getText();
		if(data.equals(value)) 
		{	
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_END);	
			Thread.sleep(5000);
			driver.findElement(By.xpath("//input[@id='search_patients']")).click();
		}
		else 
		{
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_END);	
			Thread.sleep(5000);
			driver.findElement(By.xpath("//input[@id='search_patients']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='search_patients']")).sendKeys("Nithin");
			Thread.sleep(5000);
			Robot robot1 = new Robot();
			robot1.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(5000);
		}
	}
}
