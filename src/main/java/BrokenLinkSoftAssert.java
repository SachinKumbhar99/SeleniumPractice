import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinkSoftAssert {

	public static void main(String[] args) throws MalformedURLException, IOException, URISyntaxException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		
//		String url = driver.findElement(By.cssSelector("[href*=\"soap\"]")).getAttribute("href");
		
		List<WebElement> links = driver.findElements(By.cssSelector("[id='gf-BIG'] a"));
		
		SoftAssert a = new SoftAssert();
		
		for(WebElement link:links) {
			String uri =  link.getAttribute("href");
			HttpURLConnection conn =(HttpURLConnection)new URI(uri).toURL().openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int respCode = conn.getResponseCode();
			System.out.println("Response Code is "+respCode+"for link "+link.getText()+"");
			a.assertTrue(respCode<400, "The link "+link.getText()+" is broken with Status Code "+respCode+"");
		}
		
		a.assertAll();
		

	}

}
