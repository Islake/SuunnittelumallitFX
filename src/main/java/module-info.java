module flyweight {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple; // Ensure you include all necessary JavaFX modules
    opens command to javafx.graphics;
}
