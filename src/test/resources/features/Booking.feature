Feature: Booking

  Background:
    Given I am on the homepage

  Scenario: Book a one-way flight
    When I select the "One Way" option
    And I select the route from "TIA" to "MUC"
    And I select "Current Day" date on the "Next Month 2023"
    And I specify 2 adult travelers in "Economy"
    And I select the 1 price and I choose "FLEX" as a plan
    And I fill all clients info
    Then I select the card payment option
    Then I choose seat "22A" or any window seat if it's not available
    Then I confirm the booking after adding "1234" as a CCV code
    Then I should see the booking reference number and a message asking me to write it down or remember it
    And the booking reference number should be displayed on the console

  Scenario: Build a return flight
    When I select the "Round Trip" option
    And I select the route from "TIA" to "MUC"
    And I select "Current Day" date on the "May 2023"
    And I select "Current Day" return date on the "Next Month 2023"
    And I specify 2 adult 1 infant travelers in "Business"
    And I select the 1 price and I choose "FLEX" as a plan
    And I fill all clients info
    Then I select the card payment option
    Then I add Car
    Then I confirm the booking after adding "1234" as a CCV code
    Then I should see the booking reference number and a message asking me to write it down or remember it
    And the booking reference number should be displayed on the console

    Scenario: Build a multiLeg flight
      When I select the "Multi Destinations" option
      And I set a 7 day  multi desitination trip with route "Tirana-Vienna-Bangkok-Vienna" in "Next Month"
      And I specify 3 adult and 2 childs travelers in "Economy"
      Then I add preferred airline "Austrian"
      And I select the 1 price and I choose "Economy" as a plan
      And I fill all clients info
      Then I select the card payment option
      Then I add Hotel
      Then I confirm the booking after adding "1234" as a CCV code
      Then I should see the booking reference number and a message asking me to write it down or remember it
      And the booking reference number should be displayed on the console









