@petStore

Feature: Store

  ** As a ** user
  ** I want to ** manage the pets
  ** So that I can *** create-update-get my pets

  @createPet
  Scenario Outline: Validate create a pet successful
    Given <clientName> is a pet store user
    When creates a pet
      | id   | category.id   | category.name   | name   | photoUrls   | tags.id   | tags.name   | status   |
      | <id> | <category.id> | <category.name> | <name> | <photoUrls> | <tags.id> | <tags.name> | <status> |
    Then Will verify that the request was made successfully
      | status_code | status_message | schema_path         |
      | 200         | OK             | pet/createPetSchema |
    And will verify that the information from the pet creation is correct
      | id   | category.id   | category.name   | name   | photoUrls   | tags.id   | tags.name   | status   |
      | <id> | <category.id> | <category.name> | <name> | <photoUrls> | <tags.id> | <tags.name> | <status> |

    Examples:
      | clientName | id | category.id | category.name | name   | photoUrls   | tags.id | tags.name | status    |
      | Sebastian  | 88 | 88          | name34        | name34 | photoUrls34 | 88      | name34    | available |


  @deletePet
  Scenario Outline: Validate delete a pet successful
    Given <clientName> is a pet store user
    When creates a pet
      | id   | category.id   | category.name   | name   | photoUrls   | tags.id   | tags.name   | status   |
      | <id> | <category.id> | <category.name> | <name> | <photoUrls> | <tags.id> | <tags.name> | <status> |
    When deletes a pet
      | id   |
      | <id> |
    Then Will verify that the request was made successfully
      | status_code | status_message | schema_path         |
      | 204         | OK             | pet/deletePetSchema |

    Examples:
      | clientName | id   | category.id | category.name | name   | photoUrls   | tags.id | tags.name | status    |
      | Sebastian  | 3333 | 88          | name34        | name34 | photoUrls34 | 88      | name34    | available |