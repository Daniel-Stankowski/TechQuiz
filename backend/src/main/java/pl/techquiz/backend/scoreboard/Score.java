package pl.techquiz.backend.scoreboard;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Score {

    @Id
    private String username;
    private String category;
    private int score;
}
