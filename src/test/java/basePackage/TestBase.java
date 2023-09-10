package basePackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	public static Properties prop = new Properties();
	public static WebDriver driver;

	public TestBase() {
		try {
			FileInputStream file = new FileInputStream("C:\\Users\\princ\\eclipse-workspace\\AmazonCanada\\src\\test\\java\\environmentVariables\\config.properties");
			prop.load(file);
			System.out.println("Properties Loaded: " + prop);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException a) {
			a.printStackTrace();
		}
	}


	public static void initialization() {
		String browsername = prop.getProperty("browser");
		System.out.println("Browser Name from Properties: " + browsername);
		if (browsername.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\princ\\eclipse-workspace\\AmazonCanada\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browsername.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\princ\\Downloads\\geckodriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("url"));
	}

	// Removed closeDriver method for PomSignin to inherit and continue from
	// homepage

	public static WebDriver getDriver() {
		return driver;
	}

	public static String getProperty(String propertyName) {
		return prop.getProperty(propertyName);
	}
}
