package pl.techquiz.backend.quizapi;

import lombok.Builder;
import lombok.Data;
import pl.techquiz.backend.model.Difficulty;

@Data
@Builder
public class QuestionRequest {
    int limit;
    Difficulty difficulty;
    String category;
}
