package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.signInPage;

public class stepDefinition_SignIN {
    signInPage sp = new signInPage();

    @Given("User is able to navigate the Sign in Page")
    public void userNavSignIn() throws InterruptedException {
        sp.navSignIN();
    }

    @When("User enters username , password and click login")
    public void userEnterCred() throws InterruptedException {
        sp.enterCred();
    }

    @Then("User should be navigated to logged in page")
    public void loginSucess() throws InterruptedException {
        Assert.assertTrue(sp.checkLogeedIn().contains("Text Dashboard"));
    }
}
