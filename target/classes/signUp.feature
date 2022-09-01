Feature: Testing SignUp Page

  @SignUp_Lando
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
      | FName  | LName    | CompName | email       | passwd | confirmPas | MobNum     | adress          | city      | CcardName          | cardNum          | expM | expY | SVV |
             #|Kayala|Musayeva|voxOx  |KhayalaTest |qwerty|qwerty    |8728884199 |5825 Oberlin dr|San Diego|Robert Peter Hertz|4427427072264791 |  6  |5   |094|
      | Kayala | Musayeva | voxOx    | KhayalaTest | qwerty | qwerty     | 8728884199 | 5825 Oberlin dr | San Diego | Robert Peter Hertz | 4242424242424242 | 6    | 5    | 094 |

  @SignUp_Omni
  Scenario Outline:Checking if Omni SignUp page is working properly
    Given Omni User to navigate the landingPage
    When Omni User will click the SignUpToday button
    When Omni User  able to select TollFreeNumber
    Then Omni User will select State,city,firstNum and click continue
    Then Omni User will enter "<FName>","<LName>","<CompName>"
    And  Omni User will enter "<email>","<passwd>","<confirmPas>","<MobNum>"
    Then Omni User will check box to agree CP Term&Conditions and click continue

    Examples:
      | FName       | LName         | CompName | email           | passwd | confirmPas | MobNum     | adress          | city      | CcardName          | cardNum          | expM | expY | SVV |
      | Kayala_Omni | Musayeva_Omni | voxOx    | KhayalaTestomni | qwerty | qwerty     | 0122479707 | 5825 Oberlin dr | San Diego | Robert Peter Hertz | 4242424242424242 | 6    | 5    | 094 |

  @SignUp_Exis
  Scenario Outline:Checking if Exis SignUp page is working properly
    Given Exis User to navigate the landingPage
    When Exis User will click the SignUpToday button
    Then Exis User will select State,city,firstNum and click continue
    Then Exis User will enter "<FName>","<LName>","<CompName>"
    And  Exis User will enter "<email>","<passwd>","<confirmPas>","<MobNum>"
    Then Exis User will check box to agree CP Term&Conditions and click continue
    Then Exis User lands on Billing Info page and Enter Billing "<adress>" and "<city>"
    And  Exis User Enters "<CcardName>","<cardNum>","<expM>","<expY>","<SVV>" and click continue
    Then Exis User will be navigated to the new Account and verify the Page

    Examples:
      | FName       | LName         | CompName | email           | passwd | confirmPas | MobNum      | adress          | city      | CcardName          | cardNum          | expM | expY | SVV |
      | Khayala_Exis | Musayeva_Exis | voxOx    | KhayalaTestExis | qwerty | qwerty     | 8453520151 | 5825 Oberlin dr | San Diego | Robert Peter Hertz | 4111111111111111 | 6    | 5    | 094 |



    #And  Exis User will be able signOut from the Account
     #https://lando-indosat-extranet.voxox.com/

#
  @SignUp_Indosat
  Scenario Outline:Checking if IndoSat SignUp page is working properly
    Given Indo User to navigate the landingPage
    When Indo User will click the SignUpToday button
    Then Indo User will select State,city,firstNum and click continue
    Then Indo User will enter "<FName>","<LName>","<CompName>"
    And  Indo User will enter "<email>","<passwd>","<confirmPas>","<MobNum>"
    Then Indo User will check box to agree CP Term&Conditions and click continue
    And  Indo User Enters "<CcardName>","<cardNum>","<SVV>","<expM>","<expY>","<tesPass>" and click continue
    Then Indo User will be navigated to the new Account Landing Page



    Examples:
     # | FName        | LName         | CompName | email               | passwd | confirmPas | MobNum    | adress          | city      | CcardName         | cardNum          | expM | expY | SVV |
     # | Khayala_Indo | Musayeva_Indo | voxOx   | KhayalaTestIndosat | qwerty | qwerty     | 6253520151 | 5825 Oberlin dr | San Diego | Robert Peter Hertz| 4111111111111111 | 06    | 05    | 094 |
    Examples:
      | FName       | LName         | CompName | email          | passwd | confirmPas  | MobNum    | CcardName          | cardNum          | expM  | expY  | SVV |tesPass|
      | Khayala_Indo| Musayeva_Indo | voxOx    | KhayalaTestIndo| qwerty | qwerty      | 6253520151| Robert Peter Hertz | 4000000000000044 | 03    | 33    | 123 |123456|






  @SignUp_Ring

Scenario Outline:Checking if Ring SignUp page is working properly
  Given Ring User to navigate the landingPage
  When Ring User will click the SignUpToday button
  Then Ring User will select State,city,firstNum and click continue
  Then Ring User will enter "<FName>","<LName>","<CompName>"
  And  Ring User will enter "<email>","<passwd>","<confirmPas>","<MobNum>"
  Then Ring User will check box to agree CP Term&Conditions and click continue
  Then Ring User lands on Billing Info page and Enter Billing "<adress>" and "<city>"
  And  Ring User Enters "<CcardName>","<cardNum>","<expM>","<expY>","<SVV>" and click continue
  Then Ring User will be navigated to the new Account and verify the Page


  Examples:
    | FName       | LName         | CompName     | email           | passwd | confirmPas | MobNum      | adress          | city  | CcardName          | cardNum      | expM  | expY | SVV |
    | Khayala_Ring| Musayeva_Ring | voxOx    | KhayalaTestRing| qwerty | qwerty      | 50685553005 | 5825 Oberlin dr | San Diego | Robert Peter Hertz | 4111111111111111 | 06    | 23    | 094 |




