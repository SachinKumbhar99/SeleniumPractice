import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddtoCart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();

//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		
		String[] itemstobeaded = {"Brocolli", "Cucumber","Tomato","Apple"};
		
		addtocards(driver,itemstobeaded);
		
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("input.promoCode")));
		
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
	
		driver.close();

	}

	
	public static void addtocards(WebDriver driver, String[] itemstobeaded) throws InterruptedException {
		int j=0;
		
		//convert array to arraylist
		List<String> itemstobeadedlist = Arrays.asList(itemstobeaded);
		
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		
		for(int i=0;i<products.size(); i++) {
			
			String[] name = products.get(i).getText().split("-");
			String Splittedtext = name[0].trim();
			
			if(itemstobeadedlist.contains(Splittedtext)) {
				
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				Thread.sleep(1000);
				if(j==itemstobeaded.length) {
					break;
				}
				
			}
			
		}
	}
}
