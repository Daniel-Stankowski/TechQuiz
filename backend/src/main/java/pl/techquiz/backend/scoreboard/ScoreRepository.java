package pl.techquiz.backend.scoreboard;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScoreRepository extends JpaRepository<Score, Long> {
    List<Score> findByCategory(String category);
}
