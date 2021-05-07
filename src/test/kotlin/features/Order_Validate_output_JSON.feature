
Feature: Order JSON
  As an API developer, I want to build JSON for Order Workflow, So that the front-end developer can use it.

  @Order
  Scenario: To validate the objects and keys of a valid Order JSON response
    Given I had "Order" Base URI
    And I had "Order" request payload
    When I call "Order" endpoint with "Post" http request
    Then API call should be done successfully with Status Code 200
    And Response payload should have keys
      |id |menuDetails |userDetails  |
    And "menuDetails" list should have objects with keys for "Order"
      |menuId |quantity |menuName  |
    And "userDetails" list should have objects with keys for "Order"
      |email  |
    And delete the order records

  @Order
  Scenario: To validate the objects of JSON response while updating Order status to New
    Given I had "Order" Base URI
    And I had "OrderNew" request payload
    When I call "OrderStatusUpdate" endpoint with "Put" http request
    Then API call should be done successfully with Status Code 200
    And Response payload should have keys
      |id |menuDetails |userDetails  |orderStatus |
    And "orderStatus" key for "Orders" should have value "1"

  @Order
  Scenario: To validate the objects of JSON response while updating Order status to InProgress
    Given I had "Order" Base URI
    And I had "OrderInProgress" request payload
    When I call "OrderStatusUpdate" endpoint with "Put" http request
    Then API call should be done successfully with Status Code 200
    And Response payload should have keys
      |id |menuDetails |userDetails  |orderStatus |
    And "orderStatus" key for "Orders" should have value "2"

  @Order
  Scenario: To validate the objects of JSON response while updating Order status to Completed
    Given I had "Order" Base URI
    And I had "OrderCompleted" request payload
    When I call "OrderStatusUpdate" endpoint with "Put" http request
    Then API call should be done successfully with Status Code 200
    And Response payload should have keys
      |id |menuDetails |userDetails  |orderStatus |
    And "orderStatus" key for "Orders" should have value "3"