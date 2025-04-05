package functions;

import io.quarkus.funqy.Funq;
import functions.FinancialAdviserService;
import jakarta.inject.Inject;

/**
 * Your Function class
 */
public class Function {

    @Inject
    FinancialAdviserService financialAdviserService;

    /**
     * Use the Quarkus Funqy extension for our function. This function simply echoes its input
     * @param input a Java bean
     * @return a Java bean
     */
    @Funq
    public Output chat(Input input) {

        // Add business logic here
        System.out.println("Getting advice based on: " + input.getMessage());
        String response = financialAdviserService.chat(input.getMessage());
        return new Output(response);
    }
}