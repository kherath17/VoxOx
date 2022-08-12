package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.signUpPage;

public class stepDefenitions {
    signUpPage sp = new signUpPage();

    @Given("User to navigate the cloudphone.com")
    public void user_to_navigate_the_cloudphone_com() throws InterruptedException {
        sp.userNavCloudPhn();
    }

    @Then("User will click the ShowMePricing button")
    public void user_should_be_able_to_click_the_show_me_pricing_button() {
        sp.showMePricing();
    }

    @Then("User choose the Plan and click GetStarted")
    public void user_should_be_able_to_choose_the_plan_and_click_get_started() {
        sp.choosePlan();
    }


    @When("User  able to select TollFreeNumber")
    public void userAbleToSelectTollFreeNumber() throws InterruptedException {
        sp.TollFreeNumber();
    }

    @Then("User will select State,city,firstNumber and click continue")
    public void userShouldBeAbleToSelectStateCityFirstNumberandclickcontinue() throws InterruptedException {
        sp.stateCityFirstNumber();
    }


    @Then("User will enter FName,LName,CompName")
    public void userEnterDetails1() {
        sp.accountInfo1();

    }

    @And("User will enter email,passwd,confirm passwd ,phone number")
    public void userEnterDetails2() {
        sp.accountInfo2();
    }

    @Then("User will check box to agree CP Term&Conditions and click continue")
    public void userConfirmnContinue() throws InterruptedException {
        sp.accountInfo3();

    }



    @Then("User lands on Billing Info page and Enter Billing Addr and City")
    public void userBillInfo1() throws InterruptedException {

        Assert.assertTrue(sp.checkBillPage().contains("Billing Info"));
        sp.billingAdressInfo1();



    }

    @And("User Enters Ccard name,number,expdate,secCode and click continue")
    public void userBillInfo2() throws InterruptedException {
        sp.billingAdressInfo2();
    }

    @Then("User will be navigated to the new Account")
    public void userAccountCreated() throws InterruptedException {
      Assert.assertTrue(sp.checkAccountCreated().contains("Text Dashboard"));

    }

}

























