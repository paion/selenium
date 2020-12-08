Feature: ebateslogin
Scenario: Successsfull Login with valid Credentials
  Given User lunch chrome browser
  When User opens url "https://www.rakuten.com/"
  And Users enter email as "farukshovon@gmail.com" and password as "Sony0987"
  And click on login
  When user click the logout button
  Then page title should be "shop.earn.getcashback"
  And close browser