module flyweight {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml; // Ensure you include all necessary JavaFX modules
    opens mediator to javafx.graphics;
}
