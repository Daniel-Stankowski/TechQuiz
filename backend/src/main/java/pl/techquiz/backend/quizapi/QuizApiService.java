package pl.techquiz.backend.quizapi;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import pl.techquiz.backend.model.Question;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class QuizApiService {

    private final WebClient webClient;

    public List<Question> getQuestionsForCategory(final QuestionRequest request) {
        final QuizApiRequest quizApiRequest = QuizApiRequest.builder()
                .tags(request.getCategory())
                .difficulty(request.getDifficulty())
                .limit(request.getLimit())
                .build();

        return webClient.method(HttpMethod.GET)
                .body(Mono.just(quizApiRequest), QuestionRequest.class)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Question>>() {
                })
                .block();
    }
}
