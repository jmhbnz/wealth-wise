package functions;
import java.util.List;
import functions.History;


public class SearchOutput {
    private List<History> messages;

    public SearchOutput() {}

    public SearchOutput(List<History> messages) {
        this.messages = messages;
    }

    public List<History> getMessages() {
        return messages;
    }

    public void setMessages(List<History> messages) {
        this.messages = messages;
    }
}
