package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.signUpPage;
import pageObjects.signUp_Indosat;

import java.io.IOException;

public class stepDefinition_Indosat {

    signUpPage sp = new signUpPage();
    signUp_Indosat indo = new signUp_Indosat();

    @Given("Indo User to navigate the landingPage")
    public void indo_user_to_navigate_the_landing_page() throws InterruptedException {
        Assert.assertTrue(sp.userNavCloudPhn("https://lando-indosat-extranet.voxox.com/").contains("CVL"));
    }

    @When("Indo User will click the SignUpToday button")
    public void indo_userWillClickTheSignUpTodayButton() throws IOException {
        //This is to assert Signup today button
        Assert.assertTrue(indo.signUpToday().contains("MENDAFTAR"));
    }

    @Then("Indo User will select State,city,firstNum and click continue")
    public void indo_userWillSelectStateCityFirstNumAndClickContinue() throws InterruptedException {
        Assert.assertEquals(indo.stateCityFirstNumber(), true);
    }

    @Then("Indo User will enter {string},{string},{string}")
    public void indo_user_will_enter(String FName, String LName, String CompName) {
        Assert.assertEquals(indo.accountInfo1(FName, LName, CompName), "Buat Akun");
    }

    @Then("Indo User will enter {string},{string},{string},{string}")
    public void indo_user_will_enter(String email, String passwd, String confmPas, String MobNum) {
        indo.accountInfo2(email, passwd, confmPas, MobNum);
    }

    @Then("Indo User will check box to agree CP Term&Conditions and click continue")
    public void indo_user_will_check_box_to_agree_cp_term_conditions_and_click_continue() throws InterruptedException {
        Assert.assertTrue(indo.accountInfo3().contains("Informasi Tagihan"));
    }


    @And("Indo User Enters {string},{string},{string},{string},{string},{string} and click continue")
    public void indo_userEntersExpdateAndClickContinue(String CcardName, String cardNum, String SVV, String expM, String expY, String tesPass) throws InterruptedException {
        Assert.assertTrue(indo.billingAdressIndo(CcardName, cardNum, SVV, expM, expY, tesPass).contains("Credit/Debit Card"));
    }

    @Then("Indo User will be navigated to the new Account Landing Page")
    public void indo_userNewAcc() throws InterruptedException {
        Assert.assertTrue(indo.verifyNewAcc().contains("Dasbor"));
    }

}









