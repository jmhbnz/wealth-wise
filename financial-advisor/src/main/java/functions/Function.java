package functions;

import functions.Input;
import functions.Output;
import io.quarkus.funqy.Funq;
import functions.FinancialAdviserService;
import jakarta.inject.Inject;
import java.util.UUID;
import io.smallrye.reactive.messaging.ce.OutgoingCloudEventMetadata;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Message;

/**
 * Your Function class
 */
public class Function {

    @Inject
    FinancialAdviserService financialAdviserService;

    // The env var KAFKA_BOOTSTRAP_SERVERS must be set to define the
    // Kafka bootstrap servers to send to.
    //
    @Channel("wealthwise-history")
    Emitter<String> historyEmitter;


    /**
     * Use the Quarkus Funqy extension for our function. This function simply echoes its input
     * @param input a Java bean
     * @return a Java bean
     */
    @Funq
    public Output chat(Input input) {

        System.out.println("Getting advice based on: " + input.getMessage());

        // Emit a history message as a CloudEvent
        Message<String> message = Message.of(input.getMessage());
        UUID uuid = UUID.randomUUID();
        message.addMetadata(OutgoingCloudEventMetadata.builder()
            .withId(uuid.toString())
            .withType("wealthwise-history")
            .withSubject("financial-advisor-history")
            .build());
        historyEmitter.send(message);

        // Now process the request
        String response = financialAdviserService.chat(input.getMessage());
        return new Output(response);
    }
}