import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class Scope {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		WebElement footerdriver = driver.findElement(By.id("gf-BIG"));
		
		//get all elements from the footer
		
		System.out.println(footerdriver.findElements(By.tagName("a")).size());
		
		WebElement footerFirstColumndriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		
		System.out.println(footerFirstColumndriver.findElements(By.tagName("a")).size());
		
		for(int i=1;i<footerFirstColumndriver.findElements(By.tagName("a")).size();i++) {
			
			String ControlClickTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
			
			footerFirstColumndriver.findElements(By.tagName("a")).get(i).sendKeys(ControlClickTab);
				
		}
		
		//get title of all windows
		
		Set<String> windows = driver.getWindowHandles();
		
		Iterator<String> it = windows.iterator();
		
		while(it.hasNext()) {
			
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
		
		

	}

}
