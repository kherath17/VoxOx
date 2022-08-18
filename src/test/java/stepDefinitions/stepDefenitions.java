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
    @Given("User to navigate the cloudphone.com")
    public void user_to_navigate_the_cloudphone_com() throws InterruptedException {
       // sp.userNavCloudPhn();
        Assert.assertTrue(sp.userNavCloudPhn().contains("Virtual Phone System for Small Business"));
    }
//Khayala
    @Then("User will click the ShowMePricing button")
    public void user_should_be_able_to_click_the_show_me_pricing_button() {
        // sp.showMePricing();
    Assert.assertEquals(sp.showMePricing(),"Simple & Predictable Pricing");
    }



    @Then("User choose the Plan and click GetStarted")
    public void user_should_be_able_to_choose_the_plan_and_click_get_started() {
       // sp.choosePlan();
        Assert.assertEquals(sp.choosePlan(),"Signup");
        //AssertEq - Assertion -expected and actual  needs to be exactly the same .
    }


    @When("User  able to select TollFreeNumber")
    public void userAbleToSelectTollFreeNumber() throws InterruptedException {
        //sp.TollFreeNumber();
        Assert.assertTrue(sp.TollFreeNumber().contains("United States Local"));
        // AssertTrue will return us true Because Contain() has still that text holds similar United state...
    }
//Kh
    @Then("User will select State,city,firstNumber and click continue")
    public void userShouldBeAbleToSelectStateCityFirstNumberandclickcontinue() throws InterruptedException {
        //sp.stateCityFirstNumber();
        Assert.assertEquals(sp.stateCityFirstNumber(),true);
    //When we use Boolean our expected value either "true",or "false";
    }

//Kh Assertion
    @Then("User will enter FName,LName,CompName")
    public void userEnterDetails1() {
       // sp.accountInfo1();
        Assert.assertEquals(sp.accountInfo1(),"Create Account");
    }

    @And("User will enter email,passwd,confirm passwd ,phone number")
    public void userEnterDetails2() {
        sp.accountInfo2();
    }



    //Khayala verify  terms Condition title
    @Then("User will check box to agree CP Term&Conditions and click continue")
    public void userConfirmnContinue() throws InterruptedException {
       // sp.accountInfo3();
        Assert.assertEquals(sp.accountInfo3(),"Terms & Conditions");

    }

    //"checkBillpage()"-it confirms  and  verify " BillingInfo " headLine
    @Then("User lands on Billing Info page and Enter Billing Addr and City")
    public void userBillInfo1() throws InterruptedException {
        Assert.assertTrue(sp.checkBillPage().contains("Billing Info"));
        sp.billingAdressInfo1();

    }

    @And("User Enters Ccard name,number,expdate,secCode and click continue")
    public void userBillInfo2() throws InterruptedException {
        sp.billingAdressInfo2();

    }

    // There is created new method "checkAccountCreated()"verfy "TextDashboard" HeadLine
    @Then("User will be navigated to the new Account")
    public void userAccountCreated() throws InterruptedException {
      Assert.assertTrue(sp.checkAccountCreated().contains("Text Dashboard"));

    }

}

























