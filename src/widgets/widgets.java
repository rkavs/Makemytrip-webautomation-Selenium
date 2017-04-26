package widgets;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class widgets {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		String baseUrl = "http://www.makemytrip.com/flights";
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get(baseUrl);
		By.tagName("a");
		List<WebElement> linkElements = driver.findElements(By.className("widget_tabs_info"));
        String[] linkTexts = new String[linkElements.size()];
        int i = 0;

        //extract the link texts of each link element
        for (WebElement e : linkElements) {
            linkTexts[i] = e.getText();
            System.out.println("link"+i+"="+linkTexts[i]);
            i++;
        }
        
        
        for(String links: linkTexts[0].split("\n")){
        	//System.out.println("links="+links);
        	Thread.sleep(1000);
        	try{
        		driver.findElement(By.linkText(links)).click();
        		if (driver.getTitle().equals("")) {
                    System.out.println("\"" + links + "\"" + " is not working.");
        		}
        		else{
        			System.out.println("\"" + links + "\"" + " is working.");
        		}
        	}
        	catch(Throwable e){
        		driver.get(baseUrl);
        		By.tagName("a");
                driver.findElement(By.className("triplanner_tab")).click();
                if (driver.getTitle().equals("")) {
                    System.out.println("\"" + links + "\"" + " is not working.");
        		}
        		else{
        			System.out.println("\"" + links + "\"" + " is working.");
        		}
        	}
        }
	}
}
