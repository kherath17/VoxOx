package pageObjects;

import baseSetUp.base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class signUp_Exis extends signUpPage{
    WebDriver driver= base.driver;
    By countryCode = By.xpath("//select[@id='stateCode']");
    By valueAz = By.xpath("//option[@value='AZ']");
    By termsCondM = By.xpath("//input[@name='agree']");
    By signUpvrf = By.xpath("//h1[text()='Registro']");

    public String signUpToday() {
        driver.findElement(signUpTod).click();
        String vrfSignUpPage = driver.findElement(signUpvrf).getText();
        return vrfSignUpPage;
    }

    public boolean stateCityFirstNumber() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(stateCode).click();
        driver.findElement(valueAz).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(areaCod).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        List<WebElement> ele1 = driver.findElements(areaCodOption);
        ele1.get(1).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
        driver.findElement(virtualNumResult).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        boolean buttonClickable = driver.findElement(submit).isEnabled();
        driver.findElement(submit).click();
        Thread.sleep(3500);
        return buttonClickable;
    }
    public String accountInfo3() throws InterruptedException {
        Thread.sleep(3500);
        driver.findElement(By.xpath("//input[@name='companyTaxId']")).sendKeys("12345");

        WebDriverWait wait2= new WebDriverWait(driver,Duration.ofSeconds(25));
        wait2.until(ExpectedConditions.visibilityOf(driver.findElement(termsCondM)));
        //String termsCondition = driver.findElement(termsCondM).getText();
        driver.findElement(termsCondM).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(32));
        Thread.sleep(2500);
        Actions at = new Actions(driver);
        at.doubleClick(driver.findElement(submitPersInfo));
        at.build().perform();
        Thread.sleep(10000);
        String billText = driver.findElement(By.xpath("//div[@id='credit-card-billing-form']/h2")).getText();
        return billText;
    }

}
