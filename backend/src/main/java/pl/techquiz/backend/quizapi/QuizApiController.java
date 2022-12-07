package pl.techquiz.backend.quizapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.techquiz.backend.model.Question;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class QuizApiController {

    private final QuizApiService quizApiService;

    private static final Logger logger = LoggerFactory.getLogger(QuizApiConfig.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/questions")
    public List<Question> getQuestionsForCategory(@RequestBody QuestionRequest request) {

        final List<Question> questions = quizApiService.getQuestionsForCategory(request);

        try {
            logger.info(objectMapper.writeValueAsString(questions));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return questions;
    }
}
