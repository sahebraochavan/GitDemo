
@tag
Feature: Purchase the order from Ecommerce websites
  I want to use this template for my feature file
  
  Background:
  Given I landed on the Ecommerce page

@tag2
  Scenario Outline: Positive test of submitting the order
    Given Logged in with username <name> and password <password>
    When I add product <productName> to Cart
    And	Checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on confirmationPage

    Examples: 
      | name  							| 		password 		| 	productName	|
      | nandini.1@gmail.com |     Chavan@1234 | 	ZARA COAT 3	|
      
