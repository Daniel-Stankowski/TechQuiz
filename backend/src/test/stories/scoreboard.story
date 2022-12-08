Narrative: In order to see my progress as a player i want to see scoreboard

Scenario: User score is added to a scoreboard

Given Player gathered 100 points
When Player supergracz has ended the game of linuxCategory
Then User's score is added to the scoreboard

Scenario: User browses scoreboard in specific category

Given There are some highscores in bash category scoreboard
When User opens the scoreboard window
Then Scoreboard appears with results

Scenario: User browses empty scoreboard in specific category

Given There are no scores in HTML category scoreboard
When User opens the scoreboard window
Then Scoreboard appears with empty results