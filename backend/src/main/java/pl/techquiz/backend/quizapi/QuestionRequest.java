package pl.techquiz.backend.quizapi;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QuestionRequest {
    String limit;
    String difficulty;
    String category;
}
