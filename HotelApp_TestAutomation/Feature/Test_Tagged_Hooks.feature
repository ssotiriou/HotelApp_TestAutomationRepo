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
Feature: Test Tagged Hooks
 
@First 
Scenario: This is First Scenario
	Given this is the first step
	When this is the second step
	Then this is the third step
 
@Second	
Scenario: This is Second Scenario
	Given this is the first step
	When this is the second step
	Then this is the third step
 
@Third	
Scenario: This is Third Scenario
	Given this is the first step
	When this is the second step
	Then this is the third step