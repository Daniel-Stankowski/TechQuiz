package pl.techquiz.backend.scoreboard;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Table
@Entity
@NoArgsConstructor
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String category;
    private int score;

    public Score(String username, String category, int score) {
        this.username = username;
        this.category = category;
        this.score = score;
    }



}
