Feature: Elements on Different Elements Page are clickable and log panel shows users actions

  Scenario: Check checkboxes, radio buttons and dropdown

    Given I open JDI GitHub site
    And I login as user "Roman Iovlev"
    Then "Home Page" page should be opened
    And Username should be "ROMAN IOVLEV"
    When I click on "Service" button in Header
    And I click on "Different elements" button in Service dropdown
    And I select checkboxes
      | Water |
      | Wind  |
    And I select radio button "Selen"
    And I select dropdown "Yellow"
    Then I see in log section:
      | Colors: value changed to Yellow  |
      | metal: value changed to Selen    |
      | Wind: condition changed to true  |
      | Water: condition changed to true |
