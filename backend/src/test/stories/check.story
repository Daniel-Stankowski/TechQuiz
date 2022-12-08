Narrative: In order to test my knowledge i want to know correct answer

Scenario: User gives correct answer

Given User chooses <answer>
When Proceeds to next question
Then System checks if answer is <correct_answer>
And System gives point to user if so

Examples:
|answer|correct_answer|
|a|a|
|poprawnaOdpowiedz|poprawnaOdpowiedz|

Scenario: User gives wrong answer

Given User chooses <answer>
When Proceeds to next question
Then System sees wrong answer, correct is <correct_answer>
And System does not give points

Examples:
|answer|correct_answer|
|b|a|
|poprawnaOdpowiedz|niepoprawnaOdpowiedz|