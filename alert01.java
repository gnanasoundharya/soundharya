package novbatch;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class alert01 {
	WebDriver driver;
	String url="https://demoqa.com/alerts";
@BeforeClass
public void demoqa1()
{
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
}
@Test
public void demoqa04cli() throws InterruptedException
{
	driver.findElement(By.id("promtButton")).click();
	Alert at =driver.switchTo().alert();
	at.sendKeys("soundharya");
	Thread.sleep(3000);
	at.accept();
}
//@Test
public void demoqa02cli() throws InterruptedException
{
	driver.findElement(By.id("timerAlertButton")).click();
	Thread.sleep(5000);
	Alert at =driver.switchTo().alert();
	Thread.sleep(3000);
	at.accept();
}
@Test
public void demoqa4() throws InterruptedException
{
	driver.findElement(By.id("confirmButton")).click();
	Thread.sleep(3000);
	Alert at1=driver.switchTo().alert();
	at1.dismiss();
	Thread.sleep(2000);	
}
@AfterTest
public void at()
{
driver.close();	
}
}
