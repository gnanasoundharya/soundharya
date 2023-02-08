package novbatch;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class windowhandles01 {
WebDriver driver;
String url="https://demoqa.com/browser-windows";
String url1="https://www.amazon.in";
String url2="https://www.flipkart.com";
@BeforeTest
public void handle01()
{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		
}
@Test
public void handle02() throws InterruptedException
{
	WebElement web=driver.findElement(By.id("tab Button"));
	web.click();
	web.click();
	int i=0;
	String parent=driver.getWindowHandle();
	Set<String>tabs=driver.getWindowHandles();
	for(String handle:tabs)
{
		if(!handle.equals(parent)) {
			i++;
			if(i==1) {
	
		driver.switchTo().window(handle);
		Thread.sleep(5000);
		driver.get(url);
		Thread.sleep(3000);
	}
			else
			{
				driver.switchTo().window(handle);
				Thread.sleep(5000);
				driver.get(url1);
				Thread.sleep(3000);
			}
		}else
		{
			continue;
		}
		driver.switchTo().window(parent);
		driver.get(url2);
}
}
}