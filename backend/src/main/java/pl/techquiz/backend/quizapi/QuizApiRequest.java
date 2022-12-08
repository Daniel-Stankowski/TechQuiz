package pl.techquiz.backend.quizapi;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QuizApiRequest {
    private String limit;
    private String difficulty;
    private String tags;
}
