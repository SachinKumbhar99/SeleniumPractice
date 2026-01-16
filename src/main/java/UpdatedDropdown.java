import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UpdatedDropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.manage().window().maximize();
		
		driver.get("https://www.spicejet.com/");
		
		System.out.println(driver.findElement(By.xpath("//*[text()='1 Adult']")).getText());
		
		driver.findElement(By.xpath("//*[text()='1 Adult']")).click();
		
	
		
		//Add 5 adults
		
		//using while loop
		/*int i=1;
		while(i<5) {
			driver.findElement(By.xpath("//*[@data-testid=\"Adult-testID-plus-one-cta\"]")).click();
			i++;
		}*/
		
		
		//using for loop
		
		for(int i=1; i<5;i++) {
			driver.findElement(By.xpath("//*[@data-testid=\"Adult-testID-plus-one-cta\"]")).click();
		}
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[text()='Passengers']/following-sibling::div/div[1]")).getText(), "5 Adults");
//		System.out.println(driver.findElement(By.xpath("//div[text()='Passengers']/following-sibling::div/div[1]")).getText());

		driver.close();
	}

}
