Feature: Pet endpoint

  In order to verify /pet api endpoint
  As a potential api user
  I want to be able to execute various actions with Pet

  Scenario: Get Pet by Id
    Given I get Pet with id 5

  Scenario: Create pet by Id
    Given I create new Pet