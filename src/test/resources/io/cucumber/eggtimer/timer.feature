Feature: Test timer

  Scenario Outline: check Help and settings button
    Given I navigate to eggtimer home page
    When click help and settings button
    Then help and settings window should open
    Examples:
      | |
      | |

  Scenario Outline: Check all the sample timer buttons availability
    Given I navigate to eggtimer home page
    Then all the sample timers should be available
    Examples:
      | |
      | |

  Scenario Outline: check that the countdown timer for seconds
    Given I navigate to eggtimer home page
    And enter <time> seconds
    And user clicks the start button
    Then countdown timer should start
    And time expired alert is shown after <time> seconds

    Examples:
      | time |
      | 20   |

  Scenario Outline: check that the countdown timer after clicking one of the minutes button
    Given I navigate to eggtimer home page
    And click the <time> minutes button
    Then countdown timer should start
    And time expired alert is shown after <time> minutes
    Examples:
      | time |
      | 5   |

  Scenario Outline: check start button after giving invalid time value
    Given I navigate to eggtimer home page
    And enter invalid time <time>
    And user clicks the start button
    Then countdown timer should not start

    Examples:
      | time |
      | pop  |



