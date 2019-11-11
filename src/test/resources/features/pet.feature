@pet
Feature: Pet endpoint

  In order to verify /pet api endpoint
  As a potential api user
  I want to be able to execute various actions with Pet

  @pet01
  Scenario: Get Pet by Id
    Given I get Pet with id 5

  @pet02
  Scenario: Create pet by Id
    Given I create new Pet