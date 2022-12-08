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
import org.springframework.boot.test.context.SpringBootTest;
import steps.PlaySteps;


import java.util.List;

import static java.util.Arrays.asList;
import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

public class PlayStories extends ConfigurableEmbedder {
//
//    PendingStepStrategy pendingStepStrategy = new FailingUponPendingStep();
//    StoryReporterBuilder reporterBuilder = new StoryReporterBuilder()
//            .withCodeLocation(codeLocationFromClass(PlayStories.class)).withFailureTrace(true)
//            .withFailureTraceCompression(true).withDefaultFormats();

    public Embedder embedder;

    @Test
    public void run(){

//        StoryReporterBuilder reporterBuilder = new StoryReporterBuilder()
//                .withCodeLocation(codeLocationFromClass(PlayStories.class)).withFailureTrace(true)
//                .withFailureTraceCompression(true).withDefaultFormats();

    embedder = configuredEmbedder();
    embedder.configuration();

        System.out.println("runner");
        List<String> paths = List.of(
                "play.story"
        );

    embedder.runStoriesAsPaths(paths);


    }

    public Configuration configuration() {
        return new MostUsefulConfiguration().useStoryReporterBuilder(new StoryReporterBuilder().
                withDefaultFormats().withFormats(Format.CONSOLE));
    }


    public InjectableStepsFactory stepsFactory() {
        //ApplicationContext context =  new SpringApplicationContextFactory("test.xml").createApplicationContext();
        return new InstanceStepsFactory(configuration(), new PlaySteps());
    }

}