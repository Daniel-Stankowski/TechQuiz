package pl.techquiz.backend.quizapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.Collections;

@Configuration
public class QuizApiConfig {
    private static final int READ_TIMEOUT = 100000;
    private static final int CONNECTION_TIMEOUT = 100000;

    private static final Logger logger = LoggerFactory.getLogger(QuizApiConfig.class);

    @Bean
    public RestTemplate createRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(requestFactory());
        restTemplate.setInterceptors(Collections.singletonList((request, body, execution) -> {
            logger.info(new String(body, StandardCharsets.UTF_8));
            ClientHttpResponse response = execution.execute(request, body);
            logger.info(new String(response.getBody().readAllBytes(), StandardCharsets.UTF_8));
            return response;
        }));
        return restTemplate;
    }

    private ClientHttpRequestFactory requestFactory() {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setReadTimeout(READ_TIMEOUT);
        requestFactory.setConnectTimeout(CONNECTION_TIMEOUT);
        requestFactory.setOutputStreaming(false);
        return new BufferingClientHttpRequestFactory(requestFactory);
    }
}
