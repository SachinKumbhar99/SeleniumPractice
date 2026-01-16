package Selenium4Features;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WebtableSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//enter the value in search box
		
		driver.findElement(By.id("search-field")).sendKeys("Rice");
		
		//get all the column elemenst in the list
		List<WebElement> elements =driver.findElements(By.xpath("//tr/td[1]"));
		
		List<WebElement> filteredList =elements.stream().filter(s->s.getText().contains("Rice")).collect(Collectors.toList());
		filteredList.forEach(s->System.out.println(s.getText()));
		Assert.assertEquals(elements.size(), filteredList.size());
	}

}
