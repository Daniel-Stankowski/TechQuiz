package steps;

import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import pl.techquiz.backend.scoreboard.Score;
import pl.techquiz.backend.scoreboard.ScoreService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreboardSteps {

    private int score;

    private final ScoreService scoreService;

    Logger logger = LoggerFactory.getLogger(ScoreboardSteps.class);


    @Autowired
    public ScoreboardSteps(ScoreService scoreService) {
        this.scoreService = scoreService;
    }


    public void dependencyTest(){
        System.out.println("dasokjsoigfjerg");
    }

    @Given("User gathered $points points")
    public void saveScoreOfUser(int points){
        score=points;
    }

    @When("The game has ended")
    @Alias("End of the game")
    public void endOfTheGame(){
        logger.info("DZIALAJ");
    }

    @Then("User's score is added to the scoreboard")
    public void addToTheScoreboard(){

        Score userScore = new Score("test","testowy",score);

        scoreService.saveUserScore(userScore);

        List<Score> fetchedScores = scoreService.getUserScoresForCategory("testowy");

        assertEquals(fetchedScores.get(0).getScore(),score);
        //assert true;
    }


}
