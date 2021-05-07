
Feature: Store JSON
  As an API developer, I want to build JSON for Stores, So that the front-end developer can use it.

  @Stores
  Scenario: To validate the Stores response payload has basic information which includes id, name and delivery distance when Service Type is Delivery
    Given I had "Store" Base URI and "Stores" parameters
      |latitude         |longitude            |serviceType |sortBy       |
      |38.8116499040007 |-90.4759980765342    |delivery    |deliveryfee  |
    When I call "Stores" endpoint with "Get" http request
    Then API call should be done successfully with Status Code 200
    And Response payload should have keys
    |id |name |deliveryDistance |
    And Response payload should have objects
    |address  |contactInfo  |businessHours  |socialInfo |serviceType  |exceptionHours  |

  @Stores
  Scenario: To validate the Stores response payload has basic information which includes id, name and delivery distance when Service Type is Pickup
    Given I had "Store" Base URI and "Stores" parameters
      |latitude         |longitude            |serviceType |sortBy       |
      |38.8116499040007 |-90.4759980765342    |pickup      |deliveryfee  |
    When I call "Stores" endpoint with "Get" http request
    Then API call should be done successfully with Status Code 200
    And Response payload should have keys
      |id |name |deliveryDistance |
    And Response payload should have objects
      |address  |contactInfo  |businessHours  |socialInfo |serviceType  |exceptionHours  |

  @Stores
  Scenario: To validate the Stores response payload has address information
    Given I had "Store" Base URI and "Stores" parameters
      |latitude         |longitude            |serviceType |sortBy       |
      |38.8116499040007 |-90.4759980765342    |delivery    |deliveryfee  |
    When I call "Stores" endpoint with "Get" http request
    Then API call should be done successfully with Status Code 200
    And Response payload should have "address" object
    And "address" object should have keys for "Stores"
      |streetName |city  |state |zip|latitude  |longitude  |distance |

  @Stores
  Scenario: To validate the Store response payload has Contact Information
    Given I had "Store" Base URI and "Stores" parameters
      |latitude         |longitude            |serviceType |sortBy       |
      |38.8116499040007 |-90.4759980765342    |delivery    |deliveryfee  |
    When I call "Stores" endpoint with "Get" http request
    Then API call should be done successfully with Status Code 200
    And Response payload should have "contactInfo" object
    And "contactInfo" object should have keys for "Stores"
      |managerName |phoneNumber  |email |

  @Stores
  Scenario: To validate the Store response payload has Business Hours Information
    Given I had "Store" Base URI and "Stores" parameters
      |latitude         |longitude            |serviceType |sortBy       |
      |38.8116499040007 |-90.4759980765342    |delivery    |deliveryfee  |
    When I call "Stores" endpoint with "Get" http request
    Then API call should be done successfully with Status Code 200
    And Response payload should have "businessHours" list
    And "businessHours" list should have objects with keys for "Stores"
      |dayOfTheWeek |isOpen  |startTime |endTime  |

  @Stores
  Scenario: To validate the Stores response payload has social information
    Given I had "Store" Base URI and "Stores" parameters
      |latitude         |longitude            |serviceType |sortBy       |
      |38.8116499040007 |-90.4759980765342    |delivery    |deliveryfee  |
    When I call "Stores" endpoint with "Get" http request
    Then API call should be done successfully with Status Code 200
    And Response payload should have "socialInfo" object
    And "socialInfo" object should have keys for "Stores"
      |web  |twitter  |facebook |yelp |

  @Stores
  Scenario: To validate the Stores response payload has Service Type information
    Given I had "Store" Base URI and "Stores" parameters
      |latitude         |longitude            |serviceType |sortBy       |
      |38.8116499040007 |-90.4759980765342    |delivery    |deliveryfee  |
    When I call "Stores" endpoint with "Get" http request
    Then API call should be done successfully with Status Code 200
    And Response payload should have "serviceType" list
    And "serviceType" list should have objects with keys for "Stores"
      |serviceName  |orderMinimumValue  |deliveryFee  |

  @Stores
  Scenario: To validate the Stores response payload has Holiday Hours information
    Given I had "Store" Base URI and "Stores" parameters
      |latitude         |longitude            |serviceType |sortBy       |
      |38.8116499040007 |-90.4759980765342    |delivery    |deliveryfee  |
    When I call "Stores" endpoint with "Get" http request
    Then API call should be done successfully with Status Code 200
    And Response payload should have "exceptionHours" list
    And "exceptionHours" object should have keys for "Stores"
      |startDateTime |endDateTime |isOpen |description |

