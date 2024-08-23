
@tag
Feature: Basic reqRes flows

  @tag2
  Scenario Outline: Demo validation with Get, Post, Put methods
    Given Taking all the Users from Server
    When Creating the Request and checking the Response whether its having "<name>" and "<job>"
    Then Updating the request and checking that "<UpdatedUser>"

    Examples: 
      | name     | job    | UpdatedUser  |
      | morpheus | leader | morpheus     |
  
