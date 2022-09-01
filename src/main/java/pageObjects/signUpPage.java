package pageObjects;

import baseSetUp.base;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
    By signUpTod = By.xpath("//a[@id='signupLink']");
    By signUpvrf = By.xpath("//h1[text()='Signup']");
    By countrtCod = By.xpath("//select[@name='npaCountryCode']");
    By valueUSA = By.xpath("//option[@value='USA']");
    By stateCode = By.xpath("//select[@id='stateCode']");
    By valueCA = By.xpath("//option[@value='CA']");
    By areaCod = By.xpath("//select[@id='areaCode']");
    By areaCodOption = By.xpath("//select[@id='areaCode']/option");   //select[@id='areaCode']/option[2]
    By virtualNumResult = By.xpath("(//ul[@id='virtualNumbersResult']/li)[1]");
    By submit = By.xpath("//button[@type='submit']");
    By creatAcct = By.xpath("//section[@class='col-xs-12 col-sm-12 c-onboard__signup--form c-onboard__form  signup-form']/h2");
    By firstName = By.xpath("//input[@id='firstName']");
    By lastName = By.xpath("//input[@id='lastName']");
    By companyName = By.xpath("//input[@id='companyName']");
    By clearEmail = By.xpath("//input[@id='email']");
    By enterPwd = By.xpath("//input[@id='password']");
    By confirmPwd = By.xpath("//input[@id='confirmPassword']");
    By numberSent = By.xpath("//input[@id='mobileNumberFormatted']");
    By termsCond = By.xpath("//a[text()='Terms & Conditions']");
    By agree = By.xpath("//input[@id='agree']");
    By submitPersInfo = By.xpath("//button[@id='submitPersonalInfo']");
    By creditCardForm = By.xpath("//div[@id='credit-card-billing-form']/h2");
    By Adress = By.xpath("//input[@id='address']");
    By City = By.xpath("//input[@id='city']");
    By addName = By.xpath("//input[@id='name']");
    By enterNum = By.xpath("//input[@id='number']");
    By expMonth = By.xpath("//select[@id='ccExpMonth']");
    By expMonthOption = By.xpath("//select[@id='ccExpMonth']/option");
    By expYear = By.xpath("//select[@id='ccExpYear']");
    By expYearOption = By.xpath("//select[@id='ccExpYear']/option");
    By enterCVV = By.xpath("//input[@id='cvv']");
    By submitInfo = By.xpath("//button[@id='submitBillingInfo']");
    By clickUserName = By.xpath("//span[@class='user-name']");
    By clickLogOut = By.xpath("//a[@class=' logout']");

    //This method go to lando and get the title of page
    public String userNavCloudPhn(String URL) throws InterruptedException {
        driver.get(URL);
        driver.manage().window().maximize();
        Thread.sleep(7000);
        return driver.getTitle();
    }

    //Click on signup today and text
    public String signUpToday() {
        driver.findElement(signUpTod).click();
        String vrfSignUpPage = driver.findElement(signUpvrf).getText();
        return vrfSignUpPage;
    }

    //Select country code
    public String TollFreeNumber() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.findElement(countrtCod).click();
        WebDriverWait wait1= new WebDriverWait(driver,Duration.ofSeconds(50));
        wait1.until(ExpectedConditions.visibilityOf(driver.findElement(valueUSA)));
        String TollFree = driver.findElement(valueUSA).getText();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(valueUSA).click();
        Thread.sleep(2800);
        return TollFree;
    }

    //Select state and first number in the list and click on signup
    public boolean stateCityFirstNumber() throws InterruptedException {
        driver.findElement(stateCode).click();
        driver.findElement(valueCA).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(areaCod).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        List<WebElement> ele1 = driver.findElements(areaCodOption);
        ele1.get(2).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
        driver.findElement(virtualNumResult).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        boolean buttonClickable = driver.findElement(submit).isEnabled();
        driver.findElement(submit).click();
        Thread.sleep(3500);
        return buttonClickable;
    }

    //Enter First ,last name and Company name
    public String accountInfo1(String FName, String LName, String CompName) {
        String createAccount = driver.findElement(creatAcct).getText();
        driver.findElement(firstName).sendKeys(FName);
        driver.findElement(lastName).sendKeys(LName);
        driver.findElement(companyName).sendKeys(CompName);
        return createAccount;
    }

    //Generate random number and enter email+random number ,password and mobile number
    public void accountInfo2(String email, String passwd, String confitmPas, String MobNum) {
        driver.findElement(clearEmail).clear();
        //method line 111 generates the Random Number.
        String rand = LocalDateTime.now().toString().substring(22, 25);
        driver.findElement(clearEmail).sendKeys(email + rand + "@tcoff.net");
        driver.findElement(enterPwd).clear();
        driver.findElement(enterPwd).sendKeys(passwd);
        driver.findElement(confirmPwd).clear();
        driver.findElement(confirmPwd).sendKeys(confitmPas);
        driver.findElement(numberSent).clear();
        driver.findElement(numberSent).sendKeys(MobNum);

    }

    //Tick terms & condition
    public String accountInfo3() throws InterruptedException {
        WebDriverWait wait2= new WebDriverWait(driver,Duration.ofSeconds(25));
        wait2.until(ExpectedConditions.visibilityOf(driver.findElement(termsCond)));
        String termsCondition = driver.findElement(termsCond).getText();
        driver.findElement(agree).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(32));
        Actions at = new Actions(driver);
        at.doubleClick(driver.findElement(submitPersInfo));
        at.build().perform();
        Thread.sleep(8000);
        return termsCondition;
    }

    //Check if we are in billing page
    public String checkBillPage() throws InterruptedException {
        Thread.sleep(50000);
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(130));
        wait1.until(ExpectedConditions.visibilityOf(driver.findElement(creditCardForm)));
        String page = driver.findElement(creditCardForm).getText();
        return page;
    }

    //Enter billing address with city
    public void billingAdressInfo1(String adress, String city) {
        //Billing adress
        driver.findElement(Adress).sendKeys(adress);
        //City
        driver.findElement(City).sendKeys(city);
    }


    //Enter card info
    public void billingAdressInfo2(String CcardNmae, String cardNum, String expM, String expY, String SVV) throws InterruptedException {
        //Name On the Card
        driver.findElement(addName).clear();
        driver.findElement(addName).sendKeys(CcardNmae);

        //Credit Card Number
        driver.findElement(enterNum).clear();
        driver.findElement(enterNum).sendKeys(cardNum);

        //EXPDate month
        driver.findElement(expMonth).click();
        List<WebElement> ele3 = driver.findElements(expMonthOption);
        ele3.get(Integer.parseInt(expM)).click();
        Thread.sleep(2300);
        driver.findElement(expYear).click();
        List<WebElement> ele4 = driver.findElements(expYearOption);
        ele4.get(Integer.parseInt(expY)).click();
        driver.findElement(enterCVV).clear();
        driver.findElement(enterCVV).sendKeys(SVV);
        Thread.sleep(5000);

        driver.findElement(submitInfo).click();
    }


    public String checkAccountCreated() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Actions at = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        at.sendKeys(Keys.ESCAPE);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        at.sendKeys(Keys.ESCAPE);
        at.build().perform();
        Thread.sleep(6000);
        WebDriverWait wait4 = new WebDriverWait(driver,Duration.ofSeconds(120));
        wait4.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//article[@class='textToJoin spark-box']/h2"))));
        String accountPageVrf = driver.findElement(By.xpath("//article[@class='textToJoin spark-box']/h2")).getText();
        return accountPageVrf;
    }

    public String signOut() throws InterruptedException {
        Thread.sleep(2800);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(28));
        driver.findElement(clickUserName).click();
        driver.findElement(clickLogOut).click();
        WebDriverWait wait5= new WebDriverWait(driver,Duration.ofSeconds(60));
        wait5.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[text()='Login']"))));
        String vrfSucsesSignedOut = driver.findElement(By.xpath("//h1[text()='Login']")).getText();
        return vrfSucsesSignedOut;

    }
}

