package pageObjects;

import baseSetUp.base;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class addNumRecepPage {
    WebDriver driver = base.driver;
    signInPage sg = new signInPage();

    By clickRecp = By.xpath("//a[@class='is-parent has-arrow']//*[contains(text(),'Receptionist')]/../i[2]");
    By viewRcp = By.xpath("//a[text()='View Receptionists']");
    By addRecep = By.xpath("//a[@id='AUTO_ATTENDANT'][contains(text(),'Add New')]");
    By headerVwRecep = By.xpath("//h3[@class='header-main-page ']");
    By btnAddRecep = By.xpath("//div[@class='spark-box']//*[contains(text(),'Add a Receptionist')]");//08/23/2022
    // By btnAddRecep = By.xpath("//a[@class='btn  addPersonBtn show-block-ui']");//08/23/2022
    By headerAdRecep = By.xpath("//h4[text()]");
    By clickBuyRecep = By.xpath("//button[@type='button'][2]");
    // By GreetClean = By.xpath("//textarea[@id='ttsTextpromptFileId']");
    By GreetWrite = By.xpath("//textarea[@id='ttsTextpromptFileId']");
    By SaveDetail = By.xpath("//button[@id='saveDetail']");
    By verGreet = By.xpath("//td[contains(text(),'Welcome Cloud phone.com')]");
    By clickDeleteRecep = By.xpath("(//td[@class='links delete']/a)[3]");
    By vrfyRecepDeleted = By.xpath("//table[@class='autoattendants']/tbody");
    By logOut = By.xpath("//a[@class=' logout']");
    By userName = By.xpath("//span[@class='user-name']");
    By verLogOut = By.xpath("//div[@class='col-xs-12']/h1");

    public String userLandCloudPhn(String usr, String pwd) throws InterruptedException {
        sg.navSignIN("https://lando-cp-extranet.voxox.com/");
        sg.enterCred(usr, pwd);
        return sg.checkLogeedIn();
    }

    boolean flag = false;
    public String clickRepselectViewRecep() throws InterruptedException {
        try {
            Thread.sleep(2500);
            driver.findElement(clickRecp).click();
            Thread.sleep(3200);
            driver.findElement(viewRcp).click();
        } catch (Exception e) {
            Thread.sleep(2500);
            flag = true;
            driver.findElement(addRecep).click(); //added to UP 08/23/2022
            Thread.sleep(3500);
            //
            driver.findElement(viewRcp).click();
        }

        Thread.sleep(3200);
        String receptionist = driver.findElement(headerVwRecep).getText();
        return receptionist;
    }

    public static String newRecName = "";

    public String clickAddRec() throws InterruptedException {
            driver.findElement(btnAddRecep).click();
            try {
                WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(120));
                WebElement ele1 = driver.findElement(By.xpath("//button[@type='button'][2]"));
                wait1.until(ExpectedConditions.visibilityOf(ele1));
                Thread.sleep(3500);
                ele1.click();
                Thread.sleep(6500);
                newRecName = driver.findElement(By.xpath("//div[@class='ivr-name']/h4")).getText();
            } catch (NoSuchElementException n) {
                Thread.sleep(3500);
                newRecName = driver.findElement(By.xpath("//div[@class='ivr-name']/h4")).getText();
            }
        String verifyAutoRecPage = driver.findElement(headerAdRecep).getText();
        return verifyAutoRecPage;
    }


    public void Modify(String greeting) throws InterruptedException {
        Thread.sleep(2100);
        driver.findElement(GreetWrite).clear();
        driver.findElement(GreetWrite).sendKeys(greeting);

    }

    public void saveChanges() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(SaveDetail).click();

    }

    public void clickviewRecep() throws InterruptedException {
        Thread.sleep(3500);
        driver.findElement(viewRcp).click();

    }

    public String validateGreeting() throws InterruptedException {
        Thread.sleep(3500);
        String validateGreet = driver.findElement(verGreet).getText();
        return validateGreet;
    }

    boolean autoRecNotFound = true;

    public boolean deleteRecep() throws InterruptedException {
        //driver.findElement(clickDeleteRecep).click();
        Thread.sleep(5000);
        List<Integer> rowC = new ArrayList(driver.findElements(By.xpath("//table[@class='autoattendants']/tbody/tr/td[1]")));
        int tableRowC = rowC.size();
        driver.findElement(By.xpath("(//td[@class='links delete']/a)["+tableRowC+"]")).click();
        Thread.sleep(3800);
        for (int i = 1; i < tableRowC; i++) {
            if (driver.findElement(By.xpath("(//table[@class='autoattendants']/tbody/tr/td[1])[" + i + "]")).getText().contains(newRecName)) {
                autoRecNotFound = false;
            }
        }
        return autoRecNotFound;
    }

    public String logedOut() {
        driver.findElement(userName).click();
        driver.findElement(logOut).click();
        String logOut = driver.findElement(verLogOut).getText();
        return logOut;
    }
}





