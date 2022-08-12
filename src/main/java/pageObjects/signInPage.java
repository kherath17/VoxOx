package pageObjects;

import baseSetUp.base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class signInPage {
    WebDriver driver= base.driver;
    signUpPage sp = new signUpPage();

   public void navSignIN() throws InterruptedException {
       //Commenting check how we can send Escape key for popup as of now directed to login url
      // sp.signOut();
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
   }

   public String checkLogeedIn() throws InterruptedException {
       Thread.sleep(6000);
       //driver.switchTo().alert().dismiss();
      // String page = driver.findElement(By.xpath("//span[@class='user-name']")).getText();
       String title = driver.getTitle();
       return title;
   }
}
