Feature:SignIn Page

  @SignIn
  Scenario Outline:Testing if User is able to SignIn
    Given User is able to navigate  Lando Sign in Page
    When User enters "<username>" , "<password>" and click login
    Then User should be navigated to logged in page
    And User should be able signOut the  page and verify landed page is correct
    Examples:
      | username                    | password |
      | KhayalaTest376@tcoff.net    |   qwerty  |
