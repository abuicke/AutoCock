package lt.soe.androidapp.server;

public class ServerResponse {

    public boolean successful;
    public String message;

    public ServerResponse() {

    }

    public ServerResponse(boolean successful, String message) {
        this.successful = successful;
        this.message = message;
    }
}
