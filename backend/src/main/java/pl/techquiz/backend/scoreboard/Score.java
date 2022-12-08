package pl.techquiz.backend.scoreboard;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
@IdClass(ScoreKey.class)
public class Score {

    @Id
    private String username;
    @Id
    private String category;
    private int score;
}
