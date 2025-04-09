package functions;
import java.util.List;
import functions.History;


public class SearchOutput {
    private List<History> message;

    public SearchOutput() {}

    public SearchOutput(List<History> message) {
        this.message = message;
    }

    public List<History> getMessage() {
        return message;
    }

    public void setMessage(List<History> message) {
        this.message = message;
    }
}
