Feature: Testing SignUp Page

  @SignUp
  Scenario: Checking if SignUp page is working properly
    Given User to navigate the cloudphone.com
    When User will click the ShowMePricing button
    Then User choose the Plan and click GetStarted
    When User  able to select TollFreeNumber
    Then User will select State,city,firstNumber and click continue
    Then User will enter FName,LName,CompName
    And  User will enter email,passwd,confirm passwd ,phone number
    Then User will check box to agree CP Term&Conditions and click continue
    Then User lands on Billing Info page and Enter Billing Addr and City
    And User Enters Ccard name,number,expdate,secCode and click continue
    Then User will be navigated to the new Account









