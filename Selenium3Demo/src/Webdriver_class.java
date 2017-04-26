import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Webdriver_class {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();	
		driver.get("http://google.com");	
		System.out.println(driver.getTitle());	
		driver.close();
	}

}
