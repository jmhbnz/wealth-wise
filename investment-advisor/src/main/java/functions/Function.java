package functions;

import io.quarkus.funqy.Funq;
import functions.InvestmentAdvisorService;
import jakarta.inject.Inject;
import functions.Input;
import functions.Output;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

/**
 * Your Function class
 */
public class Function {

    @Inject
    InvestmentAdvisorService investmentAdvisorService;

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
        System.out.println("Getting investment based on: " + input.getMessage());

        // Emit a history message
        historyEmitter.send("{\"message\": \"" + input.getMessage() + "\"}");

        InvestmentAdvisorService.RiskLevel risk = InvestmentAdvisorService.RiskLevel.valueOf(input.getMessage());
        String response = investmentAdvisorService.recommend(risk);
        return new Output(response);
    }
}


