package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.signUpPage;
import pageObjects.signUp_Exis;
import java.io.IOException;

public class stepDefenition_Exis {

    signUpPage sp = new signUpPage();
    signUp_Exis se = new signUp_Exis();


    @Given("Exis User to navigate the landingPage")
    public void exis_user_to_navigate_the_landing_page() throws InterruptedException {
        Assert.assertTrue(sp.userNavCloudPhn("https://lando-exis-extranet.voxox.com/").contains("Exis"));
    }
    @When("Exis User will click the SignUpToday button")
    public void userWillClickTheSignUpTodayButton() throws IOException {
        //This is to assert Signup today button
        Assert.assertEquals(se.signUpToday(), "REGISTRO");
    }

    @Then("Exis User will select State,city,firstNum and click continue")
    public void omni_user_will_select_state_city_first_num_and_click_continue() throws InterruptedException {
        Assert.assertEquals(se.stateCityFirstNumber(), true);
    }
    @Then("Exis User will enter {string},{string},{string}")
    public void omni_user_will_enter(String FName, String LName, String CompName) {
        Assert.assertEquals(sp.accountInfo1(FName, LName, CompName), "Crear Una Cuenta");
    }
    @Then("Exis User will enter {string},{string},{string},{string}")
    public void omni_user_will_enter(String email, String passwd, String confmPas, String MobNum) {
        se.accountInfo2(email, passwd, confmPas, MobNum);
    }
    @Then("Exis User will check box to agree CP Term&Conditions and click continue")
    public void omni_user_will_check_box_to_agree_cp_term_conditions_and_click_continue() throws InterruptedException {
        Assert.assertTrue(se.accountInfo3().contains("Información"));
    }
    @Then("Exis User lands on Billing Info page and Enter Billing {string} and {string}")
    public void exisuserLandsOnBillingInfoPageAndEnterBillingAnd(String adress, String city) throws InterruptedException {
        Assert.assertTrue(sp.checkBillPage().contains("Información"));
        sp.billingAdressInfo1(adress, city);
    }
    @And("Exis User Enters {string},{string},{string},{string},{string} and click continue")
    public void userEntersExpdateAndClickContinue(String CcardNmae, String cardNum, String expM, String expY, String SVV) throws InterruptedException {
        sp.billingAdressInfo2(CcardNmae, cardNum, expM, expY, SVV);
    }

}







