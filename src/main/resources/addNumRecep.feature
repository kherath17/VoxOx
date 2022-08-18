Feature:  Testing Add Number to Receptionist.

  @addNum
  Scenario: Checking if  phone number can be added to AutoReception
   Given User should be able  land CloudPhone.com and SignIn
    When User click Rectionis,selecting ViewRecept and Validate the page
    Then  User should be able to  click AddRecep-ist Button
    And  User able clean the greeting box and write new Greeting
    Then  User should be able to click the saveChanges button
    Then User again click the View Recepst and find AddedRecep
    And  Also  User checks that Greeting message is there.

