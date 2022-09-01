package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.addNumRecepPage;

public class stepDefinitions_addAutoRecep {
    addNumRecepPage addNum = new addNumRecepPage();

    @Given("User should be able  land CloudPhone.com and SignIn using {string},{string}")
    public void userShouldBeAbleLandCloudPhoneComAndSignIn(String usr, String pwd) throws InterruptedException {
        Assert.assertTrue(addNum.userLandCloudPhn(usr, pwd).contains("Kayala Musayeva"));
    }

    @When("User click Rectionis,selecting ViewRecept and Validate the page")
    public void userClickRectionisSelectingViewReceptAndValidateThePage() throws InterruptedException {
        Assert.assertEquals(addNum.clickRepSelectViewRecep(), "Receptionist");//this is fixed 08/23/2022 was receptionist
    }


    @Then("User should be able to  click AddRecep-ist Button")
    public void userShouldBeAbleToClickAddRecepIstButton() throws InterruptedException {
        Assert.assertTrue(addNum.clickAddRec().contains("AUTOMATED RECEPTIONIST"));
    }

    @And("User able clean the greeting box and write new {string}")
    public void userAbleCleanTheGreetingBoxAndWriteNewGreeting(String greeting) throws InterruptedException {
        addNum.Modify(greeting);
    }

    @And("User should be able to click the saveChanges button")
    public void userShouldBeAbleToClickTheSaveChangesButton() throws InterruptedException {
        addNum.saveChanges();
    }

    @Then("User again click the View Recepst and find AddedRecep")
    public void userAgainClickTheViewRecepstAndFindAddedRecep() throws InterruptedException {
        //Assert.assertEquals(addNum.clickviewRecep(), "Receptionist");
        addNum.clickviewRecep();
    }

    @And("Also  User checks that Greeting message is there.")
    public void alsoUserChecksThatGreetingMessageIsThere() throws InterruptedException {
        Assert.assertEquals(addNum.validateGreeting(), "Welcome Cloud phone.com");
    }


    @Then("User is able to delete the last Receptionist and vrf Deleted")
    public void userIsAbleToDeleteTheLastReceptionistAndVrfDeleted() throws InterruptedException {
        Assert.assertNotEquals(addNum.deleteRecep(),addNum.newRecName);
    }


}












