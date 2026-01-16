import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Windowhandles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");

		driver.findElement(By.cssSelector(".blinkingText")).click();

		Set<String> windows = driver.getWindowHandles();

		Iterator<String> it = windows.iterator();

		String ParentWindowID = it.next();

		String ChildWindowID = it.next();

		driver.switchTo().window(ChildWindowID);

		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());

		String EmailID = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim()
				.split(" ")[0];

		driver.switchTo().window(ParentWindowID);

		driver.findElement(By.id("username")).sendKeys(EmailID);

	}

}
