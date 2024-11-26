package mediator;

public interface MessageReceiver {
    void receiveMessage(String message, String sender);
}