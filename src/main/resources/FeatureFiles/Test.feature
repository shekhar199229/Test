@Login3
Feature: Delta Login Feature
As a Automation tester
I want to test Delta Login functionality
So that I can login in application

Background: User navigates to Company Login page
Given Open Browser and navigate to Login page
@Signin
Scenario: Login scenario
When valid username and password is entered
And login button clicked
Then user should able login successfully
Then User click on Timesheet icon
Then verify current month and year
And Click on LogHours Button
Then Select project
And enter hours
Then Click on Save button
