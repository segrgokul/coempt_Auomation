package browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BrowserManager {
    public static WebDriver driver;

    public static void Browser_Launch() {
        // Create a Properties object to load the property file
        Properties properties = new Properties();
        
        try {
            // Load the config.properties file
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/config.properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Get the browser value from the properties file
        String browser = properties.getProperty("browser", "chrome").toLowerCase();  // Default to "chrome" if not set
        
        // Launch the browser based on the value in the properties file
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;

            case "safari":
                // Safari driver is built-in on macOS, no need to use WebDriverManager
                driver = new SafariDriver();
                break;

            default:
                System.out.println("Invalid browser selection.");
                return;
        }

        // Maximize the browser window
        driver.manage().window().maximize();

        // Open a website
        driver.get("http://103.154.253.118:81/");

        // Close the browser (optional)
        // driver.quit();
    }
}