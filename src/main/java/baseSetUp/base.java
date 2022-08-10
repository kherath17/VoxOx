package baseSetUp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class base {
    public static WebDriver driver;

    public static WebDriver baseSetUp(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        return driver;
    }
   public static void tearDown(){
        driver.quit();
    }



}
