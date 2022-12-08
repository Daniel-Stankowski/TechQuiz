package steps;

import org.jbehave.core.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import pl.techquiz.backend.scoreboard.Score;
import pl.techquiz.backend.scoreboard.ScoreService;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreboardSteps {


    private final Logger logger = LoggerFactory.getLogger(ScoreboardSteps.class);
    private final ScoreService scoreService;
    private final Score user;

    @Autowired
    public ScoreboardSteps(ScoreService scoreService) {
        this.scoreService = scoreService;
        this.user = new Score();
    }

    // Scenario: User score is added to a scoreboard

    @Given("Player gathered $points points")
    public void saveScoreOfUser(int points) {
        user.setScore(points);
    }

    @When("Player $testPlayer has ended the game of $category")
    @Alias("End of the game")
    public void endOfTheGame(String testPlayer, String category) {
        user.setCategory(category);
        user.setUsername(testPlayer);
    }

    @Then("User's score is added to the scoreboard")
    public void addToTheScoreboard() {
        scoreService.saveUserScore(user);
        List<Score> fetchedScores = scoreService.getUserScoresForCategory("linuxCategory");
        assertEquals(fetchedScores.get(0).getScore(), 100);
    }

    // Scenario: User browses scoreboard in specific category

    @Given("There are some highscores in bash category scoreboard")
    public void generateScores() {
        scoreService.saveUserScore(new Score("testPlayer1", "bash", 50));
        scoreService.saveUserScore(new Score("testPlayer2", "bash", 80));
        scoreService.saveUserScore(new Score("testPlayer3", "bash", 20));
    }

    private List<Score> scoreboardScores;

    @When("User opens the scoreboard window")
    public void fetchScoreboardScores() {
        scoreboardScores = scoreService.getUserScoresForCategory("bash");
    }


    @Then("Scoreboard appears with results")
    public void checkContentOfScoreboard(){
        assert scoreboardScores.get(0).getScore()==50;
        assert scoreboardScores.get(1).getScore()==80;
        assert scoreboardScores.get(2).getScore()==20;
        assert scoreboardScores.get(0).getUsername().equals("testPlayer1");
        assert scoreboardScores.get(1).getUsername().equals("testPlayer2");
        assert scoreboardScores.get(2).getUsername().equals("testPlayer3");
    }


    // Scenario: User browses empty scoreboard in specific category

    @Given("There are no scores in HTML category scoreboard")
    public void checkIfEmptyScoreboard(){
        assert scoreService.getUserScoresForCategory("HTML").size() == 0;
    }

    @Then("Scoreboard appears with empty results")
    public void tryToFetchSomeResult(){
        List<Score> scores=scoreService.getUserScoresForCategory("HTML");
        try{
            Score score = scores.get(0);
        }catch(IndexOutOfBoundsException e){
            assert true;
        }
    }


}
