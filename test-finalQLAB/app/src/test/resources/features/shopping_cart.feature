Feature: Shopping Cart Functionality

Scenario Outline: Add products to the shopping cart
Given I am on the SauceLabs application
And the products are loaded correctly in the gallery
When I add <UNITS> of the product "<PRODUCT>"
Then the shopping cart should be updated correctly

Examples:
| PRODUCT                   | UNITS |
| Sauce Labs Backpack       | 1     |
| Sauce Labs Bolt T-Shirt   | 1     |
| Sauce Labs Bike Light     | 2     |