package command;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PixelArtEditorApp extends Application {
    private Editor editor;

    @Override
    public void start(Stage primaryStage) {
        Canvas canvas = new Canvas(400, 400);
        editor = new Editor(canvas);

        BorderPane root = new BorderPane();
        root.setCenter(canvas);

        VBox controls = new VBox();
        Button generateCodeButton = new Button("Generate Code");
        generateCodeButton.setOnAction(e -> System.out.println(editor.generateCode()));
        controls.getChildren().add(generateCodeButton);
        root.setRight(controls);

        Scene scene = new Scene(root, 500, 500);
        scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case UP -> new MoveCursorUpCommand(editor).execute();
                case DOWN -> new MoveCursorDownCommand(editor).execute();
                case LEFT -> new MoveCursorLeftCommand(editor).execute();
                case RIGHT -> new MoveCursorRightCommand(editor).execute();
                case SPACE -> new TogglePixelCommand(editor).execute();
            }
        });

        primaryStage.setTitle("Pixel Art Editor");
        primaryStage.setScene(scene);
        primaryStage.show();

        scene.getRoot().requestFocus();
    }

    public static void main(String[] args) {
        launch(args);
    }
}