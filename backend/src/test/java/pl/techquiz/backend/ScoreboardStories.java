package pl.techquiz.backend;

import org.jbehave.core.ConfigurableEmbedder;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import pl.techquiz.backend.scoreboard.ScoreRepository;
import pl.techquiz.backend.scoreboard.ScoreService;
import steps.PlaySteps;
import steps.ScoreboardSteps;


import java.util.List;

import static java.util.Arrays.asList;
import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

//@RunWith(SpringRunner.class)
//@ExtendWith(SpringExtension.class)

@SpringBootTest
public class ScoreboardStories extends ConfigurableEmbedder {

    private StoryReporterBuilder reporterBuilder;

    @Autowired
    ScoreService scoreService;

    public Embedder embedder;


    @Test
    public void run(){

        reporterBuilder = new StoryReporterBuilder()
                .withCodeLocation(codeLocationFromClass(ScoreboardStories.class)).withFailureTrace(true)
                .withFailureTraceCompression(true).withDefaultFormats();

        embedder = configuredEmbedder();
        embedder.configuration();

        List<String> paths = List.of(
                "scoreboard.story"
        );
        embedder.runStoriesAsPaths(paths);
    }

    public Configuration configuration() {
        return new MostUsefulConfiguration().useStoryReporterBuilder(new StoryReporterBuilder().
                withDefaultFormats().withFormats(Format.CONSOLE, org.jbehave.core.reporters.Format.HTML));
    }

    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new ScoreboardSteps(scoreService));
    }

}

