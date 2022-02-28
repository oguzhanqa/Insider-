@useInsider
Feature: Useinsider Task

  @1
  Scenario: Applying Jobs
    Given User comes to the Insider home page
    Then Selects the "More" on navigation bar
    And Navigates to "Careers"
    Then User checks the career page blocks
      | See all teams   |
      | Our Locations   |
      | Life at Insider |
    And User opens teams blocks
    Then Verifies the all teams
      | Customer Success            |
      | Sales                       |
      | Product                     |
      | Finance                     |
      | Marketing                   |
      | CEO’s Executive Office      |
      | Operations                  |
      | People and Culture          |
      | Business Intelligence       |
      | Security Engineering        |
      | Partnership                 |
      | Quality Assurance           |
      | Mobile Business Unit        |
      | Partner Support Development |
      | Product Design              |
    And Verifies all locations
      | Indianapolis     |
      | Sao Paulo        |
      | London           |
      | Paris            |
      | Amsterdam        |
      | Barcelona        |
      | Helsinki         |
      | Warsaw           |
      | Kiev             |
      | Moscow           |
      | Sydney           |
      | Dubai            |
      | Tokyo            |
      | Seoul            |
      | Hong Kong        |
      | Singapore        |
      | Bangkok          |
      | Jakarta          |
      | Taipei           |
      | Manila           |
      | Kuala Lumpur     |
      | Ho Chi Minh City |
      | Istanbul         |
      | Ankara           |
      | Mexico City      |
      | Lima             |
      | Buenos Aires     |
      | Bogota           |
      | Santiago         |

  @2
  Scenario Outline:
    Given user goes to Careers Page
    And User opens "<Block>" as one of the career page block
    Then Selects the "<Team>" one of the team
    And User goes to see qa all position
    Then User selects "<Location>", "<Department>" in order to see presence of job list
    And User verify "<Location>", "<Department>" and apply button of the jobs
    Then User verify the following position keywords of the jobs
      | QA                |
      | Quality Assurance |
    And User applies and verifies the Lever Application Form Page for each job

    Examples:
      | Block         | Team              | Location         | Department        |
      | See all teams | Quality Assurance | Istanbul, Turkey | Quality Assurance |