import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssignmentWaits {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		driver.findElement(By.cssSelector("input#username")).sendKeys("rahulshettyacademy");
		
		driver.findElement(By.cssSelector("input#password")).sendKeys("learning");
		
		driver.findElement(By.xpath("//input[@id='usertype' and @value='user']/following-sibling::span")).click();
		
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		
		driver.findElement(By.xpath("//button[@id='okayBtn']")).click();
		
		WebElement options = driver.findElement(By.xpath("//select[@class='form-control']"));

		Select dropdown = new Select(options);

		dropdown.selectByValue("consult");
		
		driver.findElement(By.cssSelector("input#terms")).click();
		
		driver.findElement(By.cssSelector("input.btn")).click();
		
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Checkout ")));
		
		List<WebElement> items =driver.findElements(By.xpath("//div[@class='card-footer']/button"));
		
		int totalitems= items.size();
		
		for(int i=0;i<totalitems;i++) {
			
			items.get(i).click();
		}
		
		driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();
		
		
		
		
		
		

	}

}
