Feature: Validation of login feature

@Smoke @Login @Regression
Scenario Outline: Check login is successful with valid credential
Given User is on login page
When User enters "<username>" and "<password>"
And click on login button
Then User is navigated to Home Page

Examples:
|username|password|
|mngr602007|rYzAgab|

@Login @Regression
Scenario Outline: Check login is successful with invalid credential
Given User is on login page
When User enters "<username>" and "<password>"
And click on login button
Then User received error message

Examples:
|username|password|
|mngr570407|epYmyry11|