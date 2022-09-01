package stepDefinitions;

public class stepDefinitions_Omni {
}

//    signUpPage sp = new signUpPage();
//    signUp_Omni sm = new signUp_Omni();
//    @Given("Omni User to navigate the landingPage")
//    public void omni_user_to_navigate_the_landing_page() throws InterruptedException {
//        Assert.assertTrue(sp.userNavCloudPhn("https://lando-digi-extranet.voxox.com/").contains("Omni"));
//    }
//    @When("Omni User will click the SignUpToday button")
//    public void userWillClickTheSignUpTodayButton() throws IOException {
//        //This is to assert Signup today button
//        Assert.assertEquals(sp.signUpToday(), "SIGNUP");
//    }
//    @When("Omni User  able to select TollFreeNumber")
//    public void omni_user_able_to_select_toll_free_number() throws InterruptedException {
//        Assert.assertTrue(sm.TollFreeNumber().contains("Malaysia"));
//    }
//    @Then("Omni User will select State,city,firstNum and click continue")
//    public void omni_user_will_select_state_city_first_num_and_click_continue() throws InterruptedException {
//        Assert.assertEquals(sm.stateCityFirstNumber(), true);
//    }
//    @Then("Omni User will enter {string},{string},{string}")
//    public void omni_user_will_enter(String FName, String LName, String CompName) {
//        Assert.assertEquals(sp.accountInfo1(FName, LName, CompName), "Create Account");
//    }
//    @Then("Omni User will enter {string},{string},{string},{string}")
//    public void omni_user_will_enter(String email, String passwd, String confmPas, String MobNum) {
//        sm.accountInfo2(email, passwd, confmPas, MobNum);
//    }
//    @Then("Omni User will check box to agree CP Term&Conditions and click continue")
//    public void omni_user_will_check_box_to_agree_cp_term_conditions_and_click_continue() throws InterruptedException {
//        Assert.assertTrue(sm.accountInfo3().contains("Billing Info"));
//    }
//}
