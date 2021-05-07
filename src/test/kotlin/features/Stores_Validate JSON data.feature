@StoreDataValidation
Feature: Store JSON
  As an API developer, I want to hold data in Stores JSON, So that the front-end developer can use it.

  Scenario: To setup the test data to validate JSON content
    When I run the "AddStore" setup

  Scenario: To validate the Store information in JSON response
    Given I had "Store" Base URI and "Stores" parameters
      |latitude         |longitude             |serviceType |sortBy       |
      |38.4135092547055 |-91.50127353693624    |delivery    |deliveryfee  |
    When I call "Stores" endpoint with "Get" http request
    Then API call should be done successfully with Status Code 200
    And "name" key for "stores" should have value "Test Store"
    And "deliveryDistance" key for "stores" should have value "8.4"

  Scenario: To validate the Address information in JSON response
    Given I had "Store" Base URI and "Stores" parameters
      |latitude         |longitude             |serviceType |sortBy       |
      |38.4135092547055 |-91.50127353693624    |delivery    |deliveryfee  |
    When I call "Stores" endpoint with "Get" http request
    Then API call should be done successfully with Status Code 200
    And "streetName" key in "address" object of "stores" should have value "Test Street"
    And "city" key in "address" object of "stores" should have value "Test City"
    And "state" key in "address" object of "stores" should have value "TEST"
    And "zip" key in "address" object of "stores" should have value "98765"
    And "latitude" key in "address" object of "stores" should have value "38.614002"
    And "longitude" key in "address" object of "stores" should have value "-90.21421"
    And "distance" key in "address" object of "stores" should have value "143.76"

  Scenario: To validate the ContactInfo information in JSON response
    Given I had "Store" Base URI and "Stores" parameters
      |latitude         |longitude             |serviceType |sortBy       |
      |38.4135092547055 |-91.50127353693624    |delivery    |deliveryfee  |
    When I call "Stores" endpoint with "Get" http request
    Then API call should be done successfully with Status Code 200
    And "managerName" key in "contactInfo" object of "stores" should have value "Test Store Manager"
    And "phoneNumber" key in "contactInfo" object of "stores" should have value "(987) 654-3210"
    And "email" key in "contactInfo" object of "stores" should have value "test@himalaya.com"

  Scenario: To validate the Business Hours information in JSON response
    Given I had "Store" Base URI and "Stores" parameters
      |latitude         |longitude             |serviceType |sortBy       |
      |38.4135092547055 |-91.50127353693624    |delivery    |deliveryfee  |
    When I call "Stores" endpoint with "Get" http request
    Then API call should be done successfully with Status Code 200
    And "dayOfTheWeek" key in "businessHours" list of "Stores" should have values
      |Monday |Tuesday |Wednesday  |Thursday  |Friday |Saturday |Sunday |
    And "isOpen" key in "businessHours" list of "stores" should have value "true"
    And "startTime" key in "businessHours" list of "Stores" should have values
      |14:30:00+05:30  |14:30:00+05:30  |14:30:00+05:30 |14:30:00+05:30 |14:30:00+05:30 |16:30:00+05:30  |15:30:00+05:30  |
    And "endTime" key in "businessHours" list of "Stores" should have values
      |01:30:00+05:30  |01:30:00+05:30  |18:30:00+05:30 |01:30:00+05:30 |04:30:00+05:30 |18:30:00+05:30  |18:30:00+05:30 |

  Scenario: To validate the SocialInfo information in JSON response
    Given I had "Store" Base URI and "Stores" parameters
      |latitude         |longitude             |serviceType |sortBy       |
      |38.4135092547055 |-91.50127353693624    |delivery    |deliveryfee  |
    When I call "Stores" endpoint with "Get" http request
    Then API call should be done successfully with Status Code 200
    And "web" key in "socialInfo" object of "Stores" should have value "https://testweb.com"
    And "twitter" key in "socialInfo" object of "Stores" should have value "https://twitter.com/test"
    And "facebook" key in "socialInfo" object of "Stores" should have value "https://facebook.com/test"
    And "yelp" key in "socialInfo" object of "Stores" should have value "https://yelp.com/test"

  Scenario: To validate the ServiceType information in JSON response
    Given I had "Store" Base URI and "Stores" parameters
      |latitude         |longitude             |serviceType |sortBy       |
      |38.4135092547055 |-91.50127353693624    |delivery    |deliveryfee  |
    When I call "Stores" endpoint with "Get" http request
    Then API call should be done successfully with Status Code 200
    And "serviceName" key in "serviceType" list of "Stores" should have values
      |Dine-in  |Delivery |Take-out |
    And "orderMinimumValue" key in "serviceType" list of "Stores" should have values
      |null |55.0  |10.0  |
    And "deliveryFee" key in "serviceType" list of "Stores" should have values
      |null |5.0 |0.0 |

  Scenario: To validate the Exception Hours information in JSON response
    Given I had "Store" Base URI and "Stores" parameters
      |latitude         |longitude             |serviceType |sortBy       |
      |38.4135092547055 |-91.50127353693624    |delivery    |deliveryfee  |
    When I call "Stores" endpoint with "Get" http request
    Then API call should be done successfully with Status Code 200
    And "startDateTime" key in "exceptionHours" list of "Stores" should have value "2121-04-12 23:30:00+05:30"
    And "endDateTime" key in "exceptionHours" list of "Stores" should have value "2121-04-16 03:30:00+05:30"
    And "isOpen" key in "exceptionHours" list of "Stores" should have value "true"
    And "description" key in "exceptionHours" list of "Stores" should have value "Holidays"

  Scenario: To delete the test data after validating JSON content
    When I run the "DeleteStore" setup
