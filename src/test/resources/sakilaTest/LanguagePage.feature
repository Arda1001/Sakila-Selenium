Feature: Language Page

  Scenario: See all languages
    Given the user is on the home page
    When the user clicks on the Languages link
    Then the user should be taken to the Language page
    And the user should see a list of languages

  Scenario: Search for a language
    Given the user is on the language page
    When the user clicks on the search bar
    And types the name of a language
    Then the correct language should be displayed

  Scenario: Successfully create a new language
    Given the user is on the language page
    When the user clicks on the create language button
    And the user enters valid language details
    And the user submits the form
    Then a success message should be displayed
    Then the language should be added to the language list

  Scenario: Attempt to create language with empty field
    Given the user is on the language page
    When the user clicks on the create language button
    And the user leaves the language details blank
    And the user submits the form
    Then the language form should not be submitted