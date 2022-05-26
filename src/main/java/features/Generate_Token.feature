
Feature: Generate user token to perform operations.

  Scenario: Verify user is able to generate token.
    Given Generate token by passing payload email, password and tenantId
      |email|password|tenantId|
      |sso.test4407@shoppertrak.com|Saml@123|sso-test-newTenant-nulqd|
    When user calls "generateToken" with "POST" http request
    Then the API gets response with status code 200
    And user is able to fetch IdToken from response body