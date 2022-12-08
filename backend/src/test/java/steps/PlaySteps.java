package steps;

import org.jbehave.core.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;


public class PlaySteps {

    Logger logger = LoggerFactory.getLogger(PlaySteps.class);

    @BeforeStories
    public void doSomethingBeforeStories(){
        System.out.println("cos przed stories");
    }

    //Scenario: Trying to start the quiz

    @Given("I am on website")
    public void mainPageDisplayed(){
        logger.info("website displayed");
    }

    @When("I click start button")
    public void startButtonClicked(){
        logger.info("clicked");
    }

    @Then("Quiz appears")
    public void quizAppeared(){
        logger.info("appeared");
    }

//    // Scenario: Checking if answer is correct
//
//    @Given("I have started the quiz called $quiz")
//    public void quizTestowe(String quiz){
//        logger.info("QUIZ: "+quiz);
//    }
//
//    @Given("Question showed up - $question")
//    public void questionTestowe(String question) {
//        logger.info("QUESTION: "+question);
//    }
//
//    @When("I have chosen an answer - $answer")
//    public void answerTestowe(String answer) {
//        logger.info("ANSWER: "+answer);
//    }
//
//    @Then("Correct answer highlights - $correctAnswer")
//    public void correctAnswerTestowe(String correctAnswer) {
//        logger.info("CORRECT ANSWER: "+correctAnswer);
//    }
//
//    @Then("I got score if I chose right answer $answer == $correct_answer")
//    public void checkAnswer(String answer, String correctAnswer){
//        logger.info(answer+"=="+correctAnswer+"?");
//        assertEquals(answer,correctAnswer);
//    }
//
//    //Scenario: User is able to sort scoreboard by best score
//
//    @Given("There are $scores to sort")
//    public void scoresExistCheck(String scores) {
//        logger.info("SCORES: "+scores);
//
//        if(scores==null || scores.equals("")) throw new NullPointerException("Null value");
//
//    }
//
//    private List<Integer> sortedScores;
//    @When("Button sort $scores is clicked")
//    public void sortScores(String scores) {
//        System.out.println("SORTING SCORES...");
//
//        //testowanie sortowania
//        sortedScores = Arrays.stream(scores.split(","))
//                .toList().stream().map(Integer::parseInt).sorted().collect(Collectors.toList());
//
//        logger.info("SORTED LIST: "+sortedScores);
//
//    }
//
//
//    @Then("Scoreboard is $sorted")
//    public void scoreboardSortCheck(String sorted) {
//        logger.info("SORT CHECK...");
//        assertEquals(sortedScores, Arrays.stream(sorted.split(",")).map(Integer::parseInt).toList());
//        logger.info("PROPERLY SORTED");
//    }
//
//    @AfterStories
//    public void doSomethingAfterStories(){
//        System.out.println("cos po stories");
//    }

}
