Feature: Film Page

  Scenario: See all films
    Given the user is on the home page
    When the user clicks on the Films link
    Then the user should be taken to the Film page
    And the user should see a list of films

  Scenario: See film details
    Given the user is on the film page
    When the user clicks on a film
    Then the user should be taken to the film details page
    And the user should see the film details

  Scenario: Search for a film
    Given the user is on the film page
    When the user clicks on the search bar
    And types the name of a film
    Then the correct film should be displayed

  Scenario: Successfully create a new film
    Given the user is on the film page
    When the user clicks on the create button
    And the user enters valid film details
    And the user submits the form
    Then a success message should be displayed
    Then the film should be added to the film list

  Scenario: Attempt to create film with empty fields
    Given the user is on the film page
    When the user clicks on the create button
    And the user leaves the film details blank
    And the user submits the form
    Then the film form should not be submitted

  Scenario: Attempt to create film with invalid release year
    Given the user is on the film page
    When the user clicks on the create button
    And the user enters invalid release year
    And the user submits the form
    Then the film form should not be submitted