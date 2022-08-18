package pageObjects;
import baseSetUp.base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class addNumRecepPage {
    WebDriver driver = base.driver;
    signInPage sg = new signInPage();

    public String userLandCloudPhn() throws InterruptedException {
        sg.navSignIN();
        sg.enterCred();
        return sg.checkLogeedIn();
    }
    public String clickRepselectViewRecep() throws InterruptedException {
        //wrong xpath line 16 and line 17
        Thread.sleep(2500);
        driver.findElement(By.xpath("//a[@class='is-parent has-arrow']//*[contains(text(),'Receptionist')]/../i[2]")).click();
        Thread.sleep(3200);
        driver.findElement(By.xpath("//a[text()='View Receptionists']")).click();
        Thread.sleep(3500);
      String receptionist = driver.findElement(By.xpath("//h3[@class='header-main-page ']")).getText();
       return receptionist;
        //validation needs to be here Regeptionist page landed
    }
//Xpath need to be fixed:
    public String  clickAddRec() throws InterruptedException {
        //xpath line 25 wrong
        Thread.sleep(5000);
        //driver.findElement(By.xpath("(//a[@id='AUTO_ATTENDANT'])[2]")).click();
        WebElement ele = driver.findElement(By.xpath("//div[@class='spark-box']//*[contains(text(),'Add a Receptionist')]"));
        ele.click();
        Thread.sleep(3200);
         String verifyAutoRecPage= driver.findElement(By.xpath("//h4[text()]")).getText();
       return verifyAutoRecPage;
}

////textarea[@class='ttsTextArea']
public void Modify() throws InterruptedException {
        Thread.sleep(2100);
    driver.findElement(By.xpath("//textarea[@id='ttsTextpromptFileId']")).clear();
    driver.findElement(By.xpath("//textarea[@id='ttsTextpromptFileId']")).sendKeys("Welcome Cloud phone.com");

}
public void saveChanges() throws InterruptedException {
        //add wait time before clicking save
    Thread.sleep(1000);

    driver.findElement(By.xpath("//button[@id='saveDetail']")).click();

}

public String   clickviewRecep() throws InterruptedException {
//    driver.findElement(By.xpath("//a[@class='is-parent has-arrow']//*[contains(text(),'Receptionist')]")).click();
//driver.findElement(By.xpath("//a[text()='View Receptionists']")).click();
return this.clickRepselectViewRecep();
    }

public String validateGreeting() throws InterruptedException {
        Thread.sleep(3500);
    String validateGreet = driver.findElement(By.xpath("//td[contains(text(),'Welcome Cloud phone.com')]")).getText();
    return validateGreet;
}

//Go back to view recptionist and delete the last record

       public String  logedOut() {
    driver.findElement(By.xpath("//span[@class='user-name']")).click();
   driver.findElement(By.xpath("//a[@class=' logout']")).click();
 String logOut = driver.findElement(By.xpath("//div[@class='col-xs-12']/h1")).getText();
return logOut;

   }

}



