package functions;

import io.quarkus.funqy.Funq;
import functions.InvestmentAdvisorService;
import jakarta.inject.Inject;

/**
 * Your Function class
 */
public class Function {

    @Inject
    InvestmentAdvisorService investmentAdvisorService;

    /**
     * Use the Quarkus Funqy extension for our function. This function simply echoes its input
     * @param input a Java bean
     * @return a Java bean
     */
    @Funq
    public Output chat(Input input) {

        // Add business logic here
        System.out.println("Getting investment based on: " + input.getMessage());
        InvestmentAdvisorService.RiskLevel risk = InvestmentAdvisorService.RiskLevel.valueOf(input.getMessage());
        String response = investmentAdvisorService.recommend(risk);
        return new Output(response);
    }
}