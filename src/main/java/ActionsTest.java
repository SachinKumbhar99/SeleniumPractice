import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();

		driver.get("https://www.amazon.in/");
		
		WebElement move = driver.findElement(By.cssSelector("[id='nav-link-accountList']"));
		
		Actions a = new Actions(driver);
		
		a.moveToElement(move).build().perform();
		
		
		WebElement searchbox = driver.findElement(By.cssSelector("[id='twotabsearchtextbox']"));
		
		a.moveToElement(searchbox).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
		
		
			

	}

}
