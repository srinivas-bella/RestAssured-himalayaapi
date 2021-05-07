@MenuDataValidation
Feature: Menu JSON
  As an API developer, I want to hold data in Stores JSON, So that the front-end developer can use it.

  Scenario: To setup the test data to validate JSON content
    When I run the "MenuClean" setup
    And I run the "AddMenu" setup

  Scenario: To validate the Categories data in Categories JSON response
    Given I had "Menu" Base URI and "Categories" parameters
      |store_id|datetime                      |menu_id  |serviceType  |
      |1       |2021-10-31T15:00:00.000-00:00 |4001     |delivery     |
    When I call "Categories" endpoint with "Get" http request
    Then API call should be done successfully with Status Code 200
    And "menuId" key for "categories" should have value "4001"
    And "name" key for "categories" should have value "TEST"
    And "items" list in "categories" should have values
      |1  |400101  |

  Scenario: To validate the Items data of a Combo in Categories JSON response
    Given I had "Menu" Base URI and "Categories" parameters
      |store_id|datetime                      |menu_id  |serviceType  |
      |1       |2021-10-31T15:00:00.000-00:00 |4001     |delivery     |
    When I call "Categories" endpoint with "Get" http request
    Then API call should be done successfully with Status Code 200
    And "id" key for "Combo Items" should have value "1"
    And "name" key for "Combo Items" should have value "Test05"
    And "productType" key for "Combo Items" should have value "2"

  Scenario: To validate the Combo data of a Combo in Categories JSON response
    Given I had "Menu" Base URI and "Categories" parameters
      |store_id|datetime                      |menu_id  |serviceType  |
      |1       |2021-10-31T15:00:00.000-00:00 |4001     |delivery     |
    When I call "Categories" endpoint with "Get" http request
    Then API call should be done successfully with Status Code 200
    And "price" key in "combo" object of "Categories" should have value "120.2"


  Scenario: To validate the Combo Items data of a Combo in Categories JSON response
    Given I had "Menu" Base URI and "Categories" parameters
      |store_id|datetime                      |menu_id  |serviceType  |
      |1       |2021-10-31T15:00:00.000-00:00 |4001     |delivery     |
    When I call "Categories" endpoint with "Get" http request
    Then API call should be done successfully with Status Code 200
    And "comboItemId" key in "comboItems" list of "Categories" should have values
      |400101  |400102  |400103  |
    And "size" key in "comboItems" object of "Categories" should have value "s"
    And "quantity" key in "comboItems" list of "Categories" should have values
      |1  |1  |2  |
    And "name" key in "comboItems" list of "Categories" should have values
      |Chocolate Chip Cookie & Vanilla Ice Cream  |Brownie Cookie & Caramel Ice Cream  |Chocolate Chip Cookie & Vanilla Ice Cream |


  Scenario: To validate the Items data for an Item in Categories JSON response
    Given I had "Menu" Base URI and "Categories" parameters
      |store_id|datetime                      |menu_id  |serviceType  |
      |1       |2021-10-31T15:00:00.000-00:00 |4001     |delivery     |
    When I call "Categories" endpoint with "Get" http request
    Then API call should be done successfully with Status Code 200
    And "id" key for "items" should have value "400101"
    And "name" key for "items" should have value "Test01"
    And "productType" key for "items" should have value "1"

  Scenario: To validate the Info data for an Item in Categories JSON response
    Given I had "Menu" Base URI and "Categories" parameters
      |store_id|datetime                      |menu_id  |serviceType  |
      |1       |2021-10-31T15:00:00.000-00:00 |4001     |delivery     |
    When I call "Categories" endpoint with "Get" http request
    Then API call should be done successfully with Status Code 200
    And "ingredient" key in "info" object of "Categories" should have value "TIng1"
    And "isAvailable" key in "info" object of "Categories" should have value "true"

  Scenario: To validate the Item Price data for an Item in Categories JSON response
    Given I had "Menu" Base URI and "Categories" parameters
      |store_id|datetime                      |menu_id  |serviceType  |
      |1       |2021-10-31T15:00:00.000-00:00 |4001     |delivery     |
    When I call "Categories" endpoint with "Get" http request
    Then API call should be done successfully with Status Code 200
    And "size" key in "itemPrice" list of "Categories" should have values
      |single scoop  |500 ml  |750 ml |
    And "price" key in "itemPrice" list of "Categories" should have values
      |100.0  |200.0  |300.0  |

  Scenario: To validate the Addon data for an Item in Categories JSON response
    Given I had "Menu" Base URI and "Categories" parameters
      |store_id|datetime                      |menu_id  |serviceType  |
      |1       |2021-10-31T15:00:00.000-00:00 |4001     |delivery     |
    When I call "Categories" endpoint with "Get" http request
    Then API call should be done successfully with Status Code 200
    And "id" key in "addOn" list of "Categories" should have values
      |7  |8  |9 |
    And "name" key in "addOn" list of "Categories" should have values
      |TAddon1  |TAddon2  |TAddon3  |
    And "price" key in "addOn" list of "Categories" should have values
      |10.0  |80.0  |110.0  |

  Scenario: To delete the test data after validating JSON content
    When I run the "MenuClean" setup
    When I run the "MenuAddAllData" setup
