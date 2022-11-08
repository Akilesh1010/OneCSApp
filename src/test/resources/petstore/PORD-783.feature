@td_OneCS_TD
Feature: STAFF - date field

  ###783
  @Sprint13 @Pord783 @783.1
  Scenario: Verify for Date field in all applicable screens on Client Portal, only numbers can be entered and slashes are not required to be entered, for Client 1
    Given user navigates to client portal with CS client portal link
    And user should see sign in screen
    When user enter correct username "USERNAME_783_1_INDIVIDUAL" and password "PASSWORD_783_1_INDIVIDUAL" for client "CLIENT_TYPE_INDIVIDUAL"
    And user clicks on Continue button
    Then user should see Welcome screen
    And user clicks on "PERSONAL_DETAILS" in left pane
    Then user should enter dob "INVALID_DATE_FORMAT" in client screen for "CLIENT_TYPE_INDIVIDUAL"
    And user clicks on "ADDITIONAL_DETAILS" in left pane
    Then user should enter expiry date in verification of identity section "INVALID_DATE_FORMAT" in additional client details screen for "CLIENT_TYPE_INDIVIDUAL"
    And user clicks on "FINANCIAL_DETAILS" in left pane
    Then user enters dates for Liabilities and Anticipate pay off fields on "INVALID_DATE_FORMAT" in financial screen for "CLIENT_TYPE_INDIVIDUAL"
    And user clicks on "Portfolios" in left pane
    Then user should enter dates for "ALPHA_SIPP" and "SIPP" accounts in "INVALID_DATE_FORMAT" in portfolio screen for "CLIENT_TYPE_INDIVIDUAL"

  ###783
  @Sprint13 @Pord783 @783.2
  Scenario: Verify for Date field in all applicable screens on Client Portal, only numbers can be entered and slashes are not required to be entered, for Client 1 & 2
    Given user navigates to client portal with CS client portal link
    And user should see sign in screen
    When user enter correct username "USERNAME_783_1_JOINT" and password "PASSWORD_783_1_JOINT" for client "CLIENT_TYPE_JOINT"
    And user clicks on Continue button
    Then user should see Welcome screen
    And user clicks on "PERSONAL_DETAILS" in left pane
    Then user should enter dob "INVALID_DATE_FORMAT" in client screen for "CLIENT_TYPE_JOINT"
    And user clicks on "ADDITIONAL_DETAILS" in left pane
    Then user should enter expiry date in verification of identity section "INVALID_DATE_FORMAT" in additional client details screen for "CLIENT_TYPE_JOINT"
    And user clicks on "FINANCIAL_DETAILS" in left pane
    Then user enters dates for Liabilities and Anticipate pay off fields on "INVALID_DATE_FORMAT" in financial screen for "CLIENT_TYPE_JOINT"
    And user clicks on "Portfolios" in left pane
    Then user should enter dates for "ALPHA_SIPP" and "SIPP" accounts in "INVALID_DATE_FORMAT" in portfolio screen for "CLIENT_TYPE_JOINT"
