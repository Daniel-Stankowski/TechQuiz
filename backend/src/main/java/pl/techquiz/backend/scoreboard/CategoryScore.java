package pl.techquiz.backend.scoreboard;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CategoryScore {
    private String category;
    private List<Score> scores;
}
