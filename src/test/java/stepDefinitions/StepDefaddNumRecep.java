package stepDefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.addNumRecepPage;

public class StepDefaddNumRecep {
    addNumRecepPage addNum = new addNumRecepPage();

    @Given("User should be able  land CloudPhone.com and SignIn")
    public void userShouldBeAbleLandCloudPhoneComAndSignIn() throws InterruptedException {
       //addNum.userLandCloudPhn();
        Assert.assertTrue(addNum.userLandCloudPhn().contains("Sara Motty"));
    }
    @When("User click Rectionis,selecting ViewRecept and Validate the page")
    public void userClickRectionisSelectingViewReceptAndValidateThePage() throws InterruptedException {
       // addNum.clickRepselectViewRecep();
       Assert.assertEquals(addNum.clickRepselectViewRecep(),"Receptionist");
    }


    @Then("User should be able to  click AddRecep-ist Button")
    public void userShouldBeAbleToClickAddRecepIstButton() throws InterruptedException {
        //addNum.clickAddRec();
        //Assert.assertEquals(addNum.clickAddRec(),"Automated Receptionist");
        Assert.assertTrue(addNum.clickAddRec().contains("AUTOMATED RECEPTIONIST"));
    }
        @And("User able clean the greeting box and write new Greeting")
        public void userAbleCleanTheGreetingBoxAndWriteNewGreeting() throws InterruptedException {
    addNum.Modify();
    }

    @And("User should be able to click the saveChanges button")
    public void userShouldBeAbleToClickTheSaveChangesButton() throws InterruptedException {
   addNum.saveChanges();
    }
    @Then("User again click the View Recepst and find AddedRecep")
    public void userAgainClickTheViewRecepstAndFindAddedRecep() throws InterruptedException {
   //addNum.clickviewRecep();
        Assert.assertEquals(addNum.clickviewRecep(),"Receptionist");
    }

    @And("Also  User checks that Greeting message is there.")
    public void alsoUserChecksThatGreetingMessageIsThere() throws InterruptedException {
       // addNum.validateGreeting();
        Assert.assertEquals(addNum.validateGreeting(),"Welcome Cloud phone.com");
        }
}








