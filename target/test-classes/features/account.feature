Feature: Account feature

@Smoke @Account @Regression
Scenario Outline: Check account created with deafult account type
Given User is on login page
When User enters "<username>" and "<password>"
And click on login button
And Create a new account
#Then Verify account created with default account type

Examples:
|username|password|
|mngr602007|rYzAgab|