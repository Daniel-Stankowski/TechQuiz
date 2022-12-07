package pl.techquiz.backend.model;

import lombok.Data;
import pl.techquiz.backend.model.answers.Answer;
import pl.techquiz.backend.model.answers.CorrectAnswer;

@Data
public class Question {
    int id;
    String question;
    String description;
    Answer answers;
    boolean multipleCorrectAnswers;
    CorrectAnswer correctAnswers;
    String correctAnswer;
    String explanation;
    String tip;
}
