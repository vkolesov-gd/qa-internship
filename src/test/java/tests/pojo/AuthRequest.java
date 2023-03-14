package tests.pojo;

public class AuthRequest {
    String trelloKey;
    String trelloToken;

    public AuthRequest(String trelloKey, String trelloToken) {
        this.trelloKey = trelloKey;
        this.trelloToken = trelloToken;
    }

    public String getTrelloKey() {
        return trelloKey;
    }

    public String getTrelloToken() {
        return trelloToken;
    }
}
