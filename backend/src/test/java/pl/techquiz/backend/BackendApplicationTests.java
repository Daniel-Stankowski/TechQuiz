package pl.techquiz.backend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.techquiz.backend.scoreboard.Score;
import pl.techquiz.backend.scoreboard.ScoreService;

@SpringBootTest
class BackendApplicationTests {

	@Autowired
	ScoreService scoreService;


	@Test
	void contextLoads() {

	}

}
