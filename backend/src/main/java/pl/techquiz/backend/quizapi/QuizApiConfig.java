package pl.techquiz.backend.quizapi;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;

@Configuration
public class QuizApiConfig {

    @Value("${quiz.api.url}")
    private String quizApiUrl;

    @Value("${quiz.api.token}")
    private String token;

    private static final int READ_TIMEOUT = 100000;
    private static final int CONNECTION_TIMEOUT = 100000;
    private static final int RESPONSE_TIMEOUT = 100000;
    private static final int WRITE_TIMEOUT = 100000;

    @Bean
    public WebClient createWebClient() {
        return WebClient.builder()
                .clientConnector(connector())
                .baseUrl(this.quizApiUrl)
                .defaultHeaders(httpHeaders -> {
                    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
                    httpHeaders.add("X-Api-Key", this.token);
                })
                .build();
    }

    private ReactorClientHttpConnector connector() {
        final HttpClient httpClient = HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, CONNECTION_TIMEOUT)
                .responseTimeout(Duration.ofMillis(RESPONSE_TIMEOUT))
                .doOnConnected(connection -> {
                    connection.addHandlerLast(new ReadTimeoutHandler(READ_TIMEOUT));
                    connection.addHandlerLast(new WriteTimeoutHandler(WRITE_TIMEOUT));
                });
        return new ReactorClientHttpConnector(httpClient);
    }
}
