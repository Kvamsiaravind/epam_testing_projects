Feature: SignIn or SignOut feature

  Background: User opening base url
    Given User open base url "https://automationexercise.com"
    When User click on signUp or LogIn button in homepage

  @positive
  Scenario: User signIn successfully using registered email
    When User enter registered email "car1@gmail.com" and correct password "Varun@1"
    And User click on LogIn button
    Then Verify the results page as "Logged in as Gouse"

  @positive
  Scenario: User signOut successfully after login
    When User on result page by logged in to logIn page using valid credentials email "car1@gmail.com" and password "Varun@1"
    And User click on logout button
    Then verify the it is logIn page or not by asserting "Signup / Login"

  @negative
  Scenario: User signIn using unregistered mail
    When User enter unregistered email "gouseboy.dr@gmail.com" and password "Gouse@123"
    And User click on LogIn button
    Then Verify the result using "Your email or password is incorrect!"

  @negative
  Scenario: User signIn using registered mail using wrong password
    When User enter registered email "gouse.dr@gmail.com" and wrong password "Gouse123"
    And User click on LogIn button
    Then Verify the result using "Your email or password is incorrect!"

  @negative
  Scenario: User signIn using entering mail only by missing password
    When User enter the mail "Gouse.dr@gmail.com"
    And User click on LogIn button
    Then Verify the password field showing  "Please fill out this field."

  @negative
  Scenario: User signIn using entering password only by missing mail
    When User enter password "Gouse@123"
    And User click on LogIn button
    Then Verify email field using "Please fill out this field."

  @negative
  Scenario: User delete his account after successfully login
    When User enter registered email "varu@gmail.com" and correct password "Varun@1"
    And User click on LogIn button
    And User click on delete account button
    Then Verify account deleted or not by asserting "ACCOUNT DELETED!"