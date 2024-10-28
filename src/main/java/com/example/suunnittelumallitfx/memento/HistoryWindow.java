package com.example.suunnittelumallitfx.memento;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HistoryWindow {
    private final Controller controller;
    private final ListView<IMemento> listView;
    private final Label detailsLabel;

    public HistoryWindow(Controller controller) {
        this.controller = controller;
        this.listView = new ListView<>();
        this.detailsLabel = new Label("Select a state to see details");

        listView.getItems().addAll(controller.getHistory());

        listView.setCellFactory(param -> new ListCell<>() {
            @Override
            protected void updateItem(IMemento item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item.getTimestamp().toString());
                }
            }
        });

        listView.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                IMemento selectedMemento = listView.getSelectionModel().getSelectedItem();
                if (selectedMemento != null) {
                    controller.restoreState(selectedMemento);
                    detailsLabel.setText("Date: " + selectedMemento.getTimestamp() + "\n" +
                                         "Options: " + selectedMemento.getDescription() + "\n" +
                                         "State restored");
                }
            }
        });

        Label instructionLabel = new Label("Double-click to restore the chosen state");

        VBox vBox = new VBox(instructionLabel, listView, detailsLabel);
        Stage stage = new Stage();
        stage.setTitle("History");
        stage.setScene(new Scene(vBox, 400, 300));
        stage.show();
    }
}