package functions;

import functions.History;
import java.util.List;
import functions.Output;
import io.quarkus.funqy.Funq;
import io.quarkus.funqy.knative.events.CloudEvent;
import io.quarkus.funqy.knative.events.CloudEventBuilder;
import jakarta.transaction.Transactional;

@Transactional
public class Function {

    /**
     * Use the Quarkus Funq extension for the function. This example
     * function simply echoes its input data.
     * @param input a CloudEvent
     * @return a CloudEvent
     */
    @Funq
    public CloudEvent<Output> function(CloudEvent<Input> input) {

        System.out.println("About to write history data");
        History history = new History(input.data().getMessage());
        history.persist();
        return CloudEventBuilder.create().build(new Output("ok"));
    }
}