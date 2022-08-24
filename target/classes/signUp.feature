Feature: Testing SignUp Page

  @SignUp
  Scenario Outline:Checking if SignUp page is working properly
    Given User to navigate the landingPage
    When User will click the SignUpToday button
    When User  able to select TollFreeNumber
    Then User will select State,city,firstNum and click continue
    Then User will enter "<FName>","<LName>","<CompName>"
    And  User will enter "<email>","<passwd>","<confirmPas>","<MobNum>"
    Then User will check box to agree CP Term&Conditions and click continue
    Then User lands on Billing Info page and Enter Billing "<adress>" and "<city>"
    And  User Enters "<CcardName>","<cardNum>","<expM>","<expY>","<SVV>" and click continue
    Then User will be navigated to the new Account and verify the Page
    And User will be able signOut from the Account

   Examples:
             |FName |LName   |CompName|email      |passwd|confirmPas|MobNum     |adress         |city     |CcardName        |cardNum           |expM |expY|SVV|
             #|Kayala|Musayeva|voxOx  |KhayalaTest |qwerty|qwerty    |8728884199 |5825 Oberlin dr|San Diego|Robert Peter Hertz|4427427072264791 |  6  |5   |094|
             |Kayala|Musayeva|voxOx  |KhayalaTest |qwerty|qwerty    |8728884199 |5825 Oberlin dr|San Diego|Robert Peter Hertz|4242424242424242 |  6  |5   |094|








