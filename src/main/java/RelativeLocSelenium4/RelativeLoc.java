package RelativeLocSelenium4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLoc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		//above
		
		WebElement NameInputBox=driver.findElement(By.xpath("//div[@class='form-group']//input[@name='name']"));
		
		System.out.println(driver.findElement(with(By.tagName("label")).above(NameInputBox)).getText());
		
		//below

		WebElement dob = driver.findElement(By.cssSelector("[for='dateofBirth']"));
		
		driver.findElement(with(By.tagName("input")).below(dob)).click();
		
		//left
		
		WebElement message = driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
		
		driver.findElement(with(By.tagName("input")).toLeftOf(message)).click();
		
		//right
		WebElement radio = driver.findElement(By.id("inlineRadio1"));
		
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(radio)).getText());
		
		
	}

}
