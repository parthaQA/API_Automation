
Feature: Delete visits

  Background: Verify user is able to generate token.
    Given Generate token by passing payload email, password and tenantId
      |email|password|tenantId|
      |sso.test4407@shoppertrak.com|Saml@123|sso-test-newTenant-nulqd|
    When user calls "generateToken" with "POST" http request
    Then the API gets response with status code 200
    And user is able to fetch IdToken from response body

  Scenario: As an user I want to delete visits for a certain date range and site
    Given User pass delete visits payload to http request
      | siteId |startDate| endDate | user|comment|
      |80160932|2022-05-04|2022-05-04|ssotestotkten|test_partha1|
    When User pass the "sso-test-newTenant-nulqd" tenant id and id token as headers in "delete_visits" http request
    When user calls "deleteVisits" with "PUT" http request
    Then the API gets response with status code 200

  @smoke
  Scenario: Verify delete visits with invalid site id
    Given User pass delete visits payload to http request
      | siteId |startDate| endDate | user|comment|
      |00000000|2022-05-04|2022-05-04|ssotestotkten|test_partha1|
    When User pass the "sso-test-newTenant-nulqd" tenant id and id token as headers in "delete_visits" http request
    When user calls "deleteVisits" with "PUT" http request
    Then the API gets response with status code 200






