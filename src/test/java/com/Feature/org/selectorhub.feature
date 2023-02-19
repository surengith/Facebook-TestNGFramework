Feature: Checking the functionality of an selectorhub application

Scenario Outline: practice page functionality

Given user must launch the url
When user click the product menu
And user click the practice page from drop down option
And user enter the "<Email>" in the User Email field
And user enter the "<Password>" in the Password field
And user enter the Company name in the Company field
And user enter the Mobile Number in the Mobile Number field
And user click the submit button
And user click the checkout here button
And user click the Try TestCase Studio option
And user switchto parent window
And user again click the checkout here button
And user click the Try SHub Youtube Channel option
And user must close the opened child windows
And user select the Audi car from the Choose a car drop down
And user must take screenshot of the whole web page
Then user quit the browser

Examples: 
|Email|Password|
|xyz@gmail.com|545623|
|jyz@gmail.com|545624|
|xyz@gmail.com|545623|
