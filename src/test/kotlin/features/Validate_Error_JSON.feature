Feature: Error exception handling for a service api
  As a developer I want to handle error exceptions so that user will know the cause of the error.

#  @Stores @Before
#  Scenario: Clean all old reports
#  Given Delete Old Reports

  @Stores
  Scenario: To validate the error JSON structure for incorrect endpoint
    Given I had "Store" Base URI and "Stores" parameters
      |latitude         |longitude            |serviceType |sortBy       |
      |38.8116499040007 |-90.4759980765342    |delivery    |deliveryfee  |
    When I call "random" endpoint with "Get" http request
    Then API call should be failed with Status Code "404"
    Then JSON should have keys
      |status  |message |code  |urlPath |timestamp |

  @Stores
  Scenario: To validate the error JSON structure for incorrect http request to Stores endpoint
    Given I had "Store" Base URI and "Stores" parameters
      |latitude         |longitude            |serviceType |sortBy       |
      |38.8116499040007 |-90.4759980765342    |delivery    |deliveryfee  |
    When I call "Stores" endpoint with "Post" http request
    Then API call should be failed with Status Code "405"
    Then JSON should have keys
      |status  |message |code  |urlPath |timestamp |

  @Stores
  Scenario: To validate the error JSON structure for incorrect key of Store's query parameter
    Given I had "Store" Base URI and "incorrect key" parameters for "Stores"
      |latitudejunk     |longitude            |serviceType |sortBy       |
      |38.8116499040007 |-90.4759980765342    |delivery    |deliveryfee  |
    When I call "Stores" endpoint with "Get" http request
    Then API call should be failed with Status Code "400"
    Then JSON should have keys
      |status  |message |code  |urlPath |timestamp |

  @Stores
  Scenario: To validate the error JSON structure for blank key of Store's query parameter
    Given I had "Store" Base URI and "blank key" parameters for "Stores"
      | ________        |longitude            |serviceType |sortBy       |
      |38.8116499040007 |-90.4759980765342    |delivery    |deliveryfee  |
    When I call "Stores" endpoint with "Get" http request
    Then API call should be failed with Status Code "400"
    Then JSON should have keys
      |status  |message |code  |urlPath |timestamp |

  @Stores
  Scenario: To validate the error JSON structure for incorrect value of Store's query parameter
    Given I had "Store" Base URI and "incorrect value" parameters for "Stores"
      |latitude        |longitude            |serviceType |sortBy       |
      |junkD@T@        |-90.4759980765342    |delivery    |deliveryfee  |
    When I call "Stores" endpoint with "Get" http request
    Then API call should be failed with Status Code "404"
    Then JSON should have keys
      |status  |message |code  |urlPath |timestamp |

  @Stores
  Scenario: To validate the error JSON structure for blank value of Store's query parameter
    Given I had "Store" Base URI and "blank value" parameters for "Stores"
      |latitude         |longitude            |serviceType |sortBy       |
      ||-90.4759980765342    |delivery    |deliveryfee  |
    When I call "Stores" endpoint with "Get" http request
    Then API call should be failed with Status Code "400"
    Then JSON should have keys
      |status  |message |code  |urlPath |timestamp |

    @Stores
  Scenario: To validate the error JSON structure when customer location falls in none of the store's delivery zones.
      Given I had "Store" Base URI and "Stores" parameters
      |latitude|longitude |serviceType |sortBy       |
      |30.7777 |-50.666   |delivery    |deliveryfee  |
    When I call "Stores" endpoint with "Get" http request
    Then API call should be done successfully with Status Code 200
    Then JSON should have keys
      |status  |message |code  |urlPath |timestamp |

    @Stores
  Scenario: To validate the error JSON structure for invalid data in database
      Given I had "Store" Base URI and "Stores" parameters
      |latitudejunk     |longitude            |serviceType |sortBy       |
      |38.8116499040007 |-90.4759980765342    |delivery    |deliveryfee  |
    And I am connected with the database
    And I run the "StoreDropTable" query
    When I call "Stores" endpoint with "Get" http request
    Then API call should be failed with Status Code "500"
    Then JSON should have keys
      |status  |message |code  |urlPath |timestamp |
    #adding the deleted data back for a particular table
    And I run the "StoreCreateDeletedTable" setup

  @Menu
  Scenario: To validate the error JSON structure for incorrect endpoint
    Given I had "Menu" Base URI and "Menu" parameters
      |menu_id  |
      |1001     |
    When I call "random" endpoint with "Get" http request
    Then API call should be failed with Status Code "404"
    Then JSON should have keys
      |status  |message |code  |urlPath |timestamp |

  @Menu
  Scenario: To validate the error JSON structure for incorrect http request
    Given I had "Menu" Base URI and "Menu" parameters
      |menu_id  |
      |1001     |
    When I call "Categories" endpoint with "Post" http request
    Then API call should be failed with Status Code "405"
    Then JSON should have keys
      |status  |message |code  |urlPath |timestamp |

  @Menu
  Scenario: To validate the error JSON structure when no data is returned
    Given I had "Menu" Base URI and "Menu" parameters
      |menu_id  |
      |10001     |
    When I call "Categories" endpoint with "Get" http request
    Then API call should be done successfully with Status Code 200
    Then JSON should have keys
      |status  |message |code  |urlPath |timestamp |

  @Menu
  Scenario: To validate the error JSON structure when selected store doesn't have any menu
    Given I had "Menu" Base URI and "Menu" parameters
      |store_id|datetime                      |menu_id  |serviceType  |
      |3       |2021-10-31T23:00:00.000-00:00 |3001     |delivery     |
    When I call "Categories" endpoint with "Get" http request
    Then API call should be failed with Status Code "404"
    Then JSON should have keys
      |status  |message |code  |urlPath |timestamp |

#  @Menu
#  Scenario: To validate the error JSON structure for blank key of Categories' query parameter
#    Given I had "Menu" Base URI and "blank key" parameters for "Menu"
#      |--------     |
#      |1001         |
#    When I call "Categories" endpoint with "Get" http request
#    Then API call should be failed with Status Code "400"
#    Then JSON should have keys
#      |status  |message |code  |urlPath |timestamp |

  @Menu
  Scenario: To validate the error JSON structure when selected store doesn't support delivery
    Given I had "Menu" Base URI and "Categories" parameters
      |store_id|datetime                      |menu_id  |serviceType  |
      |2       |2021-10-31T21:00:00.000-00:00 |3001     |delivery     |
    When I call "Categories" endpoint with "Get" http request
    Then API call should be failed with Status Code "422"
    Then JSON should have keys
      |status  |message |code  |urlPath |timestamp |

  @Menu
  Scenario: To validate the error JSON structure for incorrect key of Categories' query parameter
    Given I had "Menu" Base URI and "incorrect key" parameters for "Menu"
      |menu_idjunk  |
      |1001         |
    When I call "Categories" endpoint with "Get" http request
    Then API call should be failed with Status Code "400"
    Then JSON should have keys
      |status  |message |code  |urlPath |timestamp |

#  @Menu
#  Scenario: To validate the error JSON structure for blank key of Categories' query parameter
#    Given I had "Menu" Base URI and "blank key" parameters for "Menu"
#      |--------     |
#      |1001         |
#    When I call "Categories" endpoint with "Get" http request
#    Then API call should be failed with Status Code "400"
#    Then JSON should have keys
#      |status  |message |code  |urlPath |timestamp |

  @Menu
  Scenario: To validate the error JSON structure for incorrect value of Categories' query parameter
    Given I had "Menu" Base URI and "incorrect value" parameters for "Menu"
      |menu_id  |
      |junk     |
    When I call "Categories" endpoint with "Get" http request
    Then API call should be failed with Status Code "404"
    Then JSON should have keys
      |status  |message |code  |urlPath |timestamp |

#  @Menu
#  Scenario: To validate the error JSON structure for blank value of Categories' query parameter
#    Given I had "Menu" Base URI and "blank value" parameters for "Menu"
#      |menu_id  |
#      ||
#    When I call "Categories" endpoint with "Get" http request
#    Then API call should be failed with Status Code "400"
#    Then JSON should have keys
#      |status  |message |code  |urlPath |timestamp |

  @Menu
  Scenario: To validate the error JSON structure for invalid data in database
    Given I had "Menu" Base URI and "Menu" parameters
      |menu_id  |
      |1001     |
    And I am connected with the database
    And I run the "MenuDropTable" query
    When I call "Categories" endpoint with "Get" http request
    Then API call should be failed with Status Code "500"
    Then JSON should have keys
      |status  |message |code  |urlPath |timestamp |
    And I run the "MenuCreateDeletedTable" setup

  @Cart
  Scenario: To validate an invalid cart
    Given I had "Cart" Base URI
    And I had "InvalidCart" request payload
    When I call "CartValidate" endpoint with "Post" http request
    Then API call should be failed with Status Code "422"
    And JSON should have keys
      |status  |message |code  |urlPath |timestamp |

  @Order
  Scenario: To validate order payload with invalid OrderID while updating Order status
    Given I had "Order" Base URI
    And I had "OrderNew" request payload
    When I call "InvalidOrder" endpoint with "Put" http request
    Then API call should be failed with Status Code "404"
    Then JSON should have keys
      |status  |message |code  |urlPath |timeStamp |

  @Order
  Scenario: To validate order payload with invalid payload while placing the order
    Given I had "Order" Base URI
    And I had "InvalidOrder" request payload
    When I call "Order" endpoint with "Post" http request
    Then API call should be failed with Status Code "400"
    Then JSON should have keys
      |status  |message |code  |urlPath |timeStamp |