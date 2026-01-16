import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.manage().window().maximize();
		
		driver.get("https://www.spicejet.com/");
		
		String text = driver.findElement(By.cssSelector("div[data-testid='return-date-dropdown-label-test-id']")).getDomAttribute("style");

		if(text.contains("background-color: rgb")) {
			System.out.println("Dropdown is disabled");
			Assert.assertTrue(true);
		}
		else {
			System.out.println("Dropdown is Enabled");
			Assert.assertTrue(false);
		}
		
		driver.findElement(By.xpath("(//*[name()='circle'])[3]")).click();
		
		String text1 = driver.findElement(By.cssSelector("div[data-testid='return-date-dropdown-label-test-id']")).getDomAttribute("style");

		if(!text1.contains("background-color: rgb")) {
			System.out.println("Dropdown is enabled");
			Assert.assertTrue(true);
		}
		
		driver.close();
	}

}
