#
#@reprocess_job
#Feature: Reprocess job manually
#
#  Background: Verify user is able to generate token.
#    Given Generate token by passing payload email, password and tenantId
#      |email|password|tenantId|
#      |sso.test4407@shoppertrak.com|Saml@123|sso-test-newTenant-nulqd|
#    When user calls "generateToken" with "POST" http request
#    Then the API gets response with status code 200
#    And user is able to fetch IdToken from response body
#
#
#  Scenario: As an user I want to reprocess the job manually
#    Given User pass the reprocess job payload to http request
#      | site_id |date_range| type |
#      |80174900|05072021-05072021|manual|
#    When User pass the "sso-test-newTenant-nulqd" tenant id and id token as headers in "reprocess_job" http request
#    When user calls "reprocessJob" with "PUT" http request
#    Then the API gets response with status code 200