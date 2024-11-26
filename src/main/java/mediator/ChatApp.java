package mediator;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChatApp extends Application {
    private ChatMediator mediator = new ChatMediatorImpl();

    @Override
    public void start(Stage primaryStage) {
        createChatClientWindow("User1");
        createChatClientWindow("User2");
        createChatClientWindow("User3");
    }

    private void createChatClientWindow(String username) {
        Stage stage = new Stage();
        stage.setTitle(username);

        ChatClient client = new ChatClient(username, mediator);

        TextArea messageArea = new TextArea();
        messageArea.setEditable(false);

        TextField messageField = new TextField();
        TextField recipientField = new TextField();
        recipientField.setPromptText("Recipient");

        Button sendButton = new Button("Send");
        sendButton.setOnAction(e -> {
            String message = messageField.getText();
            String recipient = recipientField.getText();
            client.sendMessage(message, recipient);
            messageField.clear();
        });

        client.setMessageReceiver((message, sender) -> {
            messageArea.appendText(sender + ": " + message + "\n");
        });

        VBox layout = new VBox(10, messageArea, recipientField, messageField, sendButton);
        layout.setPadding(new Insets(10));

        Scene scene = new Scene(layout, 300, 400);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}