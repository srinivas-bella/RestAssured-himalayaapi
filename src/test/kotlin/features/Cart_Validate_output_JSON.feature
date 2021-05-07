
Feature: Cart JSON
  As an API developer, I want to build JSON for Cart, So that the front-end developer can use it.

  @Cart
  Scenario: To validate the objects of a valid cart
    Given I had "Cart" Base URI
    And I had "ValidCart" request payload
    When I call "CartValidate" endpoint with "Post" http request
    Then API call should be done successfully with Status Code 200
    And Response payload should have keys
      |storeId |items |isCartUpdated  |

  @Cart
  Scenario: To validate the keys and objects inside items object of a valid cart
    Given I had "Cart" Base URI
    And I had "ValidCart" request payload
    When I call "CartValidate" endpoint with "Post" http request
    Then API call should be done successfully with Status Code 200
    And "items" list should have objects with keys for "Cart"
      |id |size |productType  |price  |addOn  |

  @Cart
  Scenario: To validate the keys inside addOn object of a valid cart
    Given I had "Cart" Base URI
    And I had "ValidCart" request payload
    When I call "CartValidate" endpoint with "Post" http request
    Then API call should be done successfully with Status Code 200
    And "addOn" list should have objects with keys for "Cart"
      |id |price  |
