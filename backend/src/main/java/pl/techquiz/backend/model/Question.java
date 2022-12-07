package pl.techquiz.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import pl.techquiz.backend.model.answers.Answer;
import pl.techquiz.backend.model.answers.CorrectAnswer;

@Data
public class Question {
    int id;
    String question;
    String description;
    Answer answers;

    @JsonProperty(value = "multiple_correct_answers")
    boolean multipleCorrectAnswers;

    @JsonProperty(value = "correct_answers")
    CorrectAnswer correctAnswers;

    @JsonProperty(value = "correct_answer")
    String correctAnswer;
    
    String explanation;
    String tip;
}
