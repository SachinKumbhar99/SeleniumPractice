import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptAlerts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String name = "Sachin";

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		driver.findElement(By.cssSelector("[id='name']")).sendKeys(name);

		driver.findElement(By.id("alertbtn")).click();

		System.out.println(driver.switchTo().alert().getText());

		driver.switchTo().alert().accept();

		driver.findElement(By.xpath("//*[@value='Confirm']")).click();

		System.out.println(driver.switchTo().alert().getText());

		driver.switchTo().alert().dismiss();

	}

}
