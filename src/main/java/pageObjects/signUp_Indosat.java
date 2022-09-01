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

public class signUp_Indosat extends signUpPage {
    WebDriver driver = base.driver;
    By signUpvrf = By.xpath("//h1[text()='Mendaftar']");
    By termsCondM = By.xpath("//input[@name='agree']");
    By goToIPay = By.xpath("//a[@id='completePayment']");
    By CardHolderName = By.xpath("//input[@id='chname']");
    By CrediCardNumber = By.xpath("//input[@id='ccn']");
    By CVC = By.xpath("//input[@id='cvc']");
    By EXPmonth = By.xpath("//input[@id='month']");
    By EXPyear = By.xpath("//input[@id='year']");
    By proceedPay = By.xpath("//input[@id='proceed']");
    By testingPassword = By.xpath("//input[@type='password']");
    By verifyLog=By.xpath("//img[@class='cclogo']");
    By confirmTesPass =By.xpath("//input[@type='submit']");



    public String signUpToday() {
        driver.findElement(signUpTod).click();
        String vrfSignUpPage = driver.findElement(signUpvrf).getText();
        return vrfSignUpPage;
    }

    public boolean stateCityFirstNumber() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(stateCode).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); //30


        List<WebElement> states = driver.findElements(By.xpath("//select[@id='stateCode']/option"));


        L1:
        for (int i = 2; i < states.size(); i++) {
            driver.findElement(By.xpath("//select[@id='stateCode']/option[" + i + "]")).click();
            //Thread.sleep(2400);
            driver.findElement(stateCode).click();
            Thread.sleep(1000); //3000
            List<WebElement> areaCode = driver.findElements(By.xpath("//select[@id='areaCode']/option"));
            L2:
            for (int j = 1; j <= areaCode.size(); j++) {
                driver.findElement(areaCod).click();
                //Thread.sleep(2500);
                driver.findElement(By.xpath("//select[@id='areaCode']/option[" + j + "]")).click();
                //Thread.sleep(1000);
                try {
                    driver.findElement(virtualNumResult).click();
                    break L1;
                } catch (Exception e) {
                    continue L2;
                }
            }
        }


        Thread.sleep(1200); //3200
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));  //45
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));  //25
        boolean buttonClickable = driver.findElement(submit).isEnabled();
        driver.findElement(submit).click();
        Thread.sleep(1500);      //3500
        return buttonClickable;
    }

    public String accountInfo3() throws InterruptedException {
        Thread.sleep(3500);
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(25));
        wait2.until(ExpectedConditions.visibilityOf(driver.findElement(termsCondM)));
        driver.findElement(termsCondM).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(32));
        Thread.sleep(2500);
        Actions at = new Actions(driver);
        at.doubleClick(driver.findElement(submitPersInfo));
        at.build().perform();
        Thread.sleep(10000);
        String billText = driver.findElement(By.xpath("//div[@id='credit-card-billing-form']/h2")).getText();
        driver.findElement(goToIPay).click();
        return billText;
    }

    public String billingAdressIndo(String CcardName, String cardNum, String SVV, String expM, String expY,String tesPass) throws InterruptedException {
        //validateCreditCard Page -
        String creditCard = driver.findElement(By.xpath("//label[@class='label_title']")).getText();
        Thread.sleep(1000);
        driver.findElement(CardHolderName).click();
        Thread.sleep(1000);
        driver.findElement(CardHolderName).sendKeys(CcardName);
        Thread.sleep(1000);
        driver.findElement(CrediCardNumber).click();
        Thread.sleep(1000);
        driver.findElement(CrediCardNumber).sendKeys(cardNum);
        Thread.sleep(1000);
        driver.findElement(CVC).click();
        Thread.sleep(1000);
        driver.findElement(CVC).sendKeys(SVV);
//        List<WebElement> ele3 = driver.findElements(expMonthOption);
//        ele3.get(Integer.parseInt(expM)).click();

        Thread.sleep(2300);
        driver.findElement(EXPmonth).click();
        driver.findElement(EXPmonth).sendKeys(expM);
        Thread.sleep(2300);
        driver.findElement(EXPyear).click();
        driver.findElement(EXPyear).sendKeys(expY);
        Thread.sleep(2300);
        driver.findElement(proceedPay).click();
        Thread.sleep(1000);
        driver.findElement(testingPassword).sendKeys(tesPass);
        driver.findElement(confirmTesPass).click();
        Thread.sleep(7200);
        return creditCard;
    }

    public String verifyNewAcc(){
        return driver.findElement(By.xpath("//h3[@class='header-main-page ']")).getText();
    }
    public void addNewNumber(){

   driver.findElement(By.xpath(""));













    }
}



