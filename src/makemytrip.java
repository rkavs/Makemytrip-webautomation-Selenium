package test_automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class integrated {
	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.makemytrip.com/flights");

		driver.findElement(By.id("ssologinlink")).click();
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("something");
		driver.findElement(By.xpath("//input[@id='password_text']")).sendKeys("someone");
		driver.findElement(By.xpath("//*[@id='login_btn']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='widget_row']/div[1]/div/div[3]/div/div[2]/div[2]/a")).click();
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		boolean displayFlag = driver.findElement(By.linkText("ONE WAY")).isDisplayed();
		boolean enableFlag = driver.findElement(By.linkText("ONE WAY")).isEnabled();
		if(displayFlag==true && enableFlag==true)
		{
			try{
				Thread.sleep(5000);
				}
				catch(Exception ex)
				{
					System.out.println(ex.getMessage());
				}
			WebElement element=driver.findElement(By.xpath("//span[@class='radio_state']"));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
		}

		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='from_typeahead1']")).sendKeys("San Francisco, US (SFO)");
		driver.findElement(By.xpath("//*[@id='to_typeahead1']")).sendKeys("Bangalore, India (BLR)");

		driver.findElement(By.id("start_date_sec")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[3]/table/tbody/tr[4]/td[4]/a")).click();


		Select dropdown=new Select(driver.findElement(By.xpath("//*[@id='class_selector']")));
		dropdown.selectByVisibleText("Business");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@id='date_flexible_check']")).click();

		driver.findElement(By.xpath("//*[@id='flights_submit']")).click();
		Thread.sleep(9000);

		driver.findElement(By.xpath("//*[@id='filters_panel']/div/div[2]/div/a[2]/span[1]/sub")).click();

		Select dropdown1=new Select(driver.findElement(By.xpath("//*[@id='content']/div[1]/div[3]/div[3]/div/div[4]/div[1]/div/div/select[1]")));
		dropdown1.selectByValue("0");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@id='chf_header']/div[2]/div/ul/li[3]/a/span[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='widget_row']/div[1]/div[1]/div[2]/ul/li[4]/a/span[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='widget_row']/div[1]/div/div[2]/ul/li[5]/a/span[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='widget_row']/div[1]/div/div[2]/ul/li[6]/a/span[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='widget_row']/div[1]/div/div[2]/ul/li[7]/a/span[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='widget_row']/div[1]/div/div[2]/ul/li[8]/a/span[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='rotator']")).click();

		driver.close();
	}

}
//end
