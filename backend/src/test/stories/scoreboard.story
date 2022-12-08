Narrative: In order to see my progress as a player i want to see scoreboard

Scenario: User is able to sort scoreboard by best score

Given There are <scores> to sort
When Button sort <scores> is clicked
Then Scoreboard is <sorted>

Examples:
|scores|sorted|
|10,30,20,40,35,100,90|10,20,30,35,40,90,100|

Scenario: User score is added to a scoreboard

Given User gathered 100 points
When The game has ended
Then User's score is added to the scoreboard