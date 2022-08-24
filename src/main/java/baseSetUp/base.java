package baseSetUp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {
    public static WebDriver driver;

    public static WebDriver baseSetUp(String browser) {
        WebDriverManager.chromedriver().setup();
        switch (browser) {
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "IE":
                driver = new InternetExplorerDriver();
                break;
            default:
                System.out.println("browser : " + browser + " is invalid, Launching Firefox as browser of choice..");
                driver = new FirefoxDriver();
        }
        return driver;
    }



    public static void tearDown() {
        driver.quit();

    }
}