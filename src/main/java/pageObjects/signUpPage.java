package pageObjects;

import baseSetUp.base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class signUpPage {
    WebDriver driver = base.driver;

    public void userNavCloudPhn() {
        driver.get("https://cloudphone.com/");

    }

    public void showMePricing() {
        driver.findElement(By.xpath("(//a[@href='/pricing'])[1]")).click();
    }

    public void choosePlan() {
        driver.findElement(By.xpath("(//*[contains(text(),'Get Started')])[1]")).click();
    }

    public void tollFreeNumber() throws InterruptedException {
        driver.findElement(By.xpath("//select[@id='npaCountryCode']")).click();

        Thread.sleep(5000);
        driver.findElement(By.xpath("//option[@value='CAN']")).click();
        Thread.sleep(2800);
    }

    public void stateCode() {
        driver.findElement(By.xpath("//select[@id='stateCode']")).click();
        driver.findElement(By.xpath("//option[@value='IL']")).click();
    }

    public void selectTheCity() {
        driver.findElement(By.xpath("//select[@id='areaCode']")).click();
        driver.findElement(By.xpath("//option[@value='312']")).click();

    }

    public void selectNumber() {
        List<WebElement> ele1 = driver.findElements(By.xpath("//ul[@id='virtualNumbersResult']"));
        ele1.get(1).click();

    }

    public void clickContinue() {
        driver.findElement(By.xpath("//button[@type='submit']")).click();

    }


}



