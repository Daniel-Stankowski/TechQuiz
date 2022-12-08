package steps;

import org.jbehave.core.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import pl.techquiz.backend.model.Question;
import pl.techquiz.backend.quizapi.QuestionRequest;
import pl.techquiz.backend.quizapi.QuizApiService;
import java.util.List;

public class PlaySteps {

    Logger logger = LoggerFactory.getLogger(PlaySteps.class);
    private final QuizApiService quizApiService;

    @Autowired
    public PlaySteps(QuizApiService quizApiService) {
        this.quizApiService = quizApiService;
    }

    // Scenario: Checking if questions were fetched

    private String cat;
    @Given("I have started the quiz called $category")
    public void saveCategoryName(String category){
        cat=category;
    }

    @Then("Questions showed up")
    public void checkIfQuestionsWereFetched(){

        QuestionRequest testRequest = QuestionRequest.builder()
                .limit("10")
                .category(cat)
                .difficulty("EASY")
                .build();

        List<Question> listOfQuestions = quizApiService.getQuestionsForCategory(testRequest);

        assert listOfQuestions.size()==10;
    }

    // Scenario: Checking if correct number of questions were fetched

    private String number,diff,category;

    @Given("There is $num of questions to fetch")
    public void saveNumber(String num){
        number=num;
    }

    @When("$cat and $difficulty are chosen")
    public void saveCatAndDiff(String cat, String difficulty){
        diff=difficulty;
        category=cat;
    }

    @Then("Appropriate number of questions are fetched")
    public void fetchCorrectNumOfQuestions(){
        QuestionRequest qr = QuestionRequest.builder()
                .category(category)
                .limit(number)
                .difficulty(diff)
                .build();

        List<Question> listOfQuestions = quizApiService.getQuestionsForCategory(qr);

        assert listOfQuestions.size() == Integer.parseInt(number);
    }

    // Scenario: User gives correct answer

    String usrAnswer;
    @Given("User chooses $answer")
    public void userChoseAnswer(String answer){
        logger.info("User's answer: "+answer);
        usrAnswer=answer;
    }

    @When("Proceeds to next question")
    public void confirmsTheAnswer(){
        logger.info("Answer confirmed");
    }

    @Then("System checks if answer is $correct_answer")
    public void checkCorrectness(String correct_answer){
        assert correct_answer.equals(usrAnswer);
        logger.info("Answer was correct");
    }

    @Then("System gives point to user if so")
    public void givePoints(){
        logger.info("Points were added...");
    }

    // Scenario: User gives wrong answer

    @Then("System sees wrong answer, correct is $correct_answer")
    public void checkNotCorrect(String correct_answer){
        assert !correct_answer.equals(usrAnswer);
    }

    @Then("System does not give points")
    public void dontGivePoints(){
        logger.info("Points not added...");
    }

}
