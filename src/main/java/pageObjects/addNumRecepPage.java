package pageObjects;

import baseSetUp.base;
import org.openqa.selenium.*;
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
    By headerAdRecep = By.xpath("//h4[text()]");
    By GreetWrite = By.xpath("//textarea[@id='ttsTextpromptFileId']");
    By SaveDetail = By.xpath("//button[@id='saveDetail']");
    By verGreet = By.xpath("//td[contains(text(),'Welcome Cloud phone.com')]");
    By logOut = By.xpath("//a[@class=' logout']");
    By userName = By.xpath("//span[@class='user-name']");
    By verLogOut = By.xpath("//div[@class='col-xs-12']/h1");

    public String userLandCloudPhn(String usr, String pwd) throws InterruptedException {
        sg.navSignIN("https://lando-cp-extranet.voxox.com/");
        sg.enterCred(usr, pwd);
        return sg.checkLogeedIn();
    }

    boolean flag = false;

    public String clickRepSelectViewRecep() throws InterruptedException {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
            driver.findElement(clickRecp).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(32));
            driver.findElement(viewRcp).click();
        } catch (Exception e) {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
            flag = true;
            driver.findElement(addRecep).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
            driver.findElement(viewRcp).click();
        }
        //leave 59 as it is
        Thread.sleep(3200);
        String receptionist = driver.findElement(headerVwRecep).getText();
        return receptionist;
    }

    public static String newRecName = "";

    public String clickAddRec() throws InterruptedException {
        driver.findElement(btnAddRecep).click();
        try {
            WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(3000));
            WebElement ele1 = driver.findElement(By.xpath("//button[@type='button'][2]"));
            wait1.until(ExpectedConditions.visibilityOf(ele1));
            ele1.click();
            Thread.sleep(4500);
            newRecName = driver.findElement(By.xpath("//div[@class='ivr-name']/h4")).getText();//Header "Automated Receptionist 52" added to empety variable
        } catch (NoSuchElementException n) {
            WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(120));
            wait3.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='ivr-name']/h4"))));
            newRecName = driver.findElement(By.xpath("//div[@class='ivr-name']/h4")).getText();
        }
        String verifyAutoRecPage = driver.findElement(headerAdRecep).getText();
        return verifyAutoRecPage;
    }


    public void Modify(String greeting) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
        driver.findElement(GreetWrite).clear();
        driver.findElement(GreetWrite).sendKeys(greeting);

    }

    public void saveChanges() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1500));
        driver.findElement(SaveDetail).click();

    }

    public void clickviewRecep() throws InterruptedException {
        //leaving 99 as it is
        Thread.sleep(3500);
        driver.findElement(viewRcp).click();

    }

    public String validateGreeting() throws InterruptedException {
        WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(400));
        wait4.until(ExpectedConditions.visibilityOf(driver.findElement(verGreet)));
        String validateGreet = driver.findElement(verGreet).getText();
        return validateGreet;
    }


    static String autoRecNotFound = "";

    public String deleteRecep() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2300));
        List<Integer> rowC = new ArrayList(driver.findElements(By.xpath("//table[@class='autoattendants']/tbody/tr/td[1]")));
        int tableRowC = rowC.size();
        Thread.sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//td[@class='links delete']/a)[" + tableRowC + "]")));
        Thread.sleep(2500);
        driver.navigate().refresh();
        Thread.sleep(5000);
        List<Integer> rowCAftDel = new ArrayList(driver.findElements(By.xpath("//table[@class='autoattendants']/tbody/tr/td[1]")));
        int tableRowCAftDel = rowCAftDel.size();
        autoRecNotFound = driver.findElement(By.xpath("(//table[@class='autoattendants']/tbody/tr/td[1])[" + tableRowCAftDel + "]")).getText();
        return autoRecNotFound.toUpperCase();
    }

    public String logedOut() {
        driver.findElement(userName).click();
        driver.findElement(logOut).click();
        String logOut = driver.findElement(verLogOut).getText();
        return logOut;
    }
}
