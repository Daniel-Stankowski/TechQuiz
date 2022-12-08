package pl.techquiz.backend.quizapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.techquiz.backend.model.Question;

import java.util.List;

@RestController
@CrossOrigin(value = "http://localhost:3000")
@RequiredArgsConstructor
public class QuizApiController {

    private final QuizApiService quizApiService;

    @PostMapping("/questions")
    public List<Question> getQuestionsForCategory(@RequestBody QuestionRequest request) {

        return quizApiService.getQuestionsForCategory(request);
    }
}
