import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FramesDragDrop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://jqueryui.com/droppable/");
		
		//get the total number of frame
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		
		WebElement frame = driver.findElement(By.cssSelector("[class='demo-frame']"));
		
		driver.switchTo().frame(frame);
		
		//Drag and Drop
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		
		Actions act = new Actions(driver);
		
		act.dragAndDrop(source, target).build().perform();
		
		//switch back to main window
		
		driver.switchTo().defaultContent();
		
		driver.findElement(By.linkText("Draggable")).click();
		
		

	}

}
