Feature: Register to automation exercise

  Background:
    Given User open base url "https://automationexercise.com" and navigate to register page
    When User click on signUp or LogIn button

  Scenario: Successfully registered using valid details
    When Enter the following data in their respective fields
      | Name             | Gouse                  |
      | Mail             | car4@gmail.com         |
      | Password         | Varun@1                |
      | DOB              | 5-December-2001        |
      | Firstname        | Gouse                  |
      | Lastname         | Begum                  |
      | CompanyName      | Infy                   |
      | PrimaryAddress   | Chabolu Nandyal infy   |
      | SecondaryAddress | Sreenivas Nandyal infy |
      | Country          | India                  |
      | State            | Andhra pradesh         |
      | City             | Nandyal                |
      | Zipcode          | 518018                 |
      | MobileNumber     | 9898989898             |
    And User click on create new account
    Then User should be on the my account page


  Scenario: Register using already registered email
    When User enter name and email to register
      | Name | Gouse         |
      | Mail | can@gmail.com |
    And Click on signUp button
    Then Page should display "Email Address already exist!"

  Scenario: Registration using valid mail and missing name
    When User enters valid email "gouseboy.dr@gmail.com" and leaving name field empty
    And Click on signUp button
    Then Verify name field displays "Please fill out this field."

  Scenario: Registration using valid name and invalid email
    When User enters name and invalid mail
      | Name  | Gouse  |
      | Email | Gouse@ |
    And Click on signUp button
    Then Email field should display "Please enter a part following '@'. 'Gouse@' is incomplete."

  Scenario: Registration using name and empty mail field
    When User enters name "Gouse" in name field
    And Click on signUp button
    Then Email field should display "Please fill out this field."