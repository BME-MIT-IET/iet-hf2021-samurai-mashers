Feature: How can these packages be stored in this storage?
  The workers want to know how this is possible

  Scenario: We can fit them in storage
    Given the first set of packages
    When we run the program
    Then we get a correct result

  Scenario: We cannot fit them in storage
    Given the second set of packages
    When we run the program
    Then we get a correct result

  Scenario: We can fit them in storage
    Given the third set of packages
    When we run the program
    Then we get a correct result

  Scenario: We cannot fit them in storage
    Given the fourth set of packages
    When we run the program
    Then we get a correct result
