Feature: Get Menu Items
  As an API developer, I want to get selected menu list in the JSON response, So that front-end developer can use the data.

  @Menu
  Scenario: To validate the Categories response payload with parameter datetime
    Given I had "Menu" Base URI and "datetime" parameters
      |datetime                        |
      |2021-10-31T12:30:00.000-00:00   |
    When I call "Categories" endpoint with "Get" http request
    Then API call should be done successfully with Status Code 200
    And Response payload should have objects
      |categories  | items  |

  @Menu
  Scenario: To validate the Categories response payload with parameter storeid
    Given I had "Menu" Base URI and "storeid" parameters
      |store_id|
      |1       |
    When I call "Categories" endpoint with "Get" http request
    Then API call should be done successfully with Status Code 200
    And Response payload should have objects
      |categories  | items  |

  @Menu
  Scenario: To validate the Categories response payload with all parameter
    Given I had "Menu" Base URI and "Categories" parameters
      |store_id|datetime                      |menu_id  |serviceType  |
      |1       |2021-10-31T12:30:00.000-00:00 |1001     |delivery     |
    When I call "Categories" endpoint with "Get" http request
    Then API call should be done successfully with Status Code 200
    And Response payload should have objects
      |categories  | items  |

  @Menu
  Scenario: To validate the Categories object for Categories response payload with parameter datetime
    Given I had "Menu" Base URI and "datetime" parameters
      |datetime                        |
      |2021-10-31T12:30:00.000-00:00   |
    When I call "Categories" endpoint with "Get" http request
    Then API call should be done successfully with Status Code 200
    And "categories" object should have keys for "Categories"
      |menuId |name |items|

  @Menu
  Scenario: To validate the Categories object for Categories response payload with parameter storeid
    Given I had "Menu" Base URI and "storeid" parameters
      |store_id|
      |1       |
    When I call "Categories" endpoint with "Get" http request
    Then API call should be done successfully with Status Code 200
    And "categories" object should have keys for "Categories"
      |menuId |name |items|

  @Menu
  Scenario: To validate the Categories object for Categories response payload with all parameter
    Given I had "Menu" Base URI and "Categories" parameters
      |store_id|datetime                      |menu_id  |serviceType  |
      |1       |2021-10-31T12:30:00.000-00:00 |1001     |delivery     |
    When I call "Categories" endpoint with "Get" http request
    Then API call should be done successfully with Status Code 200
    And "categories" object should have keys for "Categories"
      |menuId |name |items|

  @Menu
  Scenario: To validate the Items object for Menu Items in Categories response payload with parameter datetime
    Given I had "Menu" Base URI and "datetime" parameters
      |datetime                        |
      |2021-10-31T06:30:00.000-00:00   |
    When I call "Categories" endpoint with "Get" http request
    Then API call should be done successfully with Status Code 200
    And "items" object should have keys for "Categories"
      |id |name |productType  |info  |
    And "info" object should have keys for "Categories"
      |isAvailable |itemPrice |addOn  |
    And "itemPrice" object should have keys for "Categories"
      |size |price |isAvailable |deliveryPrice  |
    And "addOn" object should have keys for "Categories"
      |id |name |price  |isAvailable  |

  @Menu
  Scenario: To validate the Items object for Menu Items in Categories response payload with parameter storeid
    Given I had "Menu" Base URI and "storeid" parameters
      |store_id|
      |1       |
    When I call "Categories" endpoint with "Get" http request
    Then API call should be done successfully with Status Code 200
    And "items" object should have keys for "Categories"
      |id |name |productType  |info  |
    And "info" object should have keys for "Categories"
      |isAvailable |itemPrice |addOn  |
    And "itemPrice" object should have keys for "Categories"
      |size |price |isAvailable |deliveryPrice  |
    And "addOn" object should have keys for "Categories"
      |id |name |price  |isAvailable  |

  @Menu
  Scenario: To validate the Items object for Menu Items in Categories response payload with all parameter
    Given I had "Menu" Base URI and "Categories" parameters
      |store_id|datetime                      |menu_id  |serviceType  |
      |1       |2021-10-31T12:30:00.000-00:00 |1001     |delivery     |
    When I call "Categories" endpoint with "Get" http request
    Then API call should be done successfully with Status Code 200
    And "items" object should have keys for "Categories"
      |id |name |productType  |info  |
    And "info" object should have keys for "Categories"
      |isAvailable |itemPrice |addOn  |
    And "itemPrice" object should have keys for "Categories"
      |size |price |isAvailable |deliveryPrice  |
    And "addOn" object should have keys for "Categories"
      |id |name |price  |isAvailable  |

  @Menu
  Scenario: To validate the Items object for Combo Items in Categories response payload with parameter datetime
    Given I had "Menu" Base URI and "datetime" parameters
      |datetime                        |
      |2021-10-31T06:30:00.000-00:00   |
    When I call "Categories" endpoint with "Get" http request
    Then API call should be done successfully with Status Code 200
    And "items" object should have keys for "Categories"
      |id |name |productType  |combo  |
    And "combo" object should have keys for "Categories"
      |price |isAvailable |comboItems |
    And "comboItems" object should have keys for "Categories"
      |comboItemId |size |quantity |name |

  @Menu
  Scenario: To validate the Items object for Combo Items in Categories response payload with parameter storeid
    Given I had "Menu" Base URI and "storeid" parameters
      |store_id|
      |1       |
    When I call "Categories" endpoint with "Get" http request
    Then API call should be done successfully with Status Code 200
    And "items" object should have keys for "Categories"
      |id |name |productType  |combo  |
    And "combo" object should have keys for "Categories"
      |price |isAvailable |comboItems |
    And "comboItems" object should have keys for "Categories"
      |comboItemId |size |quantity |name |

  @Menu
  Scenario: To validate the Items object for Combo Items in Categories response payload with all parameter
    Given I had "Menu" Base URI and "Categories" parameters
      |store_id|datetime                      |menu_id  |serviceType  |
      |1       |2021-10-31T12:30:00.000-00:00 |1001     |delivery     |
    When I call "Categories" endpoint with "Get" http request
    Then API call should be done successfully with Status Code 200
    And "items" object should have keys for "Categories"
      |id |name |productType  |combo  |
    And "combo" object should have keys for "Categories"
      |price |isAvailable |comboItems |
    And "comboItems" object should have keys for "Categories"
      |comboItemId |size |quantity |name |
