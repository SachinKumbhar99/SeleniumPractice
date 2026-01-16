import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AutoSuggestAssignemnt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.id("autocomplete")).click();
		
		driver.findElement(By.id("autocomplete")).sendKeys("united");
		
		Actions act = new Actions(driver);
		
		WebElement ele = driver.findElement(By.xpath("//*[@class='ui-menu-item']/div[contains(text(),'United Kingdom (UK)')]"));
		
		act.moveToElement(ele).click().build().perform();
		
		System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));

	}

}
