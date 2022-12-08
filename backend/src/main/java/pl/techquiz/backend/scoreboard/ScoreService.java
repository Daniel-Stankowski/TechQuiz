package pl.techquiz.backend.scoreboard;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScoreService {

    private final ScoreRepository scoreRepository;

    public Score saveUserScore(final ScoreRequest scoreRequest) {
        final Score newScore = new Score(
                scoreRequest.getUsername(), scoreRequest.getCategory(), scoreRequest.getScore());

        return scoreRepository.save(newScore);
    }

    public List<Score> getUserScoresForCategory(final String category) {
        return scoreRepository.findByCategory(category);
    }
}
