@td_oneCSiOS_TD
Feature: Portfolio Dashboard feature validation on iOS app

  Background: 
    Given user launch app "OneCSiOSApp" on "realDevice" mobile device
    Then user sign in with valid username 'Bob' and password 'Pass123$' for iOS

  @IOSDashboard @4.01
  Scenario: 4.0 - To verify the "Portfolio Dashboard" Screen details and validations
    Given user is on the dashboard screen they should be displayed with pillbox with down arrow for iOS
    Then user should be displayed with welcome back your current portfolio section including the performance arrow on iOS
    Then user should be displayed with Portfolio summary value details on iOS
    Then user should be displayed with bottom naviagation options for portfolio,contact,investments,insights and more on iOS
    And user closes "app" on mobile device
