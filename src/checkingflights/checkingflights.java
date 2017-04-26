package checkingflights;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class checkingflights {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		String baseUrl = "http://www.makemytrip.com/flights";
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		driver.get(baseUrl);
		
		driver.findElement(By.xpath("//*[@id='widget_row']/div[1]/div/div[3]/div/div[2]/div[2]/a")).click();
		System.out.println("Clicked on International flights");
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
		driver.findElement(By.xpath("//*[@id='from_typeahead1']")).sendKeys("San Francisco, US (SFO)");
		System.out.println("Selected source San Francisco, US (SFO)");
		driver.findElement(By.xpath("//*[@id='to_typeahead1']")).sendKeys("Bangalore, India (BLR)");
		System.out.println("Selected destination Bangalore, India (BLR)");
		driver.findElement(By.id("start_date_sec")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[3]/table/tbody/tr[4]/td[4]/a")).click();


		Select dropdown=new Select(driver.findElement(By.xpath("//*[@id='class_selector']")));
		dropdown.selectByVisibleText("Business");
		System.out.println("Business class selected");
		Thread.sleep(5000);

		driver.findElement(By.xpath("//*[@id='date_flexible_check']")).click();
		System.out.println("Flexible date check boxed");
		driver.findElement(By.xpath("//*[@id='flights_submit']")).click();
		System.out.println("Searching for flights");
		Thread.sleep(9000);

		driver.findElement(By.xpath("//*[@id='filters_panel']/div/div[2]/div/a[2]/span[1]/sub")).click();
		Select dropdown1=new Select(driver.findElement(By.xpath("//*[@id='content']/div[1]/div[3]/div[3]/div/div[4]/div[1]/div/div/select[1]")));
		dropdown1.selectByValue("0");
		System.out.println("Selected currency display USD");

	}

}
