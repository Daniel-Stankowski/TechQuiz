package pl.techquiz.backend.scoreboard;

import lombok.Data;

@Data
public class ScoreRequest {
    private String username;
    private String category;
    private int score;
}
