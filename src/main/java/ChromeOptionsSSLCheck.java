import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptionsSSLCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		
		
//		//Proxy
//		Proxy proxy = new Proxy();
//		proxy.setHttpProxy("ipaddress:4444");
//		options.setCapability("proxy", proxy);
//		
//		//Set download directory
//		Map<String, Object> prefs = new HashMap<String, Object>();
//		prefs.put("download.default_directory", "/directory/path");
//		options.setExperimentalOption("prefs", prefs);
		
		//Block dialog windows
//		options.setExperimentalOption("excludeSwitches",
//		Arrays.asList("disable-popup-blocking"));
		
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();

		driver.get("https://expired.badssl.com/");
		
		System.out.println(driver.getTitle());

	}

}
