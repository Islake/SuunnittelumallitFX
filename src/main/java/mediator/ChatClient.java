package mediator;

public class ChatClient implements MessageReceiver {
    private String username;
    private ChatMediator mediator;
    private MessageReceiver messageReceiver;

    public ChatClient(String username, ChatMediator mediator) {
        this.username = username;
        this.mediator = mediator;
        mediator.registerClient(this);
    }

    public String getUsername() {
        return username;
    }

    public void sendMessage(String message, String recipient) {
        mediator.sendMessage(message, username, recipient);
        // Display the sent message in the sender's chat window
        receiveMessage(message, username);
    }

    @Override
    public void receiveMessage(String message, String sender) {
        if (messageReceiver != null) {
            messageReceiver.receiveMessage(message, sender);
        }
    }

    public void setMessageReceiver(MessageReceiver messageReceiver) {
        this.messageReceiver = messageReceiver;
    }
}