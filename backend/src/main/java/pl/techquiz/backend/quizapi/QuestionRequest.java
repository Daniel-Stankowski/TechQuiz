package pl.techquiz.backend.quizapi;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QuestionRequest {
    int limit;
    String difficulty;
    String category;
}
