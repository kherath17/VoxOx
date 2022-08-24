package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.signInPage;

public class stepDefinition_SignIN {
    signInPage sp = new signInPage();

    @Given("User is able to navigate  Lando Sign in Page")
    public void userIsAbleToNavigateLandoSignInPage() throws InterruptedException {
        sp.navSignIN("https://lando-cp-extranet.voxox.com/");
    }

    @When("User enters {string} , {string} and click login")
    public void userEntersAndClickLogin(String usr,String pwd) throws InterruptedException {
        sp.enterCred(usr,pwd);
    }

    @Then("User should be navigated to logged in page")
    public void loginSucess() throws InterruptedException {
        Assert.assertTrue(sp.checkLogeedIn().contains("Kayala Musayeva"));

    }

    @And("User should be able signOut the  page and verify landed page is correct")
    public void userShouldBeAbleSignOutThePageAndVerifyLandedPageIsCorrect() {
        Assert.assertEquals(sp.signOut(),"Login");


    }



}
