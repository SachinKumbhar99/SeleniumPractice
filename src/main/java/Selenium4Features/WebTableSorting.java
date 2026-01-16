package Selenium4Features;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WebTableSorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//Click on the column header to sort
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		//take all elemenst into the list
		
		List<WebElement> elementlist = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		
		List<String> originallist =elementlist.stream().map(s->s.getText()).collect(Collectors.toList());
		
		//sort the items and take into another list
		
		List<String> Sortedlist = originallist.stream().sorted().collect(Collectors.toList());
		//compare the values

		Assert.assertTrue(originallist.equals(Sortedlist));
		
	//get the price of specific items and handle pagination
		List<String> price;
		do {
			List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr/td[1]"));
			price =rows.stream().filter(s->s.getText().contains("Rice")).map(s->getPricevegie(s)).collect(Collectors.toList());
			price.forEach(s->System.out.println(s));
			if(price.size()<1) {
				driver.findElement(By.cssSelector("[aria-label='Next']")).click();
			}
		}while(price.size()<1);
		
		

	}

	private static String getPricevegie(WebElement s) {
		// TODO Auto-generated method stub
		String price =s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return price;
	}

}
