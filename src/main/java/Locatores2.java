import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locatores2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String name= "Sachin";

		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		String password=getpassword(driver);
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		
		driver.findElement(By.className("signInBtn")).click();
		
		Thread.sleep(2000);
		
		System.out.println(driver.findElement(By.tagName("p")).getText());
		
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"You are successfully logged in." );
		
		
		System.out.println(driver.findElement(By.cssSelector("h2")).getText());
		
		Assert.assertEquals(driver.findElement(By.cssSelector("h2")).getText(),"Hello "+name+"," );
		
		driver.findElement(By.xpath("//button[text()=\"Log Out\"]")).click();
		
		driver.close();
	}
	
	
	public static String getpassword(WebDriver driver) throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String text= driver.findElement(By.cssSelector("form p")).getText();
		
		String[] splittext=text.split("'");
		
		//splittext[0]=  Please use temporary password 
		//splittext[1]=  rahulshettyacademy' to Login.
		
		String password=splittext[1].split("'")[0];
		
		return password;
	}
	

}
