import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("window.scrollBy(0,500)");
		
		System.out.println(driver.findElements(By.cssSelector("table[name='courses'] tbody tr")).size());
		
		System.out.println(driver.findElements(By.cssSelector("table[name='courses'] tbody tr th")).size());
		
		List<WebElement> row = driver.findElements(By.xpath("//table[@name='courses']/tbody/tr[3]/td"));
		
		for(int i=0; i<row.size();i++) {
			
			System.out.println(row.get(i).getText());
		}

	}

}
