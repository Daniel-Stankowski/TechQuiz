package pl.techquiz.backend.scoreboard;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class ScoreService {

    private final ScoreRepository scoreRepository;
    private final  static Set<String> categories = new HashSet<>(
            Stream.of("Linux", "Bash", "PHP", "Docker", "HTML", "MySQL", "WordPress", "Laravel", "Kubernetes",
                    "JavaScript", "DevOps").map(String::toUpperCase).collect(Collectors.toList())
    );

    public Score saveUserScore(final Score score) {
        score.setCategory(score.getCategory().toUpperCase());
        return scoreRepository.save(score);
    }

    public List<Score> getUserScoresForCategory(final String category) {
        return scoreRepository.findByCategory(category.toUpperCase());
    }

    public List<CategoryScore> getScoresForAllCategories() {
        return categories.stream()
                .map(category -> CategoryScore.builder()
                        .category(category)
                        .scores(scoreRepository.findByCategory(category))
                        .build()).collect(Collectors.toList());
    }
}
