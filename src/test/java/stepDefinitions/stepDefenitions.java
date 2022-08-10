package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjects.signUpPage;

public class stepDefenitions {
    signUpPage sp = new signUpPage();

    @Given("User to navigate the cloudphone.com")
    public void user_to_navigate_the_cloudphone_com() throws InterruptedException {
        sp.userNavCloudPhn();
    }

    @Then("User should be able to click the ShowMePricing button")
    public void user_should_be_able_to_click_the_show_me_pricing_button() {
        sp.showMePricing();
    }

    @Then("User should be able to  choose the Plan and click GetStarted")
    public void user_should_be_able_to_choose_the_plan_and_click_get_started() {
        sp.choosePlan();
    }

    @Then("User should be able to select TollFreeNumber")
    public void user_should_be_able_to_select_toll_free_number() throws InterruptedException {
        sp.tollFreeNumber();
    }

    @Then("User should be able to select State")
    public void user_should_be_able_to_select_state() {
        sp.stateCode();

    }

    @Then("User should be able to select the city")
    public void user_should_be_able_to_select_the_city() {
        sp.selectTheCity();

    }

    @Then("User should be able to select the first Number on the list")
    public void user_should_be_able_to_select_the_first_number_on_the_list() {
        sp.selectNumber();
    }

    @Then("user should be able to click the continue Button")
    public void user_should_be_able_to_click_the_continue_button() {
        sp.clickContinue();
    }

}
