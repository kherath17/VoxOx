package pageObjects;

import baseSetUp.base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class signInPage {
    WebDriver driver = base.driver;
    signUpPage sp = new signUpPage();

    By enterUserName = By.xpath("//input[@id='username']");
    By enterPwd = By.xpath("//input[@id='password']");
    By submitButton = By.xpath("//button[@id='submitButton']");
    By vrfSaraMotty = By.xpath("//span[text()='Kayala Musayeva']");
    By clickUserNameSignOut = By.xpath("//span[@class='user-name']");
    By clickLogOut = By.xpath("//a[@class=' logout']");
    By vrfLogOut = By.xpath("//div[@class='col-xs-12']/h1");

    public void navSignIN(String URL) throws InterruptedException {
        // we call signUp URL method to SignIN Page because UrL for both Sign In An SinUp are the same .
        sp.userNavCloudPhn(URL);
    }

    public void enterCred(String usr, String pwd) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.findElement(enterUserName).clear();
        driver.findElement(enterUserName).sendKeys(usr);
        driver.findElement(enterPwd).clear();
        driver.findElement(enterPwd).sendKeys(pwd);
        driver.findElement(submitButton).click();
        Thread.sleep(10000);
    }

    public String checkLogeedIn() throws InterruptedException {
        Thread.sleep(6000);
        String userVerify = driver.findElement(vrfSaraMotty).getText();
        return userVerify;
    }

    public String signOut() {
        driver.findElement(clickUserNameSignOut).click();
        driver.findElement(clickLogOut).click();
        String logout = driver.findElement(vrfLogOut).getText();
        return logout;
    }
}

