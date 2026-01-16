import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assignemnt2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.manage().window().maximize();
		
		driver.get("https://www.spicejet.com/");
		
		driver.findElement(By.xpath("//div[contains(text(),'From')][1]")).click();
		
		driver.findElement(By.xpath("//div[contains(text(),'BLR')]")).click();
		
		driver.findElement(By.xpath("//div[contains(text(),'MAA')]")).click();
		
		driver.findElement(By.xpath("//*[text()='Departure Date']")).click();
		
		driver.findElement(By.xpath("//*[text()='Passengers']")).click();
		
		for(int i=1;i<4;i++) {
			
			driver.findElement(By.cssSelector("div[data-testid='Adult-testID-plus-one-cta']")).click();
		}
		
		System.out.println(driver.findElement(By.xpath("//*[text()='Passengers']/following-sibling::div")).getText());

		driver.findElement(By.xpath("//*[text()='Passengers']")).click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[text()='Search Flight']")).click();
		
		driver.close();
		
	}

}
