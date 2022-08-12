package pageObjects;

import baseSetUp.base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class signUpPage {
    WebDriver driver = base.driver;

    public void userNavCloudPhn() throws InterruptedException {
        // driver.get("https://yoda-cp-extranet.voxox.com/signupvx");
        driver.get("https://cloudphone.com/");
        driver.manage().window().maximize();
        Thread.sleep(7000);
    }

    public void showMePricing() {
        driver.findElement(By.xpath("(//a[@href='/pricing'])[1]")).click();

    }

    public void choosePlan() {
        driver.findElement(By.xpath("(//*[contains(text(),'Get Started')])[1]")).click();

    }

    public void TollFreeNumber() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.xpath("//select[@name='npaCountryCode']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//option[@value='USA']")).click();
        Thread.sleep(2800);
    }

    public void stateCityFirstNumber() throws InterruptedException {
        driver.findElement(By.xpath("//select[@id='stateCode']")).click();
        driver.findElement(By.xpath("//option[@value='IL']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//select[@id='areaCode']")).click();
        //driver.findElement(By.xpath("//option[@value='312']")).click();
        Thread.sleep(1500);
        List<WebElement> ele1 = driver.findElements(By.xpath("//select[@id='areaCode']/option"));
        ele1.get(1).click();
        // List<WebElement> ele1 = driver.findElements(By.xpath("//ul[@id='virtualNumbersResult']/li"));
        //ele1.get(1).click();
        Thread.sleep(4500);
        driver.findElement(By.xpath("(//ul[@id='virtualNumbersResult']/li)[1]")).click();
        Thread.sleep(2500);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3500);
    }

    public void accountInfo1() {
        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Kayala");
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Musayeva");
        driver.findElement(By.xpath("//input[@id='companyName']")).sendKeys("voxOx");


    }

    public void accountInfo2() {
        driver.findElement(By.xpath("//input[@id='email']")).clear();
        String rand = LocalDateTime.now().toString().substring(22, 25);
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("khayalaTest" + rand + "@voxOx.com");
        driver.findElement(By.xpath("//input[@id='password']")).clear();
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("qwerty");
        driver.findElement(By.xpath("//input[@id='confirmPassword']")).clear();
        driver.findElement(By.xpath("//input[@id='confirmPassword']")).sendKeys("qwerty");
        driver.findElement(By.xpath("//input[@id='mobileNumberFormatted']")).clear();
        driver.findElement(By.xpath("//input[@id='mobileNumberFormatted']")).sendKeys("8728884199");
    }

    public void accountInfo3() throws InterruptedException {
        Thread.sleep(2500);
        driver.findElement(By.xpath("//input[@id='agree']")).click();
        Thread.sleep(3200);
        Actions at = new Actions(driver);
        at.doubleClick(driver.findElement(By.xpath("//button[@id='submitPersonalInfo']")));
        at.build().perform();
        //driver.findElement(By.xpath("//button[@id='submitPersonalInfo']"));
        Thread.sleep(8000);
    }

    public String checkBillPage() throws InterruptedException {
        Thread.sleep(50000);
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(130));
        wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='credit-card-billing-form']/h2"))));
        String page = driver.findElement(By.xpath("//div[@id='credit-card-billing-form']/h2")).getText();
        return page;
    }

    public void billingAdressInfo1() {
        driver.findElement(By.xpath("//input[@id='address']")).sendKeys("5825 Oberlin dr");
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys("San Diego");


    }

    public void billingAdressInfo2() throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='name']")).clear();
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Robert Peter Hertz");
        driver.findElement(By.xpath("//input[@id='number']")).clear();
        driver.findElement(By.xpath("//input[@id='number']")).sendKeys("4427427072264791");
        driver.findElement(By.xpath("//select[@id='ccExpMonth']")).click();
        List<WebElement> ele3 = driver.findElements(By.xpath("//select[@id='ccExpMonth']/option"));
        ele3.get(6).click();
        Thread.sleep(2300);
        driver.findElement(By.xpath("//select[@id='ccExpYear']")).click();
        List<WebElement> ele4 = driver.findElements(By.xpath("//select[@id='ccExpYear']/option"));
        ele4.get(5).click();
        driver.findElement(By.xpath("//input[@id='cvv']")).clear();
        driver.findElement(By.xpath("//input[@id='cvv']")).sendKeys("094");
        Thread.sleep(5000);
        /*
        Actions at = new Actions(driver);
        at.doubleClick(driver.findElement(By.xpath("//button[@id='submitBillingInfo']")));
        at.build().perform();

         */
        driver.findElement(By.xpath("//button[@id='submitBillingInfo']")).click();

    }

    public String checkAccountCreated() throws InterruptedException {
        Thread.sleep(20000);
        /*
        Actions at = new Actions(driver);
        Thread.sleep(1000);
        at.sendKeys(Keys.ESCAPE);
        Thread.sleep(1000);
        at.sendKeys(Keys.ESCAPE);
        at.build().perform();
        Thread.sleep(2500);

         */
        String accountPage = driver.getTitle();
        return accountPage;
    }

    public void signOut() throws InterruptedException {
        Thread.sleep(2800);
        driver.findElement(By.xpath("//span[@class='user-name']")).click();
        Thread.sleep(1200);
        driver.findElement(By.xpath("//a[@class=' logout']")).click();
    }

}


















