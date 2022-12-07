package pl.techquiz.backend.quizapi;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.techquiz.backend.model.Question;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizApiService {

    @Value("${quiz.api.url}")
    private String quizApiUrl;

    @Value("${quiz.api.token}")
    private String token;

    private final RestTemplate restTemplate;

    public List<Question> getQuestionsForCategory(final QuestionRequest request) {
        return restTemplate.exchange(
                this.quizApiUrl,
                HttpMethod.GET,
                new HttpEntity<>(request, createHeaders()),
                new ParameterizedTypeReference<List<Question>>(){}
        ).getBody();
    }

    private HttpHeaders createHeaders() {
        final HttpHeaders headers = new HttpHeaders();
        headers.add("X-Api-Key", this.token);
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}
