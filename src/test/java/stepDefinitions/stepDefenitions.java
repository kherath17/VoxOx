package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.signUpPage;

public class stepDefenitions {
    signUpPage sp = new signUpPage();

    //added assertion
    @Given("User to navigate the landingPage")
    public void user_to_navigate_the_cloudphone_com() throws InterruptedException {
        //Keeping method at line 16 if Company change URL again
        //Assert.assertTrue(sp.userNavCloudPhn().contains("Virtual Phone System for Small Business"));
        Assert.assertTrue(sp.userNavCloudPhn("https://lando-cp-extranet.voxox.com/").contains("Cloudphone.com"));
    }

    @When("User will click the SignUpToday button")
    public void userWillClickTheSignUpTodayButton() {
        //This is to assert Signup today button
        Assert.assertEquals(sp.signUpToday(), "Signup");
    }


    @When("User  able to select TollFreeNumber")
    public void userAbleToSelectTollFreeNumber() throws InterruptedException {
        Assert.assertTrue(sp.TollFreeNumber().contains("United States Local"));
    }

    @Then("User will select State,city,firstNum and click continue")
    public void userWillSelectStateCityFirstNumAndClickContinue() throws InterruptedException {
        Assert.assertEquals(sp.stateCityFirstNumber(), true);
    }

    @Then("User will enter {string},{string},{string}")
    public void userWillEnter(String FName, String LName, String CompName) {
        Assert.assertEquals(sp.accountInfo1(FName, LName, CompName), "Create Account");
    }

    @And("User will enter {string},{string},{string},{string}")
    public void userWillEnter(String email, String passwd, String confitmPas, String MobNum) {
        sp.accountInfo2(email, passwd, confitmPas, MobNum);
    }


    @Then("User will check box to agree CP Term&Conditions and click continue")
    public void userWillCheckBoxToAgreeCPTermConditionsAndClickContinue() throws InterruptedException {
        Assert.assertEquals(sp.accountInfo3(), "Terms & Conditions");

    }


    @Then("User lands on Billing Info page and Enter Billing {string} and {string}")
    public void userLandsOnBillingInfoPageAndEnterBillingAnd(String adress, String city) throws InterruptedException {
        Assert.assertTrue(sp.checkBillPage().contains("Billing Info"));
        sp.billingAdressInfo1(adress, city);
    }

    @And("User Enters {string},{string},{string},{string},{string} and click continue")
    public void userEntersExpdateAndClickContinue(String CcardNmae, String cardNum, String expM, String expY, String SVV) throws InterruptedException {
        sp.billingAdressInfo2(CcardNmae, cardNum, expM, expY, SVV);
    }


    @Then("User will be navigated to the new Account and verify the Page")//Assert08/23/2022
    public void userWillBeNavigatedToTheNewAccountAndVerifyThePage() throws InterruptedException {
        Assert.assertEquals(sp.checkAccountCreated(),"Your Business Number");
    }

    @And("User will be able signOut from the Account") //Assert 08/23/2022
    public void userWillBeAbleSignOutFromTheAccount() throws InterruptedException {
       Assert.assertEquals(sp.signOut(),"Login");
    }
}


























