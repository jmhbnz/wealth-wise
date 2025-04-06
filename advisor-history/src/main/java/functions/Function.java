package functions;

import io.quarkus.funqy.Funq;
import functions.History;
import java.util.List;
import functions.AddOutput;
import functions.SearchOutput;

/**
 * Your Function class
 */
public class Function {

    /**
     * Use the Quarkus Funqy extension for our function. This function simply echoes its input
     * @param input a Java bean
     * @return a Java bean
     */
    @Funq
    public AddOutput addHistory(Input input) {
        History history = new History(input.getMessage());
        history.persist();
        return new AddOutput("ok");
    }

    @Funq
    public SearchOutput getHistory() {
        List<History> h = History.findAllByOrderByTimestampDesc();
        return new SearchOutput(h);
    }
}
