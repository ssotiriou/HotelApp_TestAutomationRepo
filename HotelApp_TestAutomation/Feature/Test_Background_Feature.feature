#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Test Background Feature
Description: The purpose of this feature is to test the Background keyword
 
Background: User is Logged In
	Given I navigate to the login page
	When I submit username and password
	Then I should be logged in 
 
Scenario: Search a product and add the first product to the User basket
	Given User search for Lenovo Laptop
	When Add the first laptop that appears in the search result to the basket
	Then User basket should display with added item
 
Scenario: Navigate to a product and add the same to the User basket
	Given User navigate for Lenovo Laptop
	When Add the laptop to the basket
	Then User basket should display with added item
