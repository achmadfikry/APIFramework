Feature: Validating Place API's

  Scenario: Verify if Place is being successfully added using AddPlaceAPI
    Given Add Place Payload
    When user calls "AddPlaceAPI" with post http request
    Then the API call got success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"

  Scenario Outline: Verify if Place is being successfully added using AddPlaceAPI with Data
    Given Add Place Payload with "<name>" "<language>" "<address>"
    When user calls "AddPlaceAPI" with post http request
    Then the API call got success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    Examples:
      | name    | language | address            |
      | AAhouse | English  | World Cross Center |