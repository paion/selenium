@functional
Feature: feature to test login functionally

  @positive
  Scenario: Finding some cheese
    Given I am on the Google search page
    When I search for "Cheese!" text
    Then the page title should start with "cheese"

   @negative
  Scenario: Finding some thing
    Given I am on the Yahoo search page chhggf h to test
    When I search for "Cheese" text
    And I search for "butter!" tex
    Then the page title should start with "cheese"


  @pending @regression @loginebateslogin.feature
  Scenario Outline: Check login is successfull with valid credentials

    Given user is on login page

    When user enters <username> and <password>
    And clcks on login button
    Then user is navigated to the home page

    Examples:
      | username | password |
      | user1    | pass1    |
      | user2    | Pass2    |