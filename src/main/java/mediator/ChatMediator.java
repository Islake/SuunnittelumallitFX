package mediator;

public interface ChatMediator {
    void registerClient(ChatClient client);
    void sendMessage(String message, String sender, String recipient);
}