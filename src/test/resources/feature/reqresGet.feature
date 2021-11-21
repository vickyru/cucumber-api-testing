Feature: Test Github API

    This is to test & demo the Github APIs

    Scenario Outline: Validate the github APIs responses
        Given User hit the get api <url>
        When User send the get all repository request
        Then User receive the response <response code>

    Examples:
        | url                 | response code |
        | https://reqres.in   | 200           |