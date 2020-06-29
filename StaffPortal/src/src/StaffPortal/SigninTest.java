package src.StaffPortal;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SigninTest 
{
WebDriver driver;
	
	@Test(priority=1)
	public void launchBrowser() throws InterruptedException
	{
		//Launchs Browser 
		String path = System.getProperty("user.dir");
		System.out.println(path); 
		System.setProperty("webdriver.gecko.driver",path+"\\lib\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://qa.accesselitenow.com");	 
		Thread.sleep(5000);
	}
	
	@Test(priority=2)//, dependsOnMethods= {"launchBrowser"})
	public void signUp() throws InterruptedException
	{
		//Clicks on SignUp
		driver.findElement(By.xpath("//p[@class='elite-form-signup']/a")).click();
		Thread.sleep(5000);
		driver.navigate().back();
		Thread.sleep(4000);
	}

	@Test(priority=3)//, dependsOnMethods= {"signup"})
	public void phoneNo() throws InterruptedException, AWTException
	{
		//Clicks on PhoneNumber
		driver.findElement(By.xpath("//form[@class='new_user']/div/p[3]/a")).click();
		Thread.sleep(4000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(4000);
	}

	@Test(priority=4)//, dependsOnMethods= {"phoneNo"})
	public void forgotPassword() throws InterruptedException
	{
		//Opens the forgot password with email as empty.
		driver.findElement(By.xpath("//p[@class='elite-forgot-pwd']/a")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//form[@id='reset_password_form']/button")).click();
		Thread.sleep(5000);

	}

	@Test(priority=5)//, dependsOnMethods= {"forgotPassword"})
	public void prePopulatedmail() throws InterruptedException
	{
		//Opens forgot password with email as pre-populated from the login screen.
		driver.findElement(By.xpath("//input[@id='elite-email']")).sendKeys("nm+34@conciergekeyhealth.com");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//p[@class='elite-forgot-pwd']/a")).click(); 

	}

	@Test(priority=6)//, dependsOnMethods= {"prePopulatedmail"})
	public void closePopup() throws InterruptedException
	{
		//Close the pop-up
		Thread.sleep(5000);
		driver.findElement(By.xpath("//form[@id='reset_password_form']/button")).click();
		driver.findElement(By.xpath("//input[@id='elite-email']")).clear();
	}

	@Test(priority=7)//, dependsOnMethods= {"closePopup"})
	public void resetPassword() throws InterruptedException
	{
		//Reset mail-id with reset link
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='elite-login-form']/p[1]/a")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@id='forgot_password_email']")).sendKeys("nm+34@conciergekeyhealth.com");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@name='commit']")).click();
	}

	@Test(priority=8)//, dependsOnMethods= {"resetPassword"})
	public void login() throws InterruptedException
	{
		//Submit without any mail-id and password
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(4000);

	}

	@Test(priority=9)//, dependsOnMethods= {"login"})
	public void loginEmail() throws InterruptedException
	{
		//Valid mail-id without password
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='elite-email']")).sendKeys("nm+testcorporate@conciergekeyhealth.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(4000);	 
		driver.findElement(By.xpath("//input[@id='elite-email']")).clear();
	}

	@Test(priority=10)//, dependsOnMethods= {"loginEmail"})
	public void invalidEmail() throws InterruptedException
	{
		//Invalid mail-id
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='elite-email']")).sendKeys("nm+qao.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(4000);	 
		driver.findElement(By.xpath("//input[@id='elite-email']")).clear();
	}

	@Test(priority=11)//, dependsOnMethods={"invalidEmail"})
	public void invalidSignin() throws InterruptedException
	{
		//Invalid mail-id & Invalid Password
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='elite-email']")).sendKeys("nm+qaop@conciergekeyhealth.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='password-field']")).sendKeys("password");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(4000);	 
	}

	@Test(priority=12)//, dependsOnMethods={"invalidSignin"})
	public void signIn() throws InterruptedException
	{
		//Valid mail-id & Valid Password
		driver.findElement(By.xpath("//input[@id='elite-email']")).sendKeys("nm+testcorporate@conciergekeyhealth.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='password-field']")).sendKeys("Password1");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(4000);	 
	}

}
