import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckboxSelection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.manage().window().maximize();
		
		driver.get("https://www.spicejet.com/");
		
		/*Using XPath for <circle> elements
        The primary method for locating SVG elements is to use XPath functions like name() and local-name(). 
		 */

		List<WebElement> circles = driver.findElements(By.xpath("//*[local-name()='circle']"));
		int count = circles.size();
		System.out.println(count);		
		
		driver.findElement(By.xpath("(//*[name()='circle'])[6]")).click();
		
		
	}

}
