package novbatch;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import javax.swing.event.MenuKeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class robot01 {
	WebDriver driver;
	String url="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	@BeforeTest
	public void robot02()
	
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);		
	}
	
	@Test
	public void robot03() throws AWTException, InterruptedException
	{
	WebElement web=driver.findElement(By.xpath("//input[@name='username']"));
	Actions act=new Actions(driver);
	act.moveToElement(web).build().perform();
	act.click(web).build().perform();
	Thread.sleep(3000);
	Robot ro=new Robot();
	ro.keyPress(KeyEvent.VK_SHIFT);
	ro.keyPress(KeyEvent.VK_A);
	ro.keyPress(KeyEvent.VK_SHIFT);
	ro.keyPress(KeyEvent.VK_D);
	ro.keyPress(KeyEvent.VK_M);
	ro.keyPress(KeyEvent.VK_I);
	ro.keyPress(KeyEvent.VK_N);
	Thread.sleep(3000);
	}
	@Test
	public void robot04() throws InterruptedException, AWTException
	{
		WebElement web1=driver.findElement(By.xpath("//input[@name='password']"));
		Actions act1=new Actions(driver);
		act1.click(web1).build().perform();
		Thread.sleep(3000);
		Robot ro=new Robot();
		
		ro.keyPress(KeyEvent.VK_A);

		ro.keyPress(KeyEvent.VK_D);
		ro.keyPress(KeyEvent.VK_M);
		ro.keyPress(KeyEvent.VK_I);
		ro.keyPress(KeyEvent.VK_N);
		ro.keyPress(KeyEvent.VK_1);
		ro.keyPress(KeyEvent.VK_2);
		ro.keyPress(KeyEvent.VK_3);
		ro.keyPress(MenuKeyEvent.VK_ENTER);
		Thread.sleep(3000);	
		}
	@AfterTest
	public void robot05() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.close();
	}
	
	
	

}
