import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandlesAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://the-internet.herokuapp.com/");
		
		driver.findElement(By.linkText("Multiple Windows")).click();
		
		driver.findElement(By.linkText("Click Here")).click();
		
		Set<String> windows=driver.getWindowHandles();
		
		Iterator<String> it =windows.iterator();
		
		String parentWindowID=it.next();
		
		String childWindowID=it.next();
		
		driver.switchTo().window(childWindowID);
		
		System.out.println(driver.findElement(By.cssSelector("[class='example'] h3")).getText());
		
		driver.switchTo().window(parentWindowID);
		
		System.out.println(driver.findElement(By.cssSelector("[class='example'] h3")).getText());
		

	}

}
