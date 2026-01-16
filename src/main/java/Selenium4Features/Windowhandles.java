package Selenium4Features;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Windowhandles {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
//		driver.switchTo().newWindow(WindowType.TAB);
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		
		Set<String> windows =driver.getWindowHandles();
		Iterator<String> it =windows.iterator();
		
		String ParentWindow = it.next();
		String ChildWindow = it.next();
		
		driver.switchTo().window(ChildWindow);
		
		driver.get("https://rahulshettyacademy.com/");
		
		String firstCourse = driver.findElements(By.cssSelector("[class*='font-bold text-lg group']")).get(0).getText();
		
		driver.switchTo().window(ParentWindow);
		
		WebElement editbox =driver.findElement(By.cssSelector("[name='name']"));
		editbox.sendKeys(firstCourse);
		
		//take the scrrenshot of name edit box
		File src =editbox.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("logo.png"));
		
		
		//height and width
		System.out.println(editbox.getRect().getDimension().getHeight());
		System.out.println(editbox.getRect().getDimension().getWidth());
		

	}

}
