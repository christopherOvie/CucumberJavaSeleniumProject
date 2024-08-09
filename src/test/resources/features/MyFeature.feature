Feature: Log in Feature

  @SmokeTest
  Scenario Outline: I can log in with valid credentials
    Given Application should be started in Browser
    When I enter the valid  "<userName>"
    And I enter valid "<password>"
    Then I verify that user logged in and see message as  "<expectedSucessMessage>"
    And "<userName>" sees Congratulations "<userName>". You successfully logged in!

    Examples: 
      | userName | password    | expectedSucessMessage  |
      | student  | Password123 | Logged In Successfully |

  Scenario Outline: Test case 2: Negative username test
    Given Application should be started in Browser
    When I enter the valid  "<userName>"
    And I enter valid "<password>"
    Then I verify that user see error message as "<expectedErrorMessage>"

    Examples: 
      | userName | password    | expectedErrorMessage      |
      | student1 | Password123 | Your username is invalid! |

  Scenario Outline: Test case 3:  Negative password test
    Given Application should be started in Browser
    When I enter the valid  "<userName>"
    And I enter valid "<password>"
    Then I verify that user see error message as "<expectedErrorMessage>"

    Examples: 
      | userName | password   | expectedErrorMessage      |
      | student  | Password12 | Your password is invalid! |

  @RegressionTest
  Scenario Outline: Test case 4: Negative  test
    Given Application should be started in Browser
    When I enter the valid  "<userName>"
    And I enter valid "<password>"
    Then I verify that user see error message as "<expectedErrorMessage>"

    Examples: 
      | userName | password    | expectedErrorMessage      |
      | student1 | Password123 | Your username is invalid! |
      | student  | Password12  | Your password is invalid! |
