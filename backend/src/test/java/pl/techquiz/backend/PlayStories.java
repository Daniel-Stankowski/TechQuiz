package pl.techquiz.backend;

import org.jbehave.core.ConfigurableEmbedder;
import org.jbehave.core.InjectableEmbedder;
import org.jbehave.core.annotations.Configure;
import org.jbehave.core.annotations.UsingEmbedder;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.failures.FailingUponPendingStep;
import org.jbehave.core.failures.PendingStepStrategy;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.spring.SpringAnnotatedEmbedderRunner;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.jupiter.api.Test;
//import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.techquiz.backend.quizapi.QuizApiService;
import pl.techquiz.backend.scoreboard.ScoreService;
import steps.PlaySteps;


import java.util.List;


@SpringBootTest
public class PlayStories extends ConfigurableEmbedder {


    @Autowired
    QuizApiService quizApiService;
    public Embedder embedder;

    @Test
    public void run(){

    embedder = configuredEmbedder();
    embedder.configuration();
    List<String> paths = List.of(
            "play.story",
            "check.story"
    );

    embedder.runStoriesAsPaths(paths);


    }

    public Configuration configuration() {
        return new MostUsefulConfiguration().useStoryReporterBuilder(new StoryReporterBuilder().
                withDefaultFormats().withFormats(Format.CONSOLE, org.jbehave.core.reporters.Format.HTML));
    }

    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new PlaySteps(quizApiService));
    }

}