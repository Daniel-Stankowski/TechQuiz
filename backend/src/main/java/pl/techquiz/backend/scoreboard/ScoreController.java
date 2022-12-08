package pl.techquiz.backend.scoreboard;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/score")
@CrossOrigin(value = "http://localhost:3000")
public class ScoreController {

    private final ScoreService scoreService;

    @PostMapping
    public Score saveUserScore(@RequestBody Score scoreRequest) {
        return scoreService.saveUserScore(scoreRequest);
    }

    @GetMapping
    public List<Score> getScoresForCategory(@RequestParam String category) {
        return scoreService.getUserScoresForCategory(category);
    }

    @GetMapping("/all")
    public List<CategoryScore> getCategoryScores() {
        return scoreService.getScoresForAllCategories();
    }
}
