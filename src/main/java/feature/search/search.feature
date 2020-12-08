Feature: feature to test login functionally

  Scenario: Finding some cheese
    Given I am on the Google search page
    When I search for "Cheese!"
    Then the page title should start with "cheese"

  @positive
  Scenario Outline: Check login is successfull with valid credentials

    Given user is on login page

    When user enters <username> and <password>
    And clcks on login button
    Then user is navigated to the home page

    Examples:
      | username | password |
      | user1    | pass1    |
      | user2    | Pass2    |