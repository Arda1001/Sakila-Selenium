Feature: Navigation

  Scenario: Navigate from the home page to the actor page
    Given the user is on the home page
    When the user clicks on the Actors link
    Then the user should be taken to the Actor page
    And the user should see a list of actors

  Scenario: Navigate from the home page to the film page
    Given the user is on the home page
    When the user clicks on the Films link
    Then the user should be taken to the Film page
    And the user should see a list of films

  Scenario: Navigate from the home page to the language page
    Given the user is on the home page
    When the user clicks on the Languages link
    Then the user should be taken to the Language page
    And the user should see a list of languages

  Scenario: Stay on the home page
    Given the user is on the home page
    When the user clicks on the Home link
    Then the user should stay on the Home page
    And the user should see the home page

  Scenario: Stay on the actor page
    Given the user is on the actor page
    When the user clicks on the Actors link
    Then the user should stay on the Actor page
    And the user should see a list of actors

  Scenario: Stay on the film page
    Given the user is on the film page
    When the user clicks on the Films link
    Then the user should stay on the Film page
    And the user should see a list of films

  Scenario: Stay on the language page
    Given the user is on the language page
    When the user clicks on the Languages link
    Then the user should stay on the Language page
    And the user should see a list of languages

  Scenario: Navigate from the actor page to the home page
    Given the user is on the actor page
    When the user clicks on the Home link
    Then the user should be taken to the home page
    And the user should see the home page

  Scenario: Navigate from the film page to the home page
    Given the user is on the film page
    When the user clicks on the Home link
    Then the user should be taken to the home page
    And the user should see the home page

  Scenario: Navigate from the language page to the home page
    Given the user is on the language page
    When the user clicks on the Home link
    Then the user should be taken to the home page
    And the user should see the home page

  Scenario: Navigate from the actor page to the film page
    Given the user is on the actor page
    When the user clicks on the Films link
    Then the user should be taken to the Film page
    And the user should see a list of films

  Scenario: Navigate from the actor page to the language page
    Given the user is on the actor page
    When the user clicks on the Languages link
    Then the user should be taken to the Language page
    And the user should see a list of languages

  Scenario: Navigate from the film page to the actor page
    Given the user is on the film page
    When the user clicks on the Actors link
    Then the user should be taken to the Actor page
    And the user should see a list of actors

  Scenario: Navigate from the film page to the language page
    Given the user is on the film page
    When the user clicks on the Languages link
    Then the user should be taken to the Language page
    And the user should see a list of languages

  Scenario: Navigate from the language page to the actor page
    Given the user is on the language page
    When the user clicks on the Actors link
    Then the user should be taken to the Actor page
    And the user should see a list of actors

  Scenario: Navigate from the language page to the film page
    Given the user is on the language page
    When the user clicks on the Films link
    Then the user should be taken to the Film page
    And the user should see a list of films

  Scenario: Navigate from the actor details page to the actor page
    Given the user is on the actor details page
    When the user clicks on the Actors link
    Then the user should be taken to the Actor page
    And the user should see a list of actors

  Scenario: Navigate from actor details page to the film page
    Given the user is on the actor details page
    When the user clicks on the Films link
    Then the user should be taken to the Film page
    And the user should see a list of films

  Scenario: Navigate from the actor details page to the language page
    Given the user is on the actor details page
    When the user clicks on the Languages link
    Then the user should be taken to the Language page
    And the user should see a list of languages

  Scenario: Navigate from the actor details page to the home page
    Given the user is on the actor details page
    When the user clicks on the Home link
    Then the user should be taken to the home page
    And the user should see the home page

  Scenario: Navigate from the film details page to the film page
    Given the user is on the film details page
    When the user clicks on the Films link
    Then the user should be taken to the Film page
    And the user should see a list of films

  Scenario: Navigate from the film details page to the actor page
    Given the user is on the film details page
    When the user clicks on the Actors link
    Then the user should be taken to the Actor page
    And the user should see a list of actors

  Scenario: Navigate from the film details page to the language page
    Given the user is on the film details page
    When the user clicks on the Languages link
    Then the user should be taken to the Language page
    And the user should see a list of languages

  Scenario: Navigate from the film details page to the home page
    Given the user is on the film details page
    When the user clicks on the Home link
    Then the user should be taken to the home page
    And the user should see the home page

  Scenario: Navigate from the actor details page to the film details page
    Given the user is on the actor details page
    When the user clicks on a film
    Then the user should be taken to the film details page
    And the user should see the film details

  Scenario: Navigate from the film details page to the actor details page
    Given the user is on the film details page
    When the user clicks on an actor
    Then the user should be taken to the actor details page
    And the user should see the actor details

  Scenario: Test invalid url navigation
    Given the user goes to an invalid url
    Then the user should see an error page

