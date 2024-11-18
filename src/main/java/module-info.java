module flyweight {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml; // Ensure you include all necessary JavaFX modules
    opens flyweight to javafx.graphics;
}
