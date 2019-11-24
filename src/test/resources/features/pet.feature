@pet
Feature: Pet endpoint

  In order to verify /pet api endpoint
  As a potential api user
  I want to be able to execute various actions with Pet

  @pet01
  Scenario: Create pet by Id
    Given I create new Pet with following data
      | Pet id | Pet name | Category id | Category name | Status      |
      | 67     | Murzik   | 77          | Cats          | unavailable |
    Then I assert status code is 200


  @pet02
  Scenario: Get Pet by Id
    Given I create new Pet with following data
      | Pet id | Pet name | Category id | Category name | Status    |
      | 66     | Murzik   | 77          | Cats          | available |
    And I assert status code is 200
    When I get Pet with id 66
    Then I assert status code is 200

  @pet03
  Scenario: Get pet by status
    Given I create new Pet with following data
      | Pet id | Pet name | Category id | Category name | Status |
      | 68     | Murzik   | 77          | Cats          | sold   |
    And I assert status code is 200
    When I get Pet by status "sold"
    Then I assert status code is 200

  @pet04
  Scenario: Delete pet by Id
    Given I create new Pet with following data
      | Pet id | Pet name | Category id | Category name | Status    |
      | 11     | Barsik   | 77          | Cats          | available |
    And I assert status code is 200
    When I delete Pet with id 11
    Then I assert status code is 200

