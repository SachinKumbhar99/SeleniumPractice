import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavaScriptExecutorTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;

		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		
		
		int sum=0;
		
		for(int i=0; i<driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)")).size();i++) {
			
			System.out.println(driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)")).get(i).getText());
			
			sum= sum+ Integer.parseInt(driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)")).get(i).getText());
			
		}
		
		System.out.println(sum);
		
		int actual = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
		
		Assert.assertEquals(actual, sum);
		
		driver.close();
		
	}

}
