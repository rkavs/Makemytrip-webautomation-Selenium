package signin;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class signin_test {
	
	private static Properties testData;
	
	public static void main(String[] args) throws InterruptedException, FileNotFoundException, IOException
	{
		testData = new Properties();
        testData.load(new FileInputStream("logininputs.txt"));
        
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.makemytrip.com/flights");

		driver.findElement(By.id("ssologinlink")).click();
		
		int noOfVTests = Integer.parseInt(testData.getProperty("noOfVTests"));
		int noOfIVTests = Integer.parseInt(testData.getProperty("noOfIVTests"));
		System.out.println("Total tests = "+noOfIVTests);
		
		while(noOfVTests <= noOfIVTests){
			//driver.findElement(By.id("ssologinlink")).click();
			System.out.println("Current test = "+noOfVTests);
			Thread.sleep(1000);
			System.out.println("Username="+testData.getProperty("user"+noOfVTests));
			Thread.sleep(3*1000);
			driver.findElement(By.xpath("//input[@id='username']")).sendKeys(testData.getProperty("user"+noOfVTests));
			System.out.println("Password="+testData.getProperty("pass"+noOfVTests));
			driver.findElement(By.xpath("//input[@id='password_text']")).sendKeys(testData.getProperty("pass"+noOfVTests));
			driver.findElement(By.xpath("//*[@id='login_btn']")).click();
			Thread.sleep(3000);
			try {
				driver.findElement(By.xpath("//*[contains(text(), 'Login')]"));
				System.out.println("Login failed");
			}
			catch (Throwable e){
				System.out.println("Login Successful");
			}
			noOfVTests++;
			driver.get("http://www.makemytrip.com/flights");
			Thread.sleep(3000);
			driver.findElement(By.id("ssologinlink")).click();
			
		}

		Thread.sleep(3000);
		

		driver.close();
	}

}
//end
