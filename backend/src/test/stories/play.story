Narrative: In order to learn as a website user I want to take part in the quiz

Scenario: Checking if questions were fetched

Given I have started the quiz called <category>
Then Questions showed up

Examples:
|category|
|PHP|
|JavaScript|

Scenario: Check if different number of questions were fetched

Given There is <number> of questions to fetch
When <Category> and <difficulty> are chosen
Then Appropriate number of questions are fetched

Examples:
|number|Category|difficulty|
|5|MySQL|EASY|
|10|Docker|MEDIUM|
|12|HTML|HARD|