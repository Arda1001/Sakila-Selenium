Feature: Actor Page

  Scenario: See all actors
    Given the user is on the home page
    When the user clicks on the Actors link
    Then the user should be taken to the Actor page
    And the user should see a list of actors