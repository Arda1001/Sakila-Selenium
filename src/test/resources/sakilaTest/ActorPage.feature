Feature: Actor Page

  Scenario: See all actors
    Given the user is on the home page
    When the user clicks on the Actors link
    Then the user should be taken to the Actor page
    And the user should see a list of actors

  Scenario: See actor details
    Given the user is on the actor page
    When the user clicks on an actor
    Then the user should be taken to the actor details page
    And the user should see the actor details

  Scenario: Search for an actor
    Given the user is on the actor page
    When the user clicks on the search bar
    And types the name of an actor
    Then the correct actor should be displayed

  Scenario: Successfully create a new actor
    Given the user is on the actor page
    When the user clicks on the create button
    And the user enters valid actor details
    And the user submits the form
    Then a success message should be displayed
    Then the actor should be added to the actor list

  Scenario: Attempt to create actor with empty fields
    Given the user is on the actor page
    When the user clicks on the create button
    And the user leaves the actor details blank
    And the user submits the form
    Then the actor form should not be submitted
