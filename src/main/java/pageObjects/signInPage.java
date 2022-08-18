package pageObjects;
import baseSetUp.base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class signInPage {
    WebDriver driver = base.driver;
    signUpPage sp = new signUpPage();
    public void navSignIN() throws InterruptedException {
        //Commenting check how we can send Escape key for popup as of now directed to login url
        // sp.signOut();
        // we call signUp URL method to SignIN Page because UrL for both Sign In An SinUp are the same .
        sp.userNavCloudPhn();
        driver.findElement(By.xpath("//a[@class='cta_button'][contains(text(),'Login')]")).click();
    }

    public void enterCred() throws InterruptedException {
        Thread.sleep(2500);
        driver.findElement(By.xpath("//input[@id='username']")).clear();
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("khayala.musa@telcentris.com");
        driver.findElement(By.xpath("//input[@id='password']")).clear();
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("505768");
        driver.findElement(By.xpath("//button[@id='submitButton']")).click();

        /*driver.switchTo().alert().dismiss();
        WebElement alert = driver.findElement(By.xpath("//div[text()=\"Not now\"]"));
        alert.click();

         */
        Thread.sleep(10000);
        //driver.findElement(By.xpath("//a[@class='cta_button'][contains(text(),'Login')]")).click();
        //1. pop up needs to be solved


    }

    public String checkLogeedIn() throws InterruptedException {
        Thread.sleep(6000);
        //driver.switchTo().alert().dismiss();
        //String page = driver.findElement(By.xpath("//span[@class='user-name']")).getText();
      //  String title = driver.getTitle();
        //i need to verify userName is appear and verify the name is correct.
        String userVerify = driver.findElement(By.xpath("//span[text()='Sara Motty']")).getText();
        return userVerify;

    }

    public String  signOut() {
        driver.findElement(By.xpath("//span[@class='user-name']")).click();
        driver.findElement(By.xpath("//a[@class=' logout']")).click();
        String logout = driver.findElement(By.xpath("//div[@class='col-xs-12']/h1")).getText();
        return logout;

    }

}






















//PoP UP "whole Box" (xpath)
//div[@class='userflowjs-bubble-frame-root userflowjs-bubble-frame-root--appearance-modal']

//PopUP "Not NOw" (xpath)
//div[text()="Not now"]
//PopUP "Voice" (xpath)
//div[text()="Voice"]
//Pop"Text"(xpath)
//div[text()="Text"]

